package supplementary.experiments.ludemes.LudemeStateAnalysis.analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import game.Game;
import other.GameLoader;
import other.context.Context;
import other.state.State;
import other.state.StateRegistry;
import other.state.undo.UndoDataRegistry;
import other.trial.Trial;
import search.minimax.AlphaBetaSearch;


public final class CorpusBenchmark {

	private static final Set<String> ALLOWED_GENRES =
		new HashSet<>(Arrays.asList("board", "dominoes", "experimental", "math", "puzzle"));

	static int     WARMUP_MS          = 10_000;
	static int     WINDOW_MS          = 30_000;
	static int     NUM_THREADS        = 4;        // playout worker threads
	static int     AB_DEPTH           = 4;
	static int     AB_SEARCH_CAP_MS   = 4_000;    //
	static int     MAX_PLAYOUT_ACTIONS = 10_000;  // playout length cap
	static long    GAME_TIMEOUT_S     = 600;      // backstop for the whole game (both conditions)
	static boolean RUN_ALPHABETA      = true;
	static String  LUD_DIR = System.getenv().getOrDefault("LUD_DIR",
			"C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Common\\res\\lud");

	static volatile long sinkLong;

	static final String HEADER =
		"mode,game,state_class,undo_class," +
		"state_shallow_bytes,state_deep_bytes,state_deep_objects," +
		"undo_shallow_bytes,undo_deep_bytes,undo_deep_objects," +
		"copies,copies_per_sec,nanos_per_copy," +
		"moves,playouts,moves_per_sec,playouts_per_sec," +
		"ab_searches,ab_searches_per_sec,ab_note," +
		"threads,warmup_ms,window_ms,status";

	static final class Row {
		String mode, game, stateClass = "?", undoClass = "?", abNote = "", status = "OK";
		long stateShallow, stateDeep, stateDeepObj;
		long undoShallow, undoDeep, undoDeepObj;
		long copies, copiesPerSec, nanosPerCopy;
		long moves, playouts, movesPerSec, playoutsPerSec;
		long abSearches, abSearchesPerSec;

		Row(String mode, String game) { this.mode = mode; this.game = game; }

		String toCsv() {
			return String.format("%s,%s,%s,%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%s",
				mode, q(game), q(stateClass), q(undoClass),
				stateShallow, stateDeep, stateDeepObj,
				undoShallow, undoDeep, undoDeepObj,
				copies, copiesPerSec, nanosPerCopy,
				moves, playouts, movesPerSec, playoutsPerSec,
				abSearches, abSearchesPerSec, q(abNote),
				NUM_THREADS, WARMUP_MS, WINDOW_MS, status);
		}
		static String q(String s) { return s != null && s.indexOf(',') >= 0 ? "\"" + s + "\"" : s; }
	}

