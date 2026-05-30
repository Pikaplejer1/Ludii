package supplementary.experiments.ludemes.LudemeStateAnalysis.analysis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import game.Game;
import other.GameLoader;
import other.context.Context;
import other.trial.Trial;

/**
 * Smoke test: try to play one full random playout of every game in the corpus.
 * Records pass/fail/timeout/exception per game to a CSV.
 *
 * Output file: ./playout_smoketest.csv
 *
 * This validates that:
 *   - The game loads via GameLoader
 *   - The dispatch path picks the right State (or falls back to FullState)
 *   - A full random playout completes without throwing
 *
 * Failure modes are caught and logged, not propagated, so one broken game
 * doesn't kill the rest of the batch.
 */
public class PlayoutSmokeTest {

    private static final String LUD_DIR =
        "C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Common\\res\\lud";

    private static final String OUTPUT_CSV = "playout_smoketest.csv";

    /** Per-game timeout in milliseconds. Some games are pathological and never end. */
    private static final long PLAYOUT_TIMEOUT_MS = 10_000;

    /** Hard cap on moves per playout. Prevents infinite playouts dominating wall time. */
    private static final int MAX_MOVES_PER_PLAYOUT = 5_000;

    private enum Status { OK, LOAD_FAIL, START_FAIL, PLAYOUT_FAIL, TIMEOUT, MOVE_LIMIT }

    private static class Result {
        final String fileName;
        final String gameName;
        final String stateClass;
        final Status status;
        final int movesPlayed;
        final long durationMs;
        final String errorMsg;

        Result(String fileName, String gameName, String stateClass,
               Status status, int movesPlayed, long durationMs, String errorMsg) {
            this.fileName = fileName;
            this.gameName = gameName;
            this.stateClass = stateClass;
            this.status = status;
            this.movesPlayed = movesPlayed;
            this.durationMs = durationMs;
            this.errorMsg = errorMsg;
        }
    }

