package supplementary.experiments.ludemes.LudemeStateAnalysis;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import game.Game;
import main.ReflectionUtils;
import other.GameLoader;
import other.Ludeme;


//this idk. 
public class StateRequirementScanner {

    private final Set<Object> visited = new HashSet<>();
    private final Set<String> discoveredParameters = new HashSet<>();

    public void scanAndDump(String gameName) {
        Game game = GameLoader.loadGameFromName(gameName);
        
        if (game == null) {
            System.err.println("Game failed to load.");
            return;
        }
        
        System.out.println("Crawling the Ludeme tree for parameters...");
        walk(game);
        
        System.out.println("\n--- UNIQUE PARAMETERS DETECTED ---");
        discoveredParameters.stream().sorted().forEach(System.out::println);
    }

    // obj is the game object 
    private void walk(Object obj) {
        if (obj == null || visited.contains(obj)) return;
        visited.add(obj);

        Class<?> clazz = obj.getClass();
        
        if (obj instanceof Ludeme) {
            List<Field> fields = ReflectionUtils.getAllFields(clazz);
            
            for (Field field : fields) {
                if ((field.getModifiers() & Modifier.STATIC) != 0) continue;
                
                String paramType = field.getType().getSimpleName();
                String paramName = field.getName();
                String className = clazz.getSimpleName();
                
                //ClassName -> Type parameterName
                discoveredParameters.add(className + " -> " + paramType + " " + paramName);

                try {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    
                    if (value instanceof Ludeme) {
                        walk(value);
                    } else if (value instanceof Iterable) {
                        for (Object element : (Iterable<?>) value) walk(element);
                    } else if (value != null && value.getClass().isArray()) {
                        Object[] array = ReflectionUtils.castArray(value);
                        for (Object element : array) walk(element);
                    }
                } catch (Exception ignored) {
                	
                }
            }
        } else {
        	System.out.println("this obj isn't type of ludeme but this: "+ obj.toString() +" is the type of "+ obj.getClass());
        }
    }

    public static void main(String[] args) {
    	StateRequirementScanner sketch = new StateRequirementScanner();
        sketch.scanAndDump("Tic-Tac-Toe.lud");
        System.out.println("finished");
        
    }
}