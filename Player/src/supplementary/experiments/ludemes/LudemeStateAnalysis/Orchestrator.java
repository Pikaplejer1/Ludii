package supplementary.experiments.ludemes.LudemeStateAnalysis;

import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.nio.file.Files;
import java.nio.file.Path;
public class Orchestrator {

    public static void main(String[] args) throws Exception {

        // -------------------------------------------------------
        // STEP 1: Find all .lud files
        // -------------------------------------------------------
        File ludDir = new File("C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Common\\res\\lud");
        File[] ludFiles = Files.walk(ludDir.toPath())
                .filter(p -> p.toString().endsWith(".lud"))
                .filter(p -> !p.toString().contains(File.separator + "test" + File.separator)) // Filters out the folder
                .map(Path::toFile)
                .toArray(File[]::new);

        if (ludFiles == null || ludFiles.length == 0) {
            System.out.println("No .lud files found. Check your path.");
            return;
        }

        // -------------------------------------------------------
        // STEP 2: Run analysis on every game
        // gameName -> Map<variableName, javaType>
        // -------------------------------------------------------
        Map<String, Map<String, String>> resultsPerGame = new LinkedHashMap<>();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (File lud : ludFiles) {
            String gameName = lud.getName().replace(".lud", "");
            String cleanName = gameName.replace("-", "").replace(" ", "");
            System.out.println("Analysing: " + gameName);

            Future<Map<String, String>> future = executor.submit(
                () -> DynamicMemoryMapper.analyseGame(lud.getName())
            );

            try {
                Map<String, String> vars = future.get(10, TimeUnit.SECONDS); // 10s max
                resultsPerGame.put(cleanName, vars);
                System.out.println("  -> Found " + vars.size() + " variables.");
            } catch (TimeoutException e) {
                future.cancel(true);
                System.out.println("  -> SKIPPED (timeout): " + gameName);
            } catch (Exception e) {
                System.out.println("  -> FAILED for " + gameName + ": " + e.getMessage());
            }
        }

        executor.shutdownNow(); // clean up after the loop

        // -------------------------------------------------------
        // STEP 3: Compute INTERSECTION → these go in State.java
        // A variable only enters the base if it appears in EVERY game
        // -------------------------------------------------------
        // Start with all variables from the first game
        Iterator<Map<String, String>> it = resultsPerGame.values().iterator();
        Set<String> baseVarNames = new HashSet<>(it.next().keySet());

        // Intersect with every other game
        while (it.hasNext()) {
            baseVarNames.retainAll(it.next().keySet());
        }

        // Get the full base variables map (name -> type) from any game 
        // (type is the same regardless of game since it comes from State.java)
        Map<String, String> baseVariables = new HashMap<>();
        Map<String, String> firstGame = resultsPerGame.values().iterator().next();
        for (String varName : baseVarNames) {
            baseVariables.put(varName, firstGame.get(varName));
        }

        System.out.println("\n=== BASE State.java variables (in ALL " 
            + resultsPerGame.size() + " games) ===");
        baseVariables.forEach((name, type) -> 
            System.out.println("  -> " + name + " | " + type));
        StringBuilder sb = new StringBuilder();
        baseVariables.forEach((name, type) -> sb.append(name).append("=").append(type).append("\n"));
        Files.writeString(Path.of("base_variables.txt"), sb.toString());
        System.out.println("Saved to base_variables.txt. Orchestrator done.");
        System.exit(0);
        
        // -------------------------------------------------------
        // STEP 4: Compute per-game UNIQUE variables
        // These go in GameState.java — anything NOT in base
        // -------------------------------------------------------
        Map<String, Map<String, String>> gameSpecificVars = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, String>> entry : resultsPerGame.entrySet()) {
            String gameName = entry.getKey();
            Map<String, String> allVarsForGame = entry.getValue();

            Map<String, String> uniqueVars = new HashMap<>();
            for (Map.Entry<String, String> var : allVarsForGame.entrySet()) {
                if (!baseVarNames.contains(var.getKey())) {
                    uniqueVars.put(var.getKey(), var.getValue());
                }
            }

            gameSpecificVars.put(gameName, uniqueVars);
            System.out.println("\n" + gameName + " unique variables: " + uniqueVars.keySet());
        }

        // -------------------------------------------------------
        // STEP 5: Generate abstract State.java with only base variables
        // -------------------------------------------------------
        System.out.println("\n=== Generating abstract State.java ===");
        StatePruner.pruneToAbstractBase(baseVariables.keySet());

        // -------------------------------------------------------
        // STEP 6: Generate GameState.java for each game
        // -------------------------------------------------------
        System.out.println("\n=== Generating per-game state subclasses ===");
        for (Map.Entry<String, Map<String, String>> entry : gameSpecificVars.entrySet()) {
            String gameName = entry.getKey();
            Map<String, String> uniqueVars = entry.getValue();
            System.out.println("Generating " + gameName + "State.java...");
            DynamicStateGenerator.generateSubclass(gameName, uniqueVars);
        }

        System.out.println("\n=== DONE ===");
    }
}