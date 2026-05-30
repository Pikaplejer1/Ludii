package supplementary.experiments.ludemes.LudemeStateAnalysis.analysis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import game.Game;
import other.GameLoader;
import other.context.Context;
import other.state.State;
import other.state.StateRegistry;
import other.trial.Trial;

public class Analysis {

	// ── Configuration ────────────────────────────────────────────────────
	private static final int TEST_DURATION_MS = 5000;
	private static final int WARMUP_MS = 1000;
	private static final int NUM_THREADS = 12;

	private static final int COPY_BATCH_SIZE = 50_000;
	private static final int COPY_BATCH_ROUNDS = 5;

	private static final int COPY_THROUGHPUT_DURATION_MS = 3000;
	private static final int COPY_THROUGHPUT_WARMUP_MS = 500;

	private static final String CSV_PATH = "benchmark_results.csv";

	private static boolean DEBUG = false;

	private static volatile long sinkLong;
	private static volatile Object sinkObj;

	private static final String[] GAMES = {
		"Tic-Tac-Toe",
		"Backgammon",
		"Go",
		"Hex",
		"Reversi",
		"Breakthrough",
		"Amazons",
	};

	// ── Result row ───────────────────────────────────────────────────────
	private static final class Row {
		final String mode, game, stateClass;
		long shallowBytes, deepBytes, deepObjects, copyDeepBytes, copyDeepObjects;
		long bytesPerCopy, bytesPerCopyMin, bytesPerCopyMax;
		long copies, copiesPerSec, nanosPerCopy;
		long playouts, moves, movesPerSec, playoutsPerSec;

		Row(String mode, String game, String stateClass) {
			this.mode = mode; this.game = game; this.stateClass = stateClass;
		}
	}

	private static final List<Row> RESULTS = new ArrayList<>();
 
	// ══════════════════════════════════════════════════════════════════════
	public static void main(String[] args) {
		for (String arg : args) {
			if (arg.equals("--debug") || arg.equals("-d")) DEBUG = true;
		}

		System.out.println("========================================");
		System.out.println("THESIS BENCHMARK SUITE");
		System.out.println("Debug mode: " + (DEBUG ? "ON" : "OFF"));
		System.out.println("========================================\n");

		for (String gameName : GAMES) {
			for (final boolean specialized : new boolean[] { true, false }) {
				final String mode = specialized ? "SPECIALIZED" : "FULLSTATE";

				System.out.println("+--------------------------------------+");
				System.out.println("  " + gameName + "  [" + mode + "]");
				System.out.println("+--------------------------------------+\n");

				StateRegistry.useFullStateOnly = !specialized;

				final Game game = GameLoader.loadGameFromName(gameName + ".lud");

				final Trial probeTrial = new Trial(game);
				final Context probeCtx = new Context(game, probeTrial);
				game.start(probeCtx);

				final String stateClass = probeCtx.state().getClass().getSimpleName();
				System.out.println("State reference class: "
					+ game.stateReference().getClass().getSimpleName());
				System.out.println("Context state class:   " + stateClass);
				System.out.println();

				final Row row = new Row(mode, gameName, stateClass);

				if (DEBUG) runDebugPlayout(game);

				runJolMemory(game, probeCtx.state(), row);
				runPerStateCopyMemory(game, probeCtx.state(), row);
				runCopyThroughput(game, probeCtx.state(), row);
				runPlayoutThroughput(game, row);

				RESULTS.add(row);
				System.out.println();
			}
		}

		writeCsv();

		System.out.println("========================================");
		System.out.println("ALL BENCHMARKS COMPLETE");
		System.out.println("CSV written to: " + CSV_PATH);
		System.out.println("========================================");
	}

	// ── JOL ──────────────────────────────────────────────────────────────
	private static void runJolMemory(Game game, State sourceState, Row row) {
		System.out.println("--- JOL Memory: " + game.name() + " ---");

		final Trial trial = new Trial(game);
		final Context context = new Context(game, trial);
		game.start(context);
		State warmedState = context.state();

		long shallowBytes = ClassLayout.parseInstance(warmedState).instanceSize();

		GraphLayout graph = GraphLayout.parseInstance(warmedState)
			.subtract(GraphLayout.parseInstance(game));
		long deepBytes = graph.totalSize();
		long objectCount = graph.totalCount();

		State copy = warmedState.copy();
		GraphLayout copyGraph = GraphLayout.parseInstance(copy)
			.subtract(GraphLayout.parseInstance(game));
		long copyDeepBytes = copyGraph.totalSize();
		long copyObjectCount = copyGraph.totalCount();

		row.shallowBytes = shallowBytes;
		row.deepBytes = deepBytes;
		row.deepObjects = objectCount;
		row.copyDeepBytes = copyDeepBytes;
		row.copyDeepObjects = copyObjectCount;

		System.out.println("State class:            " + warmedState.getClass().getSimpleName());
		System.out.println("Shallow size:           " + shallowBytes + " bytes");
		System.out.println("Deep size (state-only): " + deepBytes + " bytes (" + objectCount + " objects)");
		System.out.println("Copy deep size:         " + copyDeepBytes + " bytes (" + copyObjectCount + " objects)");
		System.out.println();
	}

