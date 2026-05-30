package supplementary.experiments.ludemes.LudemeStateAnalysis;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.Statement;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class BaseStatePurifier {

    public static void main(String[] args) {
        try {
            Set<String> coreEngineVariables = new HashSet<>(Arrays.asList(
                "mover" 
            ));

            Set<String> deletedFields = new HashSet<>();
            CompilationUnit cu = StaticJavaParser.parse(new File("State_Master.java"));

           
            List<FieldDeclaration> fields = cu.findAll(FieldDeclaration.class);
            for (FieldDeclaration field : fields) {
                for (VariableDeclarator var : field.getVariables()) {
                    String fieldName = var.getNameAsString();
                    if (!coreEngineVariables.contains(fieldName)) {
                        deletedFields.add(fieldName);
                        field.remove();
                        break;
                    }
                }
            }

            List<MethodDeclaration> methods = cu.findAll(MethodDeclaration.class);
            for (MethodDeclaration method : methods) {
                if (method.getNameAsString().matches("initialise|resetStateTo|copy")) {
                    List<Statement> stmtsToRemove = new ArrayList<>();
                    method.findAll(Statement.class).forEach(stmt -> {
                        for (NameExpr ref : stmt.findAll(NameExpr.class)) {
                            if (deletedFields.contains(ref.getNameAsString())) {
                                stmtsToRemove.add(stmt);
                                break;
                            }
                        }
                    });
                    stmtsToRemove.forEach(Statement::remove);
                } else {
                    boolean isTainted = false;
                    for (NameExpr ref : method.findAll(NameExpr.class)) {
                        if (deletedFields.contains(ref.getNameAsString())) {
                            isTainted = true; break;
                        }
                    }
                    if (isTainted) method.remove();
                }
            }

            List<ConstructorDeclaration> constructors = cu.findAll(ConstructorDeclaration.class);
            for (ConstructorDeclaration constructor : constructors) {
                List<Statement> stmtsToRemove = new ArrayList<>();
                constructor.findAll(Statement.class).forEach(stmt -> {
                    for (NameExpr ref : stmt.findAll(NameExpr.class)) {
                        if (deletedFields.contains(ref.getNameAsString())) {
                            stmtsToRemove.add(stmt);
                            break;
                        }
                    }
                });
                stmtsToRemove.forEach(Statement::remove);
            }

            Files.writeString(Path.of("State.java"), cu.toString());
            System.out.println("Abstract State.java has been purified.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}