package supplementary.experiments.ludemes.LudemeStateAnalysis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import game.Game;
import other.GameLoader;

public class StateClassGenerator {

    private static final String OUTPUT_DIR =
        "C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Core\\src\\other\\state";

    private static final String LUD_DIR =
        "C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Common\\res\\lud";

    private static final Set<String> BYTECODE_FIELDS = Set.of(
        "amount", "valuesPlayer", "propositions", "votes", "notes",
        "sitesToRemove", "rememberingValues", "mapRememberingValues", "valueMap"
    );

    @SuppressWarnings("unused")
    private static final Set<String> FLAG_FIELDS = Set.of(
        "sumDice", "currentDice", "diceAllEqual", "visited", "teams",
        "remainingDominoes", "pendingValues", "onTrackIndices"
    );

    public static void main(String[] args) {
        if (args.length == 0) {
            generateAllFromDirectory(LUD_DIR, -1);
            return;
        }

        switch (args[0]) {
            case "--fullstate":
                generateFullState();
                break;
            case "--all":
                int limit = args.length > 1 ? Integer.parseInt(args[1]) : -1;
                generateAllFromDirectory(LUD_DIR, limit);
                break;
            case "--single":
                if (args.length < 2) {
                    System.err.println("Usage: --single <gameName>");
                    return;
                }
                analyseAndGenerate(args[1]);
                break;
            case "--debug":
                if (args.length < 2) {
                    System.err.println("Usage: --debug <gameName>");
                    return;
                }
                debugAnalysis(args[1]);
                break;
            default:
                analyseAndGenerate(args[0]);
        }
    }
    public static void generateAllFromDirectory(String ludDirPath, int limit) {
        File ludDir = new File(ludDirPath);
        File[] ludFiles;
        try {
            ludFiles = Files.walk(ludDir.toPath())
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

        if (ludFiles.length == 0) {
            System.err.println("No .lud files found at " + ludDirPath);
            return;
        }

        System.out.println("Found " + ludFiles.length + " .lud files");
        if (limit > 0 && limit < ludFiles.length) {
            System.out.println("Limiting to first " + limit);
            ludFiles = Arrays.copyOf(ludFiles, limit);
        }

        generateFullState();

        Map<String, String> registered = new LinkedHashMap<>();
        Map<String, String> usedClassNames = new HashMap<>();

        int ok = 0, failed = 0, collided = 0, duplicate = 0;
        long t0 = System.currentTimeMillis();

        for (int i = 0; i < ludFiles.length; i++) {
            File ludFile = ludFiles[i];
            String fileNameNoExt = ludFile.getName().replace(".lud", "");

            try {
                Game game = GameLoader.loadGameFromName(ludFile.getName());
                if (game == null) {
                    System.err.println("[skip] null game: " + fileNameNoExt);
                    failed++;
                    continue;
                }

                String gameName = game.name();
                if (registered.containsKey(gameName)) {
                    duplicate++;
                    continue;
                }

                String classPrefix = sanitizeClassName(gameName);
                if (classPrefix.isEmpty()) {
                    System.err.println("[skip] unprintable name: " + gameName);
                    failed++;
                    continue;
                }

                if (usedClassNames.containsKey(classPrefix)) {
                    String suffix = String.format("_%04d", collided++);
                    classPrefix = classPrefix + suffix;
                }
                usedClassNames.put(classPrefix, gameName);

                String subPackage = computeSubPackage(classPrefix);
                Set<String> needed = analyseFields(ludFile, game);
                SubclassGenerator.generate(classPrefix, needed, OUTPUT_DIR, subPackage);

                registered.put(gameName, subPackage + "." + classPrefix);
                ok++;

                if ((i + 1) % 50 == 0) {
                    long elapsed = (System.currentTimeMillis() - t0) / 1000;
                    System.out.println("  progress: " + (i + 1) + "/" + ludFiles.length
                        + " (ok=" + ok + " failed=" + failed + " dup=" + duplicate
                        + " elapsed=" + elapsed + "s)");
                }
            } catch (Throwable t) {
                System.err.println("[fail] " + fileNameNoExt + ": " + t.getClass().getSimpleName()
                    + ": " + t.getMessage());
                failed++;
            }
        }

        long elapsed = (System.currentTimeMillis() - t0) / 1000;
        System.out.println();
        System.out.println("=== Generation complete ===");
        System.out.println("  generated:  " + ok);
        System.out.println("  failed:     " + failed);
        System.out.println("  duplicate:  " + duplicate);
        System.out.println("  collisions: " + collided);
        System.out.println("  elapsed:    " + elapsed + "s");

        try {
            StateRegistryGenerator.regenerate(registered, OUTPUT_DIR);
            System.out.println("Registry written with " + registered.size() + " entries.");
        } catch (IOException e) {
            System.err.println("Failed to write registry: " + e.getMessage());
        }
    }

    private static String computeSubPackage(String classPrefix) {
        char c = Character.toLowerCase(classPrefix.charAt(0));
        return Character.isLetter(c) ? String.valueOf(c) : "x";
    }

    public static void generateFullState() {
        Set<String> all = new LinkedHashSet<>();
        all.addAll(BYTECODE_FIELDS);
        all.addAll(FLAG_FIELDS);
        SubclassGenerator.generate("Full", all, OUTPUT_DIR);
        System.out.println("Generated FullState (" + all.size() + " fields)");
    }

    public static Set<String> analyseAndGenerate(String gameName) {
        String ludFileName = gameName.endsWith(".lud") ? gameName : gameName + ".lud";
        Game game = GameLoader.loadGameFromName(ludFileName);
        File ludFile = findLudFile(ludFileName);
        Set<String> needed = analyseFields(ludFile, game);
        String classPrefix = sanitizeClassName(game.name());
        String subPackage = computeSubPackage(classPrefix);
        SubclassGenerator.generate(classPrefix, needed, OUTPUT_DIR, subPackage);
        return needed;
    }

    public static void debugAnalysis(String gameName) {
        String ludFileName = gameName.endsWith(".lud") ? gameName : gameName + ".lud";
        Game game = GameLoader.loadGameFromName(ludFileName);
        File ludFile = findLudFile(ludFileName);

        System.out.println("=== Debug analysis: " + gameName + " ===");
        System.out.println("  game.name()                  = " + game.name());
        System.out.println("  lud file path                = " + (ludFile != null ? ludFile.getAbsolutePath() : "NOT FOUND"));
        System.out.println();
        System.out.println("  Flag values:");
        System.out.println("    hasHandDice()              = " + game.hasHandDice());
        System.out.println("    hasSequenceCapture()       = " + game.hasSequenceCapture());
        System.out.println("    usesVote()                 = " + game.usesVote());
        System.out.println("    usesNote()                 = " + game.usesNote());
        System.out.println("    requiresBet()              = " + game.requiresBet());
        System.out.println("    requiresVisited()          = " + game.requiresVisited());
        System.out.println("    requiresTeams()            = " + game.requiresTeams());
        System.out.println("    hasDominoes()              = " + game.hasDominoes());
        System.out.println("    usesPendingValues()        = " + game.usesPendingValues());
        System.out.println("    usesValueMap()             = " + game.usesValueMap());
        System.out.println("    hasTrack()                 = " + game.hasTrack());
        System.out.println("    hasInternalLoopInTrack()   = " + game.hasInternalLoopInTrack());
        System.out.println();

        Map<String, String> bytecodeVars = DynamicMemoryMapper.analyseGame(ludFileName);
        System.out.println("  Bytecode-detected fields: " + bytecodeVars.keySet());
        System.out.println();

        Set<String> needed = analyseFields(ludFile, game);
        System.out.println("  FINAL field set (" + needed.size() + "): " + needed);
    }

    private static File findLudFile(String ludFileName) {
        try {
            return Files.walk(Path.of(LUD_DIR))
                .filter(p -> p.getFileName().toString().equalsIgnoreCase(ludFileName))
                .findFirst()
                .map(Path::toFile)
                .orElse(null);
        } catch (IOException e) {
            return null;
        }
    }

    private static Set<String> analyseFields(File ludFile, Game game) {
        String ludFileName = (ludFile != null) ? ludFile.getName() : null;
        Map<String, String> bytecodeVars = (ludFileName != null)
            ? DynamicMemoryMapper.analyseGame(ludFileName)
            : Collections.emptyMap();
        Set<String> needed = new LinkedHashSet<>();

        for (String f : BYTECODE_FIELDS) {
            if (bytecodeVars.containsKey(f)) needed.add(f);
        }

        if (game.hasHandDice()) {
            needed.add("sumDice");
            needed.add("currentDice");
            needed.add("diceAllEqual");
        }
        if (game.usesVote()) {
            needed.add("propositions");
            needed.add("votes");
        }
        if (game.usesNote())            needed.add("notes");
        if (game.requiresBet())         needed.add("amount");
        if (game.requiresVisited())     needed.add("visited");
        if (game.requiresTeams())       needed.add("teams");
        if (game.hasDominoes())         needed.add("remainingDominoes");
        if (game.usesPendingValues())   needed.add("pendingValues");
        if (game.usesValueMap())        needed.add("valueMap");
        if (game.hasSequenceCapture())  needed.add("sitesToRemove");
        if (game.hasTrack() && game.hasInternalLoopInTrack()) needed.add("onTrackIndices");

        if (ludFile != null && ludFile.exists()) {
            try {
                String ludText = Files.readString(ludFile.toPath());

                if (ludText.contains("(dice") || ludText.contains("\"Dice\"")) {
                    needed.add("sumDice");
                    needed.add("currentDice");
                    needed.add("diceAllEqual");
                }

                if (ludText.contains("(remove ") || ludText.contains("(capture") || ludText.contains("Hop ")) {
                    needed.add("sitesToRemove");
                }

                if (ludText.contains("remember Value") || ludText.contains("(set Value")
                    || ludText.contains("(forget Value")) {
                    needed.add("mapRememberingValues");
                    needed.add("rememberingValues");
                    needed.add("valueMap");
                }
            } catch (Exception e) {
                System.err.println("  [warn] text scan failed for " + ludFile.getName() + ": " + e.getMessage());
            }
        }

        return needed;
    }

    private static String sanitizeClassName(String gameName) {
        StringBuilder sb = new StringBuilder();
        boolean capNext = true;
        for (char c : gameName.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(capNext ? Character.toUpperCase(c) : c);
                capNext = false;
            } else {
                capNext = true;
            }
        }
        if (sb.length() == 0) return "";
        if (Character.isDigit(sb.charAt(0))) sb.insert(0, "G");
        return sb.toString();
    }
    public static Set<String> neededFields(final File ludFile, final Game game) {
        return analyseFields(ludFile, game);
    }
}