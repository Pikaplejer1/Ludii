package supplementary.experiments.ludemes.LudemeStateAnalysis;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class DynamicStateGenerator {

    // finalMemoryVariables should ONLY contain game-specific variables now.
    public static void generateSubclass(String gameName, Map<String, String> gameSpecificVariables) {
        try {
            CompilationUnit cu = new CompilationUnit("other.state"); // Use your actual package

            String className = gameName + "State";
            ClassOrInterfaceDeclaration subclass = cu.addClass(className).addExtendedType("State");

            for (Map.Entry<String, String> entry : gameSpecificVariables.entrySet()) {
                subclass.addField(entry.getValue(), entry.getKey(), Modifier.Keyword.PUBLIC); // Or protected
            }

            ConstructorDeclaration constructor = subclass.addConstructor(Modifier.Keyword.PUBLIC);
            
       
            BlockStmt constructorBody = new BlockStmt();
            constructorBody.addStatement("super();");

            constructor.setBody(constructorBody);

            Files.writeString(Path.of(className + ".java"), cu.toString());
            System.out.println("Generated clean subclass: " + className);

        } catch (Exception e) {
            System.out.println("Failed to generate subclass.");
            e.printStackTrace();
        }
    }
}