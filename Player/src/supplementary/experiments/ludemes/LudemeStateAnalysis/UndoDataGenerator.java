package supplementary.experiments.ludemes.LudemeStateAnalysis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import game.Game;
import other.GameLoader;

//similar as subclass generator
public class UndoDataGenerator {

    private static final String OUTPUT_DIR =
        "C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Core\\src\\other\\state\\undo";

    private static final String LUD_DIR =
        "C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Common\\res\\lud";

    private static final Set<String> UNDO_PRUNABLE = Set.of(
        "pendingValues", "remainingDominoes", "visited", "sitesToRemove", "onTrackIndices"
    );

    static class R {
        final String decl, assign, getter;
        R(String d, String a, String g) { decl = d; assign = a; getter = g; }
    }

    static final Map<String, R> RECIPES = buildRecipes();

    private static Map<String, R> buildRecipes() {
        Map<String, R> m = new LinkedHashMap<>();
        m.put("pendingValues", new R(
            "private final gnu.trove.set.hash.TIntHashSet pendingValues;",
            "this.pendingValues = (context.state().pendingValues() == null) ? null : new gnu.trove.set.hash.TIntHashSet(context.state().pendingValues());",
            "@Override public gnu.trove.set.hash.TIntHashSet pendingValues() { return pendingValues; }"));
        m.put("remainingDominoes", new R(
            "private final main.collections.FastTIntArrayList remainingDominoes;",
            "this.remainingDominoes = (context.state().remainingDominoes() == null) ? null : new main.collections.FastTIntArrayList(context.state().remainingDominoes());",
            "@Override public main.collections.FastTIntArrayList remainingDominoes() { return remainingDominoes; }"));
        m.put("visited", new R(
            "private final java.util.BitSet visited;",
            "this.visited = (context.state().visited() == null) ? null : (java.util.BitSet) context.state().visited().clone();",
            "@Override public java.util.BitSet visited() { return visited; }"));
        m.put("sitesToRemove", new R(
            "private final gnu.trove.list.array.TIntArrayList sitesToRemove;",
            "this.sitesToRemove = (context.state().sitesToRemove() == null) ? null : new gnu.trove.list.array.TIntArrayList(context.state().sitesToRemove());",
            "@Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }"));
        m.put("onTrackIndices", new R(
            "private final other.state.track.OnTrackIndices onTrackIndices;",
            "this.onTrackIndices = (context.state().onTrackIndices() == null) ? null : new other.state.track.OnTrackIndices(context.state().onTrackIndices());",
            "@Override public other.state.track.OnTrackIndices onTrackIndices() { return onTrackIndices; }"));
        return m;
    }

    public static void main(String[] args) {
        if (args.length == 0) { generateAllFromDirectory(LUD_DIR, -1); return; }
        switch (args[0]) {
            case "--all":
                generateAllFromDirectory(LUD_DIR, args.length > 1 ? Integer.parseInt(args[1]) : -1);
                break;
            case "--single":
                if (args.length < 2) { System.err.println("Usage: --single <gameName>"); return; }
                generateSingle(args[1]);
                break;
            default:
                generateSingle(args[0]);
        }
    }