	// ── Per-copy memory ──────────────────────────────────────────────────
	private static void runPerStateCopyMemory(Game game, State sourceState, Row row) {
		System.out.println("--- Per-State-Copy Memory: " + game.name() + " ---");
		try {
			long totalBytes = 0;
			long minBytes = Long.MAX_VALUE;
			long maxBytes = Long.MIN_VALUE;

			for (int round = 0; round < COPY_BATCH_ROUNDS; round++) {
				State[] copies = new State[COPY_BATCH_SIZE];

				System.gc();
				System.gc();
				Thread.sleep(150);
				long before = usedMemory();

				for (int i = 0; i < COPY_BATCH_SIZE; i++) {
					copies[i] = sourceState.copy();
				}

				long after = usedMemory();
				long delta = after - before;
				long perCopy = delta / COPY_BATCH_SIZE;

				totalBytes += perCopy;
				minBytes = Math.min(minBytes, perCopy);
				maxBytes = Math.max(maxBytes, perCopy);

				debug("  Round " + (round + 1) + ": " + perCopy + " bytes/copy"
					+ " (delta: " + String.format("%,d", delta) + " bytes)");

				sinkObj = copies;
			}

			long avgBytes = totalBytes / COPY_BATCH_ROUNDS;
			row.bytesPerCopy = avgBytes;
			row.bytesPerCopyMin = minBytes;
			row.bytesPerCopyMax = maxBytes;

			System.out.println("Bytes per state copy:  " + avgBytes
				+ "  (min=" + minBytes + ", max=" + maxBytes + ")");
			System.out.println();

		} catch (Exception e) {
			System.err.println("Per-state memory benchmark failed: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// ── Copy throughput ──────────────────────────────────────────────────
	private static void runCopyThroughput(Game game, State sourceState, Row row) {
		System.out.println("--- Copy Throughput: " + game.name() + " ---");
		try {
			long checksum = 0;
			long warmupEnd = System.currentTimeMillis() + COPY_THROUGHPUT_WARMUP_MS;
			while (System.currentTimeMillis() < warmupEnd) {
				State copy = sourceState.copy();
				checksum ^= copy.stateHash();
			}
			sinkLong = checksum;

			checksum = 0;
			long copies = 0;
			long startNanos = System.nanoTime();
			long deadline = System.currentTimeMillis() + COPY_THROUGHPUT_DURATION_MS;

			while (System.currentTimeMillis() < deadline) {
				for (int i = 0; i < 1000; i++) {
					State copy = sourceState.copy();
					checksum ^= copy.stateHash();
					copies++;
				}
			}

			long elapsedNanos = System.nanoTime() - startNanos;
			double elapsedSecs = elapsedNanos / 1_000_000_000.0;
			long copiesPerSec = Math.round(copies / elapsedSecs);
			long nanosPerCopy = Math.round((double) elapsedNanos / copies);

			row.copies = copies;
			row.copiesPerSec = copiesPerSec;
			row.nanosPerCopy = nanosPerCopy;

			System.out.println("Total copies:    " + String.format("%,d", copies));
			System.out.println("Copies/sec:      " + String.format("%,d", copiesPerSec));
			System.out.println("Nanos/copy:      " + nanosPerCopy);

			sinkLong = checksum;
			System.out.println();

		} catch (Exception e) {
			System.err.println("Copy throughput benchmark failed: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// ── Playout throughput ───────────────────────────────────────────────
	private static void runPlayoutThroughput(Game game, Row row) {
		System.out.println("--- Playout Throughput: " + game.name() + " ---");
		System.out.println("Threads: " + NUM_THREADS + ", Duration: " + TEST_DURATION_MS + "ms");
		try {
			final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
			final AtomicLong totalMoves = new AtomicLong(0);
			final AtomicLong totalPlayouts = new AtomicLong(0);
			final CountDownLatch latch = new CountDownLatch(NUM_THREADS);

			for (int t = 0; t < NUM_THREADS; t++) {
				executor.submit(() -> {
					try {
						final Trial trial = new Trial(game);
						final Context context = new Context(game, trial);
						long threadMoves = 0;
						long threadPlayouts = 0;

						long warmupEnd = System.currentTimeMillis() + WARMUP_MS;
						while (System.currentTimeMillis() < warmupEnd) {
							trial.reset(game);
							game.start(context);
							game.playout(context, null, 1.0, null, 0, -1,
								ThreadLocalRandom.current());
						}

						long deadline = System.currentTimeMillis() + TEST_DURATION_MS;
						while (System.currentTimeMillis() < deadline) {
							trial.reset(game);
							game.start(context);
							game.playout(context, null, 1.0, null, 0, -1,
								ThreadLocalRandom.current());
							threadMoves += trial.numberRealMoves();
							threadPlayouts++;
						}

						totalMoves.addAndGet(threadMoves);
						totalPlayouts.addAndGet(threadPlayouts);

					} catch (Exception e) {
						System.err.println("Benchmark thread crashed: " + e.getMessage());
						e.printStackTrace();
					} finally {
						latch.countDown();
					}
				});
			}

			latch.await();
			executor.shutdown();

			long moves = totalMoves.get();
			long playouts = totalPlayouts.get();
			double seconds = TEST_DURATION_MS / 1000.0;
			long movesPerSec = Math.round(moves / seconds);
			long playoutsPerSec = Math.round(playouts / seconds);

			row.moves = moves;
			row.playouts = playouts;
			row.movesPerSec = movesPerSec;
			row.playoutsPerSec = playoutsPerSec;

			System.out.println("Total moves:     " + String.format("%,d", moves));
			System.out.println("Total playouts:  " + String.format("%,d", playouts));
			System.out.println("Moves/sec:       " + String.format("%,d", movesPerSec));
			System.out.println("Playouts/sec:    " + String.format("%,d", playoutsPerSec));
			System.out.println();

		} catch (Exception e) {
			System.err.println("Playout benchmark failed: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// ── Debug single playout ─────────────────────────────────────────────
	private static void runDebugPlayout(Game game) {
		System.out.println("[DEBUG] Running single traced playout");
		final Trial trial = new Trial(game);
		final Context context = new Context(game, trial);

		game.start(context);
		System.out.println("[DEBUG] After start: mover=" + context.state().mover()
			+ " next=" + context.state().next()
			+ " prev=" + context.state().prev()
			+ " hash=" + context.state().stateHash());

		int moveCount = 0;
		final int MAX_MOVES = 200;

		while (!trial.over() && moveCount < MAX_MOVES) {
			final var legal = game.moves(context);
			System.out.println("[DEBUG] Move " + moveCount
				+ ": " + legal.count() + " legal, mover="
				+ context.state().mover());

			if (legal.count() == 0) {
				System.out.println("[DEBUG] No legal moves but game not over");
				break;
			}

			int idx = ThreadLocalRandom.current().nextInt(legal.count());
			final var move = legal.moves().get(idx);
			System.out.println("[DEBUG] Applying: " + move);
			game.apply(context, move);
			moveCount++;
		}

		if (moveCount >= MAX_MOVES) {
			System.out.println("[DEBUG] game never ended within: " + MAX_MOVES);
		} else {
			System.out.println("[DEBUG] Game ended after " + moveCount + " moves");
		}
		System.out.println();
	}

	// ── CSV ──────────────────────────────────────────────────────────────
	private static void writeCsv() {
		try (PrintWriter w = new PrintWriter(new FileWriter(CSV_PATH))) {
			w.println("mode,game,state_class,"
				+ "shallow_bytes,deep_bytes,deep_objects,copy_deep_bytes,copy_deep_objects,"
				+ "bytes_per_copy,bytes_per_copy_min,bytes_per_copy_max,"
				+ "copies,copies_per_sec,nanos_per_copy,"
				+ "moves,playouts,moves_per_sec,playouts_per_sec");
			for (Row r : RESULTS) {
				w.printf("%s,%s,%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d%n",
					r.mode, r.game, r.stateClass,
					r.shallowBytes, r.deepBytes, r.deepObjects, r.copyDeepBytes, r.copyDeepObjects,
					r.bytesPerCopy, r.bytesPerCopyMin, r.bytesPerCopyMax,
					r.copies, r.copiesPerSec, r.nanosPerCopy,
					r.moves, r.playouts, r.movesPerSec, r.playoutsPerSec);
			}
		} catch (Exception e) {
			System.err.println("CSV write failed: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static long usedMemory() {
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}

	private static void debug(String msg) {
		if (DEBUG) System.out.println("[DEBUG] " + msg);
	}
}