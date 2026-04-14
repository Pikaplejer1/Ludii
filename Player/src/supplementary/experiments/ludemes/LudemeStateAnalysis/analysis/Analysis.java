package supplementary.experiments.ludemes.LudemeStateAnalysis.analysis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import game.Game;
import other.GameLoader;
import other.context.Context;
import other.state.State;
import other.trial.Trial;

public class Analysis {

	// ── Configuration ────────────────────────────────────────────────────
	private static final int TEST_DURATION_MS = 5000;
	private static final int WARMUP_MS = 1000;
	private static final int NUM_THREADS = 12;

	// Per-state-copy benchmark
	private static final int COPY_BATCH_SIZE = 50_000;
	private static final int COPY_BATCH_ROUNDS = 5;

	// Copy throughput benchmark
	private static final int COPY_THROUGHPUT_DURATION_MS = 3000;
	private static final int COPY_THROUGHPUT_WARMUP_MS = 500;

	private static boolean DEBUG = false;

	// Volatile sink — prevents JIT from eliminating dead code
	private static volatile long sinkLong;
	private static volatile Object sinkObj;

	// ── Games to benchmark ───────────────────────────────────────────────
	private static final String[] GAMES = {
		"Tic-Tac-Toe",
//		"Go",
//		"Hex",
//		"Reversi",
//		"Breakthrough",
//		"Amazons",
	};

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
			System.out.println("+--------------------------------------+");
			System.out.println("  " + gameName);
			System.out.println("+--------------------------------------+\n");

			final Game game = GameLoader.loadGameFromName(gameName + ".lud");

			// Show which State classes the engine is actually using
			final Trial probeTrial = new Trial(game);
			final Context probeCtx = new Context(game, probeTrial);
			game.start(probeCtx);
			System.out.println("State reference class: "
				+ game.stateReference().getClass().getSimpleName());
			System.out.println("Context state class:   "
				+ probeCtx.state().getClass().getSimpleName());
			System.out.println();

			if (DEBUG) {
				runDebugPlayout(game);
			}

			runPerStateCopyMemory(game, probeCtx.state());
			runCopyThroughput(game, probeCtx.state());
			runPlayoutThroughput(game);

			System.out.println();
		}

		System.out.println("========================================");
		System.out.println("ALL BENCHMARKS COMPLETE");
		System.out.println("========================================");
	}

	// ══════════════════════════════════════════════════════════════════════
	// BENCHMARK 1: Per-State-Copy Memory
	//
	// Measures actual bytes consumed by one state.copy().
	// Each MCTS node = one copy, so this is your per-node memory cost.
	//
	// Method: allocate the empty array first, GC, measure baseline,
	// then fill the array with copies, measure again. No GC after
	// filling — that was corrupting the measurement.
	// ══════════════════════════════════════════════════════════════════════

	private static void runPerStateCopyMemory(Game game, State sourceState) {
		System.out.println("--- Per-State-Copy Memory: " + game.name() + " ---");
		try {
			long totalBytes = 0;
			long minBytes = Long.MAX_VALUE;
			long maxBytes = Long.MIN_VALUE;

			for (int round = 0; round < COPY_BATCH_ROUNDS; round++) {
				// Allocate the array FIRST (so array overhead is not counted)
				State[] copies = new State[COPY_BATCH_SIZE];

				// GC to get a clean baseline, then measure
				System.gc();
				System.gc();
				Thread.sleep(150);
				long before = usedMemory();

				// Fill the array — all references held, GC cannot collect
				for (int i = 0; i < COPY_BATCH_SIZE; i++) {
					copies[i] = sourceState.copy();
				}

				// Measure immediately — NO GC here
				long after = usedMemory();
				long delta = after - before;
				long perCopy = delta / COPY_BATCH_SIZE;

				totalBytes += perCopy;
				minBytes = Math.min(minBytes, perCopy);
				maxBytes = Math.max(maxBytes, perCopy);

				debug("  Round " + (round + 1) + ": " + perCopy + " bytes/copy"
					+ " (delta: " + String.format("%,d", delta) + " bytes)");

				// Keep the array alive past the measurement
				sinkObj = copies;
			}

			long avgBytes = totalBytes / COPY_BATCH_ROUNDS;

			System.out.println("Bytes per state copy:  " + avgBytes
				+ "  (min=" + minBytes + ", max=" + maxBytes + ")");
			System.out.println();

		} catch (Exception e) {
			System.err.println("Per-state memory benchmark failed: " + e.getMessage());
			e.printStackTrace();
		}
	}



	private static void runCopyThroughput(Game game, State sourceState) {
		System.out.println("--- Copy Throughput: " + game.name() + " ---");
		try {
			// Warmup — let JIT compile the copy path fully
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

			System.out.println("Total copies:    " + String.format("%,d", copies));
			System.out.println("Copies/sec:      " + String.format("%,d", copiesPerSec));
			System.out.println("Nanos/copy:      " + nanosPerCopy);

			// Consume checksum so JIT can't eliminate anything above
			sinkLong = checksum;
			System.out.println();

		} catch (Exception e) {
			System.err.println("Copy throughput benchmark failed: " + e.getMessage());
			e.printStackTrace();
		}
	}


	private static void runPlayoutThroughput(Game game) {
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
			System.out.println("[DEBUG] game never ended within: "+ MAX_MOVES);
		} else {
			System.out.println("[DEBUG] Game ended after " + moveCount + " moves");
		}
		System.out.println();
	}

	// ── Utility ──────────────────────────────────────────────────────────

	private static long usedMemory() {
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}

	private static void debug(String msg) {
		if (DEBUG) System.out.println("[DEBUG] " + msg);
	}
}