	// =====================================================================
	public static void main(String[] args) throws Exception {
		if (args.length < 3) {
			System.err.println("Usage: CorpusBenchmark <shardIndex> <numShards> <outCsv> [options]");
			System.exit(2);
		}
		final int shard     = Integer.parseInt(args[0]);
		final int numShards = Integer.parseInt(args[1]);
		final String csvPath = args[2];
		parseOptions(args);

		System.out.printf("Shard %d/%d  out=%s  threads=%d  warmup=%dms window=%dms  ab=%s depth=%d  lud=%s%n",
			shard, numShards, csvPath, NUM_THREADS, WARMUP_MS, WINDOW_MS,
			RUN_ALPHABETA ? "on" : "off", AB_DEPTH, LUD_DIR);

		File[] all = discoverGames();
		if (all == null || all.length == 0) {
			System.err.println("No games discovered under " + LUD_DIR + " (genres " + ALLOWED_GENRES + ")");
			System.exit(1);
		}
		Arrays.sort(all);   // identical order in every shard  nonoverlapping stride slices
		System.out.println("Discovered " + all.length + " games across the allowed genres.");

		final List<File> mine = new ArrayList<>();
		for (int i = shard; i < all.length; i += numShards) mine.add(all[i]);
		System.out.println("This shard owns " + mine.size() + " games.");

		final Set<String> done = loadDone(csvPath);
		if (!done.isEmpty()) System.out.println("Resume: skipping " + done.size() + " already-done games.");

		final boolean fresh = !new File(csvPath).exists() || new File(csvPath).length() == 0;
		try (PrintWriter out = new PrintWriter(new FileWriter(csvPath, true))) {
			if (fresh) { out.println(HEADER); out.flush(); }

			int n = 0;
			for (final File f : mine) {
				final String id = gameId(f);
				n++;
				if (done.contains(id)) { System.out.println("[" + n + "/" + mine.size() + "] skip " + id); continue; }

				System.out.println("[" + n + "/" + mine.size() + "] " + id);
				final long t0 = System.currentTimeMillis();
				for (Row r : runGameWithTimeout(f, id)) out.println(r.toCsv());
				out.flush();  
				System.out.printf("    done in %.1fs%n", (System.currentTimeMillis() - t0) / 1000.0);
			}
		}
		System.out.println("Shard " + shard + " complete.");
	}

	private static List<Row> runGameWithTimeout(final File f, final String id) {
		final ExecutorService exec = Executors.newSingleThreadExecutor(daemon("game-" + id));
		final Future<List<Row>> fut = exec.submit(() -> benchmarkGame(f, id));
		try {
			return fut.get(GAME_TIMEOUT_S, TimeUnit.SECONDS);
		} catch (TimeoutException te) {
			fut.cancel(true);
			System.err.println("    TIMEOUT: " + id);
			return failRows(id, "TIMEOUT");
		} catch (Throwable t) {
			System.err.println("    ERROR: " + id + " : " + t);
			return failRows(id, "FAILED");
		} finally {
			exec.shutdownNow();
		}
	}

	private static List<Row> failRows(String id, String status) {
		final List<Row> rows = new ArrayList<>();
		for (String mode : new String[] { "SPECIALIZED", "FULLSTATE" }) {
			Row r = new Row(mode, id); r.status = status; rows.add(r);
		}
		return rows;
	}

	private static List<Row> benchmarkGame(final File f, final String id) {
		final List<Row> rows = new ArrayList<>();
		for (final boolean spec : new boolean[] { true, false }) {
			final Row row = new Row(spec ? "SPECIALIZED" : "FULLSTATE", id);
			try {
				StateRegistry.useFullStateOnly      = !spec;
				UndoDataRegistry.useFullUndoDataOnly = !spec;

				final Game game = GameLoader.loadGameFromName(f.getName());
				if (game == null) { row.status = "LOAD_FAILED"; rows.add(row); continue; }

				final Trial trial = new Trial(game);
				final Context ctx = new Context(game, trial);
				game.start(ctx);

				final State state = ctx.state();
				row.stateClass = state.getClass().getSimpleName();
				final GraphLayout gameGraph = GraphLayout.parseInstance(game);

				jolState(state, gameGraph, row);
				jolUndo(game, ctx, gameGraph, row);
				copyThroughput(state, row);
				playout(game, row);
				if (RUN_ALPHABETA) alphaBeta(game, row);

			} catch (Throwable t) {
				row.status = "FAILED:" + t.getClass().getSimpleName();
				System.err.println("    [" + row.mode + "] " + id + " failed: " + t);
			}
			rows.add(row);
		}
		return rows;
	}

	private static void jolState(State state, GraphLayout gameGraph, Row row) {
		row.stateShallow = ClassLayout.parseInstance(state).instanceSize();
		GraphLayout g = GraphLayout.parseInstance(state).subtract(gameGraph);
		row.stateDeep = g.totalSize();
		row.stateDeepObj = g.totalCount();
	}