    public static void generateAllFromDirectory(String ludDirPath, int limit) {
        File[] ludFiles;
        try {
            ludFiles = Files.walk(Path.of(ludDirPath))
                .filter(p -> p.toString().endsWith(".lud"))
                .filter(p -> !p.toString().contains(File.separator + "test" + File.separator))
                .filter(p -> !p.toString().contains(File.separator + "bad" + File.separator))
                .filter(p -> !p.toString().contains(File.separator + "wip" + File.separator))
                .map(Path::toFile)
                .toArray(File[]::new);
        } catch (IOException e) {
            System.err.println("Failed to walk lud dir: " + e.getMessage());
            return;
        }
        if (ludFiles.length == 0) { System.err.println("No .lud files found at " + ludDirPath); return; }

        System.out.println("Found " + ludFiles.length + " .lud files");
        if (limit > 0 && limit < ludFiles.length) ludFiles = Arrays.copyOf(ludFiles, limit);

        Map<String, String> registered = new LinkedHashMap<>();
        Map<String, String> usedClassNames = new HashMap<>();
        int ok = 0, failed = 0, duplicate = 0, collided = 0;
        long t0 = System.currentTimeMillis();

        for (int i = 0; i < ludFiles.length; i++) {
            File ludFile = ludFiles[i];
            String fileNameNoExt = ludFile.getName().replace(".lud", "");
            try {
                Game game = GameLoader.loadGameFromName(ludFile.getName());
                if (game == null) { failed++; continue; }

                String gameName = game.name();
                if (registered.containsKey(gameName)) { duplicate++; continue; }

                String classPrefix = sanitizeClassName(gameName);
                if (classPrefix.isEmpty()) { failed++; continue; }
                if (usedClassNames.containsKey(classPrefix))
                    classPrefix = classPrefix + String.format("_%04d", collided++);
                usedClassNames.put(classPrefix, gameName);

                String shard = computeSubPackage(classPrefix);

                Set<String> stateNeeded = StateClassGenerator.neededFields(ludFile, game);
                Set<String> undoFields = new LinkedHashSet<>(stateNeeded);
                undoFields.retainAll(UNDO_PRUNABLE);

                writeSubclass(classPrefix, undoFields, shard);
                registered.put(gameName, "other.state.undo." + shard + "." + classPrefix + "UndoData");
                ok++;

                if ((i + 1) % 50 == 0) {
                    long el = (System.currentTimeMillis() - t0) / 1000;
                    System.out.println("  progress: " + (i + 1) + "/" + ludFiles.length
                        + " (ok=" + ok + " failed=" + failed + " dup=" + duplicate + " elapsed=" + el + "s)");
                }
            } catch (Throwable t) {
                System.err.println("[fail] " + fileNameNoExt + ": " + t.getClass().getSimpleName() + ": " + t.getMessage());
                failed++;
            }
        }

        System.out.println("\n=== UndoData generation complete ===");
        System.out.println("  generated:  " + ok);
        System.out.println("  failed:     " + failed + "  (fall back to FullUndoData at runtime)");
        System.out.println("  duplicate:  " + duplicate);
        System.out.println("  collisions: " + collided);

        try {
            writeRegistry(registered);
            System.out.println("Registry written with " + registered.size() + " entries.");
        } catch (IOException e) {
            System.err.println("Failed to write registry: " + e.getMessage());
        }
    }

    public static void generateSingle(String gameName) {
        String ludFileName = gameName.endsWith(".lud") ? gameName : gameName + ".lud";
        Game game = GameLoader.loadGameFromName(ludFileName);
        File ludFile = findLudFile(ludFileName);
        Set<String> undoFields = new LinkedHashSet<>(StateClassGenerator.neededFields(ludFile, game));
        undoFields.retainAll(UNDO_PRUNABLE);
        String classPrefix = sanitizeClassName(game.name());
        writeSubclass(classPrefix, undoFields, computeSubPackage(classPrefix));
        System.out.println("Detected UndoData prunable fields for " + game.name() + ": " + undoFields);
    }

    // ── code emission ────────────────────────────────────────────────────────

