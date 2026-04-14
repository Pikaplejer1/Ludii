package supplementary.experiments.ludemes.LudemeStateAnalysis;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import game.Game;
import other.GameLoader;
import other.Ludeme;
import main.ReflectionUtils;


// this class generates a a list of variable names and type of those variables that are being used by the game. 
// this is way overdone, it was used to perfoem like 598047 things at once
public class DynamicMemoryMapper {

    public static void main(String[] args) {
//        String targetGame = "Tic-Tac-Toe.lud";
        String targetGame = "Go.lud";

        System.out.println("Extracting Ludemes and Types for: " + targetGame + "... Try to keep up.");

        Game game = GameLoader.loadGameFromName(targetGame, new ArrayList<>());
        
        String gameName = game.name().replace("-", "").replace(" ", "");

        Set<String> usedLudemes = new HashSet<>();
        extractLudemes(game, usedLudemes, new HashMap<>());

        Map<String, Map<String, String>> masterDictionary = StateHashmapBuilder.buildMethodToFieldMap("other/state/State");
        
        Map<String, String> finalMemoryVariables = new HashMap<>();

        System.out.println("start");

        for (String javaClassName : usedLudemes) {
            String jvmPath = javaClassName.replace('.', '/');
            Set<String> methodsCalled = LudemeMethodScanner.findStateMethodCalls(jvmPath);

            for (String method : methodsCalled) {
                if (method.equals("<init>") || method.equals("initialise") || method.equals("resetStateTo")) {
                    continue;
                }

                if (masterDictionary.containsKey(method)) {
                    Map<String, String> fieldsAndTypes = masterDictionary.get(method);
                    for (Map.Entry<String, String> entry : fieldsAndTypes.entrySet()) {
                        String fieldName = entry.getKey();
                        String jvmDescriptor = entry.getValue();
                        
                        String javaType = translateDescriptor(jvmDescriptor);
                        finalMemoryVariables.put(fieldName, javaType);
                    }
                }
            }
        }

//        finalMemoryVariables.put("mover", "int");
//        finalMemoryVariables.put("containerStates", "other.state.container.ContainerState[]");
//        finalMemoryVariables.put("stateHash", "long");
//        finalMemoryVariables.put("playerOrder", "int[]");

        System.out.println(" Results for the class: " + targetGame.toUpperCase() + " \n");
        if (finalMemoryVariables.isEmpty()) {
            System.out.println("Nothing.");
        } else {
            finalMemoryVariables.forEach((name, type) -> {
                System.out.println("-> Variable: " + name + " | Type: " + type);
            });
        }
        
    }
    
    
    
    
    
    
    
    
    

    private static String translateDescriptor(String desc) {
        int arrayDimensions = 0;
        while (desc.startsWith("[")) {
            arrayDimensions++;
            desc = desc.substring(1);
        }

        String javaType;
        switch (desc) {
            case "I": javaType = "int"; break;
            case "Z": javaType = "boolean"; break;
            case "J": javaType = "long"; break;
            case "D": javaType = "double"; break;
            case "F": javaType = "float"; break;
            case "B": javaType = "byte"; break;
            case "C": javaType = "char"; break;
            case "S": javaType = "short"; break;
            case "V": javaType = "void"; break;
            default:
                if (desc.startsWith("L") && desc.endsWith(";")) {
                    javaType = desc.substring(1, desc.length() - 1).replace('/', '.');
                } else {
                    javaType = "Object"; 
                }
        }

        for (int i = 0; i < arrayDimensions; i++) {
            javaType += "[]";
        }
        return javaType;
    }

    private static void extractLudemes(Ludeme ludeme, Set<String> ludemeSet, Map<Object, Set<String>> visited) {
        if (ludeme == null) return;
        Class<? extends Ludeme> clazz = ludeme.getClass();
        ludemeSet.add(clazz.getName());
        
        List<Field> fields = ReflectionUtils.getAllFields(clazz);

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if ((field.getModifiers() & Modifier.STATIC) != 0) continue;

                if (visited.containsKey(ludeme) && visited.get(ludeme).contains(field.getName())) {
                    continue; 
                }

                Object value = field.get(ludeme);

                if (!visited.containsKey(ludeme)) {
                    visited.put(ludeme, new HashSet<>());
                }
                visited.get(ludeme).add(field.getName());

                if (value != null) {
                    Class<?> valueClass = value.getClass();

                    if (Ludeme.class.isAssignableFrom(valueClass)) {
                        extractLudemes((Ludeme) value, ludemeSet, visited);
                    } else if (valueClass.isArray()) {
                        Object[] array = ReflectionUtils.castArray(value);
                        for (Object element : array) {
                            if (element != null && Ludeme.class.isAssignableFrom(element.getClass())) {
                                extractLudemes((Ludeme) element, ludemeSet, visited);
                            }
                        }
                    } else if (Iterable.class.isAssignableFrom(valueClass)) {
                        Iterable<?> iterable = (Iterable<?>) value;
                        for (Object element : iterable) {
                            if (element != null && Ludeme.class.isAssignableFrom(element.getClass())) {
                                extractLudemes((Ludeme) element, ludemeSet, visited);
                            }
                        }
                    }
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.err.println("Reflection failed.");
        }
    }
    public static Map<String, String> analyseGame(String targetGame) {
        Game game = GameLoader.loadGameFromName(targetGame, new ArrayList<>());

        Set<String> usedLudemes = new HashSet<>();
        extractLudemes(game, usedLudemes, new HashMap<>());

        Map<String, Map<String, String>> masterDictionary = 
            StateHashmapBuilder.buildMethodToFieldMap("other/state/State");

        Map<String, String> finalMemoryVariables = new HashMap<>();

        for (String javaClassName : usedLudemes) {
            String jvmPath = javaClassName.replace('.', '/');
            Set<String> methodsCalled = LudemeMethodScanner.findStateMethodCalls(jvmPath);

            for (String method : methodsCalled) {
                if (method.equals("<init>") || method.equals("initialise") 
                    || method.equals("resetStateTo")) continue;

                if (masterDictionary.containsKey(method)) {
                    Map<String, String> fieldsAndTypes = masterDictionary.get(method);
                    for (Map.Entry<String, String> entry : fieldsAndTypes.entrySet()) {
                        finalMemoryVariables.put(entry.getKey(), 
                            translateDescriptor(entry.getValue()));
                    }
                }
            }
        }


        return finalMemoryVariables;
    }
}