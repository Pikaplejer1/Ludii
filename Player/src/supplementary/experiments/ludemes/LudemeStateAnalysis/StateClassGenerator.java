package supplementary.experiments.ludemes.LudemeStateAnalysis;

import java.nio.file.Path;
import java.util.*;

import game.Game;
import other.GameLoader;

public class StateClassGenerator {

    private static final String OUTPUT_DIR =
        "C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Core\\src\\other\\state";

    private static final Set<String> BYTECODE_FIELDS = Set.of(
        "amount", "valuesPlayer", "propositions", "votes", "notes",
        "sitesToRemove", "rememberingValues", "mapRememberingValues", "valueMap"
    );

    private static final Set<String> FLAG_FIELDS = Set.of(
        "sumDice", "currentDice", "diceAllEqual", "visited", "teams",
        "remainingDominoes", "pendingValues", "onTrackIndices"
    );

    // ══════════════════════════════════════════════════════════════════════

    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }

        if (args[0].equals("--fullstate")) {
            generateFullState();
            return;
        }

        generate(args[0]);
    }

    public static void generate(String gameName) {
        String cleanName = gameName.replace("-", "").replace(" ", "");
        String ludFile = gameName + ".lud";

        System.out.println("Loading game foranalysis...");
        Game game;
        try {
            game = GameLoader.loadGameFromName(ludFile);
        } catch (Exception e) {
            System.err.println("Failed to load game: " + e.getMessage());
            return;
        }
        System.out.println("Loaded: " + game.name());

        System.out.println("Bytecode analysis for data fields");
        Map<String, String> bytecodeVars;
        try {
            bytecodeVars = DynamicMemoryMapper.analyseGame(ludFile);
        } catch (Exception e) {
            System.err.println("Bytecode analysis failed: " + e.getMessage());
            return;
        }

        Set<String> needed = new LinkedHashSet<>();

        for (String field : BYTECODE_FIELDS) {
            if (bytecodeVars.containsKey(field)) {
                needed.add(field);
            }
        }
        System.out.println("Bytecode fields: " + 
            needed.stream().filter(BYTECODE_FIELDS::contains).toList());

        System.out.println("Feature flag analysis...");

        if (game.hasHandDice()) {
            needed.add("sumDice");
            needed.add("currentDice");
            needed.add("diceAllEqual");
        }
        if (game.requiresVisited())    
        	needed.add("visited");
        if (game.requiresTeams())      
        	needed.add("teams");
        if (game.hasDominoes())        
        	needed.add("remainingDominoes");
        if (game.usesPendingValues())  
        	needed.add("pendingValues");
        if (game.hasTrack() && game.hasInternalLoopInTrack())
        	needed.add("onTrackIndices");

        Set<String> flagDetected = new LinkedHashSet<>(needed);
        flagDetected.retainAll(FLAG_FIELDS);
        System.out.println("Flag fields: " + flagDetected);

        System.out.println("\n Total fields for " + cleanName + "State: " + needed.size());
        for (String f : needed) System.out.println("    + " + f);
        System.out.println();

        SubclassGenerator.generate(cleanName, needed, OUTPUT_DIR);
    }


     //Generate FullState with 18 removable fields.
    public static void generateFullState() {
        System.out.println("Generating FullState");
        Set<String> all = new LinkedHashSet<>();
        all.addAll(BYTECODE_FIELDS);
        all.addAll(FLAG_FIELDS);
        SubclassGenerator.generate("Full", all, OUTPUT_DIR);
    }

    public static Set<String> analyseAndGenerate(String gameName) {
        String cleanName = gameName.replace("-", "").replace(" ", "");
        String ludFile = gameName + ".lud";

        Game game = GameLoader.loadGameFromName(ludFile);
        Map<String, String> bytecodeVars = DynamicMemoryMapper.analyseGame(ludFile);

        Set<String> needed = new LinkedHashSet<>();

        // Bytecode for original 9
        for (String f : BYTECODE_FIELDS)
            if (bytecodeVars.containsKey(f)) needed.add(f);

        // Flags for 9
        if (game.hasHandDice()) { needed.add("sumDice"); needed.add("currentDice"); needed.add("diceAllEqual"); }
        if (game.requiresVisited())   needed.add("visited");
        if (game.requiresTeams())     needed.add("teams");
        if (game.hasDominoes())       needed.add("remainingDominoes");
        if (game.usesPendingValues()) needed.add("pendingValues");
        if (game.hasTrack() && game.hasInternalLoopInTrack()) needed.add("onTrackIndices");

        SubclassGenerator.generate(cleanName, needed, OUTPUT_DIR);
        return needed;
    }
}