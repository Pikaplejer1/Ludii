package supplementary.experiments.ludemes.LudemeStateAnalysis;

import java.io.File;
import java.util.HashSet;
import java.util.Set;


// this class scans all the ludemes to see which methods they use. 
// not that usefull.

public class BatchScanner {
    public static void main(String[] args) {
       
        File binFolder = new File("C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Core\\bin\\game"); 

        Set<String> masterMethodList = new HashSet<>();
        
        System.out.println("Starting mass interrogation...");
        scanFolder(binFolder, masterMethodList);

        System.out.println("\n--- THE FINAL LIST OF ALL STATE METHODS USED BY ALL LUDEMES ---");
        for (String method : masterMethodList) {
            System.out.println("-> " + method);
        }
    }

    private static void scanFolder(File folder, Set<String> masterList) {
        File[] files = folder.listFiles();
        if (files == null) return;
        for (File file : files) {
            if (file.isDirectory()) {
                scanFolder(file, masterList); // Keep digging
            } else if (file.getName().endsWith(".class")) {
                String path = file.getPath();
                String internalName = path.substring(path.indexOf("game"), path.lastIndexOf(".class"))
                                          .replace(File.separatorChar, '/');
                
                Set<String> methodsFound = LudemeMethodScanner.findStateMethodCalls(internalName);
                masterList.addAll(methodsFound);
            }
        }
    }
}