    private static void writeSubclass(String classPrefix, Set<String> fields, String shard) {
        String cls = classPrefix + "UndoData";
        String pkg = "other.state.undo." + shard;

        StringBuilder s = new StringBuilder();
        s.append("package ").append(pkg).append(";\n\n");
        s.append("import other.UndoData;\n");
        s.append("import other.context.Context;\n\n");
        s.append("/** Auto-generated UndoData subclass for ").append(classPrefix)
         .append(". Prunable fields: ").append(fields.isEmpty() ? "(none)" : String.join(", ", fields)).append(". */\n");
        s.append("public final class ").append(cls).append(" extends UndoData {\n\n");

        for (String f : fields) s.append("    ").append(RECIPES.get(f).decl).append("\n");
        if (!fields.isEmpty()) s.append("\n");

        s.append("    public ").append(cls).append("(final Context context, final int active, final int[] phases) {\n");
        s.append("        super(context, active, phases);\n");
        for (String f : fields) s.append("        ").append(RECIPES.get(f).assign).append("\n");
        s.append("    }\n");

        if (!fields.isEmpty()) {
            s.append("\n");
            for (String f : fields) s.append("    ").append(RECIPES.get(f).getter).append("\n");
        }
        s.append("}\n");

        try {
            Path dir = Path.of(OUTPUT_DIR, shard);
            Files.createDirectories(dir);
            Files.writeString(dir.resolve(cls + ".java"), s.toString());
        } catch (Exception e) {
            System.err.println("  FAILED writing " + cls + ": " + e.getMessage());
        }
    }

    private static void writeRegistry(Map<String, String> registered) throws IOException {
        StringBuilder s = new StringBuilder();
        s.append("package other.state.undo;\n\n");
        s.append("import java.util.HashMap;\n");
        s.append("import java.util.Map;\n\n");
        s.append("import other.UndoData;\n");
        s.append("import other.context.Context;\n\n");
        s.append("/** Auto-generated. game.name() -> specialized UndoData factory. */\n");
        s.append("public final class UndoDataRegistry {\n\n");
        s.append("    private UndoDataRegistry() { }\n\n");
        s.append("    /** Set true BEFORE loading a game to force the full fallback (benchmark baseline). */\n");
        s.append("    public static volatile boolean useFullUndoDataOnly = false;\n\n");
        s.append("    @FunctionalInterface\n");
        s.append("    public interface UndoDataFactory {\n");
        s.append("        UndoData create(Context context, int active, int[] phases);\n");
        s.append("    }\n\n");
        s.append("    public static final Map<String, UndoDataFactory> FACTORIES = new HashMap<>();\n\n");
        s.append("    static {\n");
        for (Map.Entry<String, String> e : registered.entrySet()) {
            s.append("        FACTORIES.put(\"").append(escape(e.getKey())).append("\", ")
             .append(e.getValue()).append("::new);\n");
        }
        s.append("    }\n\n");
        s.append("    public static UndoDataFactory factoryFor(final String gameName) {\n");
        s.append("        final UndoDataFactory f = FACTORIES.get(gameName);\n");
        s.append("        return (f != null) ? f : FullUndoData::new;\n");
        s.append("    }\n");
        s.append("}\n");

        Files.createDirectories(Path.of(OUTPUT_DIR));
        Files.writeString(Path.of(OUTPUT_DIR, "UndoDataRegistry.java"), s.toString());
    }

    // ── helpers (mirror StateClassGenerator so shards/names line up) ─────────

    private static String computeSubPackage(String classPrefix) {
        char c = Character.toLowerCase(classPrefix.charAt(0));
        return Character.isLetter(c) ? String.valueOf(c) : "x";
    }

    private static String sanitizeClassName(String gameName) {
        StringBuilder sb = new StringBuilder();
        boolean capNext = true;
        for (char c : gameName.toCharArray()) {
            if (Character.isLetterOrDigit(c)) { sb.append(capNext ? Character.toUpperCase(c) : c); capNext = false; }
            else capNext = true;
        }
        if (sb.length() == 0) return "";
        if (Character.isDigit(sb.charAt(0))) sb.insert(0, "G");
        return sb.toString();
    }

    private static String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private static File findLudFile(String ludFileName) {
        try {
            return Files.walk(Path.of(LUD_DIR))
                .filter(p -> p.getFileName().toString().equalsIgnoreCase(ludFileName))
                .findFirst().map(Path::toFile).orElse(null);
        } catch (IOException e) { return null; }
    }
}