	private static void jolUndo(Game game, Context ctx, GraphLayout gameGraph, Row row) {
		try {
			final int active = activeMask(game, ctx);
			final int[] phases = phasesOf(game, ctx);
			final Object undo = game.createUndoData(ctx, active, phases);
			if (undo == null) { row.undoClass = "null"; return; }
			row.undoClass = undo.getClass().getSimpleName();
			row.undoShallow = ClassLayout.parseInstance(undo).instanceSize();
			GraphLayout g = GraphLayout.parseInstance(undo).subtract(gameGraph);
			row.undoDeep = g.totalSize();
			row.undoDeepObj = g.totalCount();
		} catch (Throwable t) {
			row.undoClass = "ERR:" + t.getClass().getSimpleName();
		}
	}

	/** Perplayer current phase array  */
	private static int[] phasesOf(Game game, Context ctx) {
		final int n = game.players().count();
		final int[] phases = new int[n + 1];
		for (int p = 1; p <= n; p++)
			phases[p] = ctx.state().currentPhase(p);
		return phases;
	}

	/** Activeplayers bitmask bit p set if player p is active. */
	private static int activeMask(Game game, Context ctx) {
		final int n = game.players().count();
		int mask = 0;
		for (int p = 1; p <= n; p++)
			if (ctx.active(p))
				mask |= (1 << p);
		return mask;
	}

	private static void copyThroughput(State src, Row row) {
		long checksum = 0;
		long warmEnd = System.currentTimeMillis() + WARMUP_MS;
		while (System.currentTimeMillis() < warmEnd) checksum ^= src.copy().stateHash();
		sinkLong = checksum;

		checksum = 0;
		long copies = 0;
		final long startNanos = System.nanoTime();
		final long deadline = System.currentTimeMillis() + WINDOW_MS;
		while (System.currentTimeMillis() < deadline)
			for (int i = 0; i < 1000; i++) { checksum ^= src.copy().stateHash(); copies++; }
		final long elapsed = System.nanoTime() - startNanos;
		row.copies = copies;
		row.copiesPerSec = Math.round(copies / (elapsed / 1e9));
		row.nanosPerCopy = Math.round((double) elapsed / copies);
		sinkLong = checksum;
	}