    public static void main(String[] args) {
        int limit = -1;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--limit") && i + 1 < args.length) {
                limit = Integer.parseInt(args[i + 1]);
            }
        }

        System.out.println("========================================");
        System.out.println("PLAYOUT SMOKE TEST");
        System.out.println("Timeout: " + PLAYOUT_TIMEOUT_MS + " ms / game");
        System.out.println("Move cap: " + MAX_MOVES_PER_PLAYOUT);
        System.out.println("========================================\n");

        File[] ludFiles = collectLudFiles();
        if (ludFiles == null || ludFiles.length == 0) {
            System.err.println("No .lud files found at " + LUD_DIR);
            return;
        }

        if (limit > 0 && limit < ludFiles.length) {
            System.out.println("Limit: " + limit + " (of " + ludFiles.length + " total)");
            File[] truncated = new File[limit];
            System.arraycopy(ludFiles, 0, truncated, 0, limit);
            ludFiles = truncated;
        } else {
            System.out.println("Total games: " + ludFiles.length);
        }
        System.out.println();

        List<Result> results = new ArrayList<>(ludFiles.length);
        long batchStart = System.currentTimeMillis();
        int ok = 0, loadFail = 0, startFail = 0, playoutFail = 0, timeout = 0, moveCap = 0;

        for (int i = 0; i < ludFiles.length; i++) {
            File f = ludFiles[i];
            Result r = runOne(f);
            results.add(r);

            switch (r.status) {
                case OK:           ok++; break;
                case LOAD_FAIL:    loadFail++; break;
                case START_FAIL:   startFail++; break;
                case PLAYOUT_FAIL: playoutFail++; break;
                case TIMEOUT:      timeout++; break;
                case MOVE_LIMIT:   moveCap++; break;
            }

            if (r.status != Status.OK) {
                System.err.println("[" + r.status + "] " + r.fileName
                    + " (" + r.movesPlayed + " moves, " + r.durationMs + "ms): " + r.errorMsg);
            }

            if ((i + 1) % 50 == 0) {
                long elapsed = (System.currentTimeMillis() - batchStart) / 1000;
                System.out.println("  progress: " + (i + 1) + "/" + ludFiles.length
                    + " (ok=" + ok + " fail=" + (loadFail + startFail + playoutFail)
                    + " timeout=" + timeout + " moveCap=" + moveCap
                    + " elapsed=" + elapsed + "s)");
            }
        }

        long totalElapsed = (System.currentTimeMillis() - batchStart) / 1000;
        System.out.println();
        System.out.println("========================================");
        System.out.println("Smoke test complete (" + totalElapsed + "s)");
        System.out.println("  total:        " + results.size());
        System.out.println("  ok:           " + ok);
        System.out.println("  load fail:    " + loadFail);
        System.out.println("  start fail:   " + startFail);
        System.out.println("  playout fail: " + playoutFail);
        System.out.println("  timeout:      " + timeout);
        System.out.println("  move cap:     " + moveCap);
        System.out.println("========================================");

        writeCsv(results);
    }

    private static final List<String> ALLOWED_DIRS = List.of(
    	    "board", "dominoes", "experimental", "math", "puzzle" + File.separator + "deduction"
    	);

    	private static File[] collectLudFiles() {
    		try {
    	        return Files.walk(Paths.get(LUD_DIR))
    	            .filter(p -> p.toString().endsWith(".lud"))
    	            .filter(p -> !p.toString().contains(File.separator + "test" + File.separator))
    	            .filter(p -> !p.toString().contains(File.separator + "bad" + File.separator))
    	            .filter(p -> !p.toString().contains(File.separator + "wip" + File.separator))
    	            .filter(p -> {
    	                String path = p.toString();
    	                return ALLOWED_DIRS.stream().anyMatch(dir ->
    	                    path.contains(File.separator + dir + File.separator) ||
    	                    path.contains(File.separator + dir)
    	                );
    	            })
    	            .map(Path::toFile)
    	            .toArray(File[]::new);
    	    } catch (IOException e) {
    	        System.err.println("Failed to walk lud dir: " + e.getMessage());
    	        return null;
    	    }
    	}

    private static Result runOne(File ludFile) {
        String fileName = ludFile.getName().replace(".lud", "");
        long start = System.currentTimeMillis();

        // Stage 1: load
        Game game;
        try {
            game = GameLoader.loadGameFromName(ludFile.getName());
            if (game == null) {
                return new Result(fileName, fileName, "", Status.LOAD_FAIL, 0,
                    System.currentTimeMillis() - start, "GameLoader returned null");
            }
        } catch (Throwable t) {
            return new Result(fileName, fileName, "", Status.LOAD_FAIL, 0,
                System.currentTimeMillis() - start,
                t.getClass().getSimpleName() + ": " + safeMsg(t));
        }

        String gameName = game.name();
        String stateClass = "?";

        // Stage 2: start
        Trial trial;
        Context context;
        try {
            trial = new Trial(game);
            context = new Context(game, trial);
//            System.out.println("[" + ludFile.getName() + "] dispatched to " 
//            	    + context.state().getClass().getSimpleName());
            game.start(context);
            stateClass = context.state().getClass().getSimpleName();
        } catch (Throwable t) {
            return new Result(fileName, gameName, stateClass, Status.START_FAIL, 0,
                System.currentTimeMillis() - start,
                t.getClass().getSimpleName() + ": " + safeMsg(t));
        }

        // Stage 3: random playout, manual loop with timeout + move cap
        long deadline = start + PLAYOUT_TIMEOUT_MS;
        int moves = 0;
        try {
            while (!trial.over()) {
                if (System.currentTimeMillis() > deadline) {
                    return new Result(fileName, gameName, stateClass, Status.TIMEOUT,
                        moves, System.currentTimeMillis() - start,
                        "exceeded " + PLAYOUT_TIMEOUT_MS + "ms");
                }
                if (moves >= MAX_MOVES_PER_PLAYOUT) {
                    return new Result(fileName, gameName, stateClass, Status.MOVE_LIMIT,
                        moves, System.currentTimeMillis() - start,
                        "exceeded " + MAX_MOVES_PER_PLAYOUT + " moves");
                }

                final var legal = game.moves(context);
                if (legal.count() == 0) {
                    // Forced pass / dead-end — engine should normally end the trial.
                    break;
                }
                final int idx = ThreadLocalRandom.current().nextInt(legal.count());
                game.apply(context, legal.moves().get(idx));
                moves++;
            }
        } catch (Throwable t) {
            return new Result(fileName, gameName, stateClass, Status.PLAYOUT_FAIL, moves,
                System.currentTimeMillis() - start,
                t.getClass().getSimpleName() + ": " + safeMsg(t));
        }

        return new Result(fileName, gameName, stateClass, Status.OK, moves,
            System.currentTimeMillis() - start, "");
    }

    private static String safeMsg(Throwable t) {
        String m = t.getMessage();
        if (m == null) return "(no message)";
        return m.replace(",", ";").replace("\n", " ").replace("\r", " ");
    }

    private static void writeCsv(List<Result> results) {
        StringBuilder sb = new StringBuilder();
        sb.append("file,gameName,stateClass,status,moves,durationMs,error\n");
        for (Result r : results) {
            sb.append(escape(r.fileName)).append(",");
            sb.append(escape(r.gameName)).append(",");
            sb.append(escape(r.stateClass)).append(",");
            sb.append(r.status).append(",");
            sb.append(r.movesPlayed).append(",");
            sb.append(r.durationMs).append(",");
            sb.append(escape(r.errorMsg)).append("\n");
        }
        try {
            Path out = Paths.get(OUTPUT_CSV).toAbsolutePath();
            Files.writeString(out, sb.toString());
            System.out.println("CSV written: " + out);
        } catch (IOException e) {
            System.err.println("Failed to write CSV: " + e.getMessage());
        }
    }

    private static String escape(String s) {
        if (s == null) return "";
        return s.replace(",", ";").replace("\n", " ").replace("\r", " ");
    }
}