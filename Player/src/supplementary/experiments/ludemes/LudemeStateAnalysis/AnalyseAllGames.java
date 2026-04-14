//package supplementary.experiments.ludemes.LudemeStateAnalysis;
//
//import java.io.File;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//public class AnalyseAllGames {
//    public static void main(String[] args) throws Exception {
//        
//        File ludDir = new File("C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Common\\res\\lud");
//        File[] ludFiles = Files.walk(ludDir.toPath())
//        	    .filter(p -> p.toString().endsWith(".lud"))
//        	    .map(Path::toFile)
//        	    .toArray(File[]::new);
//
//        // Map of gameName → required variables found by your existing analysis
//        Map<String, Set<String>> resultsPerGame = new HashMap<>();
//
//        for (File lud : ludFiles) {
//            String gameName = lud.getName().replace(".lud", "");
//            System.out.println("Analysing: " + gameName);
//
//            // THIS IS YOUR EXISTING ANALYSIS — just call it per game
//            Set<String> required = LudemeStateAnalysis.analyse(lud); 
//            resultsPerGame.put(gameName, required);
//        }
//        Set<String> baseVariables = new HashSet<>(resultsPerGame.values().iterator().next());
//        for (Set<String> gameVars : resultsPerGame.values()) {
//            baseVariables.retainAll(gameVars); // intersection
//        }
//
//        System.out.println("\n=== BASE State.java variables (used in ALL games) ===");
//        baseVariables.forEach(v -> System.out.println("  -> " + v));
//
//        System.out.println("\n=== Per-game unique variables ===");
//        for (Map.Entry<String, Set<String>> entry : resultsPerGame.entrySet()) {
//            String gameName = entry.getKey();
//            Set<String> unique = new HashSet<>(entry.getValue());
//            unique.removeAll(baseVariables); // remove what's already in base
//            System.out.println("\n" + gameName + ":");
//            unique.forEach(v -> System.out.println("  -> " + v));
//        }
//
//        saveToFile("base_varia bles.txt", baseVariables);
//        saveResultsPerGame("per_game_variables.json", resultsPerGame, baseVariables);
//    }
//}