	private static void playout(final Game game, Row row) throws InterruptedException {
		final ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS, daemon("playout"));
		final AtomicLong totalMoves = new AtomicLong(), totalPlayouts = new AtomicLong();
		final CountDownLatch latch = new CountDownLatch(NUM_THREADS);
		for (int t = 0; t < NUM_THREADS; t++) {
			pool.submit(() -> {
				try {
					final Trial trial = new Trial(game);
					final Context ctx = new Context(game, trial);
					long warmEnd = System.currentTimeMillis() + WARMUP_MS;
					while (System.currentTimeMillis() < warmEnd) {
						trial.reset(game); game.start(ctx);
						game.playout(ctx, null, 1.0, null, 0, MAX_PLAYOUT_ACTIONS, ThreadLocalRandom.current());
					}
					long m = 0, p = 0;
					long deadline = System.currentTimeMillis() + WINDOW_MS;
					while (System.currentTimeMillis() < deadline) {
						trial.reset(game); game.start(ctx);
						game.playout(ctx, null, 1.0, null, 0, MAX_PLAYOUT_ACTIONS, ThreadLocalRandom.current());
						m += trial.numberRealMoves(); p++;
					}
					totalMoves.addAndGet(m); totalPlayouts.addAndGet(p);
				} catch (Throwable e) {
					System.err.println("    playout thread crashed: " + e);
				} finally { latch.countDown(); }
			});
		}
		latch.await();
		pool.shutdownNow();
		final double secs = WINDOW_MS / 1000.0;
		row.moves = totalMoves.get();
		row.playouts = totalPlayouts.get();
		row.movesPerSec = Math.round(row.moves / secs);
		row.playoutsPerSec = Math.round(row.playouts / secs);
	}

	//AlphAbeta throughput via the existing AlphaBetaSearch
	private static void alphaBeta(final Game game, Row row) {
		final AlphaBetaSearch ab = new AlphaBetaSearch();
		if (!ab.supportsGame(game)) { row.abNote = "UNSUPPORTED"; return; }
		try {
			ab.initAI(game, 1);
			final Trial trial = new Trial(game);
			final Context ctx = new Context(game, trial);
			game.start(ctx);
			final double capS = AB_SEARCH_CAP_MS / 1000.0;

			long warmEnd = System.currentTimeMillis() + WARMUP_MS;
			while (System.currentTimeMillis() < warmEnd)
				ab.selectAction(game, ctx, capS, -1, AB_DEPTH);

			long searches = 0;
			final long startNanos = System.nanoTime();
			final long deadline = System.currentTimeMillis() + WINDOW_MS;
			while (System.currentTimeMillis() < deadline) {
				ab.selectAction(game, ctx, capS, -1, AB_DEPTH);
				searches++;
			}
			final double secs = (System.nanoTime() - startNanos) / 1e9;
			row.abSearches = searches;
			row.abSearchesPerSec = Math.round(searches / secs);
		} catch (Throwable t) {
			row.abNote = "ERR:" + t.getClass().getSimpleName();
		}
	}

	private static File[] discoverGames() {
		try {
			final Path root = Paths.get(LUD_DIR);
			return Files.walk(root)
				.filter(p -> p.toString().endsWith(".lud"))
				.filter(p -> {
					Path rel = root.relativize(p);
					return rel.getNameCount() > 0 && ALLOWED_GENRES.contains(rel.getName(0).toString());
				})
				.map(Path::toFile)
				.toArray(File[]::new);
		} catch (IOException e) {
			System.err.println("Failed to walk lud dir: " + e.getMessage());
			return null;
		}
	}

	private static String gameId(File f) {
		String n = f.getName();
		return n.endsWith(".lud") ? n.substring(0, n.length() - 4) : n;
	}

	private static Set<String> loadDone(String csvPath) {
		final Set<String> done = new HashSet<>();
		final File f = new File(csvPath);
		if (!f.exists()) return done;
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line; boolean header = true;
			while ((line = br.readLine()) != null) {
				if (header) { header = false; continue; }
				if (line.isBlank()) continue;
				String[] parts = line.split(",", 3);
				if (parts.length >= 2) done.add(parts[1].replaceAll("^\"|\"$", ""));
			}
		} catch (IOException e) {
			System.err.println("Resume read failed: " + e.getMessage());
		}
		return done;
	}

	private static void parseOptions(String[] args) {
		for (int i = 3; i < args.length; i++) {
			switch (args[i]) {
				case "--threads":      NUM_THREADS = Integer.parseInt(args[++i]); break;
				case "--warmup-ms":    WARMUP_MS = Integer.parseInt(args[++i]); break;
				case "--window-ms":    WINDOW_MS = Integer.parseInt(args[++i]); break;
				case "--ab-depth":     AB_DEPTH = Integer.parseInt(args[++i]); break;
				case "--ab-cap-ms":    AB_SEARCH_CAP_MS = Integer.parseInt(args[++i]); break;
				case "--no-alphabeta": RUN_ALPHABETA = false; break;
				case "--max-actions":  MAX_PLAYOUT_ACTIONS = Integer.parseInt(args[++i]); break;
				case "--timeout-s":    GAME_TIMEOUT_S = Long.parseLong(args[++i]); break;
				case "--lud-dir":      LUD_DIR = args[++i]; break;
				default: System.err.println("Unknown option: " + args[i]);
			}
		}
	}

	private static ThreadFactory daemon(final String name) {
		return r -> { Thread t = new Thread(r, name); t.setDaemon(true); return t; };
	}

	private CorpusBenchmark() {}
}