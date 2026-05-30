package supplementary.experiments.ludemes.LudemeStateAnalysis;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SmartPruner {

	// somethimes ai is that good and makes a good class, sometimes it is not 
    private static final String STATE_INPUT_PATH =
        "C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Core\\src\\other\\state\\State.java";

    private static final String STATE_OUTPUT_PATH =
        "C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Core\\src\\other\\state\\StateNew.java";

    private static final Set<String> REMOVE_FIELDS = new HashSet<>(Arrays.asList(
    	    "amount", "valuesPlayer", "propositions", "votes", "notes",
    	    "sitesToRemove", "rememberingValues", "mapRememberingValues", "valueMap",
    	    "sumDice", "currentDice", "diceAllEqual", "visited", "teams",
    	    "remainingDominoes", "pendingValues", "onTrackIndices"
    	));


    
    private static final Set<String> PROTECTED_FIELDS = new HashSet<>(Arrays.asList(
        // Engine fields
        "containerStates", "playerOrder", "owned",
        // Scalar state (keep — negligible memory, removing breaks things)
        "mover", "next", "prev", "triggered", "stalemated",
        "counter", "tempValue", "moneyPot", "numTurnSamePlayer", "numTurn",
        "trumpSuit", "isDecided", "numConsecutivePasses",
        "storedState", "numConsecutivePassesHashCap",
        
        // all hash value fields
        "stateHash", "moverHash", "nextHash", "prevHash",
        "activeHash", "checkmatedHash", "stalematedHash",
        "pendingHash", "scoreHash", "amountHash",
        // all hash array fields
        "moverHashes", "nextHashes", "prevHashes",
        "activeHashes", "checkmatedHashes", "stalematedHashes",
        "lowScoreHashes", "highScoreHashes",
        "lowAmountHashes", "highAmountHashes",
        "phaseHashes", "isPendingHashes", "tempHashes",
        "playerOrderHashes", "consecutiveTurnHashes",
        "playerSwitchHashes", "teamHashes",
        "numConsecutivePassesHashes",
        "lastFromHashes", "lastToHashes"
    ));

    
    private static final String ISDECIDED_RESCUE = "isDecided = other.isDecided;";

    // ══════════════════════════════════════════════════════════════════════════
    public static void main(String[] args) throws Exception {

        CompilationUnit cu = StaticJavaParser.parse(new File(STATE_INPUT_PATH));

        //emove field declarations
        Set<String> removed = removeFieldDeclarations(cu);
        System.out.println("Removed " + removed.size() + " field declarations: " + removed);

        System.out.println("Purging tainted statements...");
        purgeAllBodies(cu, removed);

        System.out.println("Rescuing collateral damage...");
        rescueCollateralDamage(cu);

        System.out.println("Fixing empty methods...");
        fixEmptyMethods(cu);

        System.out.println("Making class abstract, adding copy()...");
        makeAbstract(cu);

        //
        fixClassName(cu);

        adjustFieldVisibility(cu);

        
        makeHashHelpersProtected(cu);
        
        String output = cu.toString();
        Files.writeString(Path.of(STATE_OUTPUT_PATH), output);
        System.out.println("\nWritten to: " + STATE_OUTPUT_PATH);
    }


    private static Set<String> removeFieldDeclarations(CompilationUnit cu) {
        Set<String> removed = new LinkedHashSet<>();

        for (FieldDeclaration field : new ArrayList<>(cu.findAll(FieldDeclaration.class))) {
            for (VariableDeclarator var : field.getVariables()) {
                String name = var.getNameAsString();
                if (REMOVE_FIELDS.contains(name) && !PROTECTED_FIELDS.contains(name)) {
                    removed.add(name);
                    field.remove();
                    break;
                }
            }
        }

        return removed;
    }

  private static void purgeAllBodies(CompilationUnit cu, Set<String> removed) {
        //constructors
        for (ConstructorDeclaration ctor : cu.findAll(ConstructorDeclaration.class)) {
            purgeBlock(ctor.getBody(), removed);
        }

        //methods
        for (MethodDeclaration method : cu.findAll(MethodDeclaration.class)) {
            method.getBody().ifPresent(body -> purgeBlock(body, removed));
        }
    }

    
    private static void purgeBlock(BlockStmt block, Set<String> removedFields) {
        Set<String> tainted = new HashSet<>(removedFields);

        for (Statement stmt : new ArrayList<>(block.getStatements())) {

            if (stmt.isIfStmt()) {
                handleIfStatement(stmt.asIfStmt(), tainted);
            }
            else if (stmt.isForStmt()) {
                handleForStatement(stmt.asForStmt(), tainted);
            }
            else if (stmt.isForEachStmt()) {
                handleForEachStatement(stmt.asForEachStmt(), tainted);
            }
            else if (stmt.isWhileStmt()) {
                WhileStmt ws = stmt.asWhileStmt();
                if (referencesAny(ws.getCondition(), tainted)) {
                    collectLocalDeclarations(ws, tainted);
                    ws.remove();
                } else if (ws.getBody().isBlockStmt()) {
                    purgeBlock(ws.getBody().asBlockStmt(), tainted);
                }
            }
            else {
                if (referencesAny(stmt, tainted)) {
                    collectLocalDeclarations(stmt, tainted);
                    stmt.remove();
                }
            }
        }
    }

    private static void handleIfStatement(IfStmt ifStmt, Set<String> tainted) {
        if (referencesAny(ifStmt.getCondition(), tainted)) {
            collectLocalDeclarations(ifStmt, tainted);
            ifStmt.remove();
            return;
        }

        
        Statement thenStmt = ifStmt.getThenStmt();
        if (thenStmt.isBlockStmt()) {
            purgeBlock(thenStmt.asBlockStmt(), tainted);
        } else if (referencesAny(thenStmt, tainted)) {
            ifStmt.setThenStmt(new BlockStmt());
        }

        ifStmt.getElseStmt().ifPresent(elseStmt -> {
            if (elseStmt.isBlockStmt()) {
                purgeBlock(elseStmt.asBlockStmt(), tainted);
            } else if (elseStmt.isIfStmt()) {
                handleIfStatement(elseStmt.asIfStmt(), tainted);
            } else if (referencesAny(elseStmt, tainted)) {
                ifStmt.removeElseStmt();
            }
        });

        boolean thenEmpty = isEmptyBody(ifStmt.getThenStmt());
        boolean elseEmpty = !ifStmt.getElseStmt().isPresent()
                            || isEmptyBody(ifStmt.getElseStmt().get());
        if (thenEmpty && elseEmpty) {
            ifStmt.remove();
        }
    }

    private static void handleForStatement(ForStmt forStmt, Set<String> tainted) {
        boolean controlTainted = false;
        for (Expression init : forStmt.getInitialization()) {
            if (referencesAny(init, tainted)) { controlTainted = true; break; }
        }
        if (!controlTainted && forStmt.getCompare().isPresent()) {
            controlTainted = referencesAny(forStmt.getCompare().get(), tainted);
        }
        if (!controlTainted) {
            for (Expression update : forStmt.getUpdate()) {
                if (referencesAny(update, tainted)) { controlTainted = true; break; }
            }
        }

        if (controlTainted) {
            collectLocalDeclarations(forStmt, tainted);
            forStmt.remove();
        } else if (forStmt.getBody().isBlockStmt()) {
            purgeBlock(forStmt.getBody().asBlockStmt(), tainted);
            if (isEmptyBody(forStmt.getBody())) {
                forStmt.remove();
            }
        } else if (referencesAny(forStmt.getBody(), tainted)) {
            forStmt.remove();
        }
    }

    private static void handleForEachStatement(ForEachStmt feStmt, Set<String> tainted) {
        if (referencesAny(feStmt.getIterable(), tainted)) {
            collectLocalDeclarations(feStmt, tainted);
            feStmt.remove();
        } else if (feStmt.getBody().isBlockStmt()) {
            purgeBlock(feStmt.getBody().asBlockStmt(), tainted);
            if (isEmptyBody(feStmt.getBody())) {
                feStmt.remove();
            }
        } else if (referencesAny(feStmt.getBody(), tainted)) {
            feStmt.remove();
        }
    }


    private static boolean referencesAny(Node node, Set<String> names) {
        boolean hasNameRef = node.findAll(NameExpr.class).stream()
            .anyMatch(ne -> names.contains(ne.getNameAsString()));
        if (hasNameRef) return true;

        boolean hasFieldRef = node.findAll(FieldAccessExpr.class).stream()
            .anyMatch(fa -> names.contains(fa.getNameAsString()));
        return hasFieldRef;
    }


    private static void collectLocalDeclarations(Node node, Set<String> tainted) {
        node.findAll(VariableDeclarator.class).forEach(v ->
            tainted.add(v.getNameAsString())
        );
    }

    private static boolean isEmptyBody(Statement stmt) {
        if (stmt.isBlockStmt()) {
            return stmt.asBlockStmt().getStatements().isEmpty();
        }
        return false;
    }


    private static void rescueCollateralDamage(CompilationUnit cu) {
        cu.findAll(ConstructorDeclaration.class).stream()
            .filter(c -> c.getParameters().size() == 1
                      && c.getParameters().get(0).getTypeAsString().equals("State"))
            .forEach(c -> {
                if (!bodyContainsAssignment(c.getBody(), "isDecided")) {
                    System.out.println("  Rescued: isDecided in copy constructor");
                    c.getBody().addStatement(StaticJavaParser.parseStatement(ISDECIDED_RESCUE));
                }
            });

        cu.findAll(MethodDeclaration.class).stream()
            .filter(m -> m.getNameAsString().equals("resetStateTo"))
            .forEach(m -> m.getBody().ifPresent(body -> {
                if (!bodyContainsAssignment(body, "isDecided")) {
                    System.out.println("  Rescued: isDecided in resetStateTo");
                    // Insert before the hash copy block at the end
                    addBeforeHashCopies(body, ISDECIDED_RESCUE);
                }
            }));
    }

   
    private static boolean bodyContainsAssignment(BlockStmt body, String fieldName) {
        return body.toString().contains(fieldName + " =")
            || body.toString().contains(fieldName + "=");
    }


    private static void addBeforeHashCopies(BlockStmt body, String statementStr) {
        int insertIdx = body.getStatements().size(); 
        for (int i = body.getStatements().size() - 1; i >= 0; i--) {
            String line = body.getStatements().get(i).toString();
            if (line.contains("stateHash") || line.contains("moverHash")
                || line.contains("nextHash") || line.contains("prevHash")
                || line.contains("activeHash") || line.contains("checkmatedHash")
                || line.contains("stalematedHash") || line.contains("pendingHash")
                || line.contains("scoreHash") || line.contains("amountHash")) {
                insertIdx = i;
            } else if (insertIdx < body.getStatements().size()) {
                break;
            }
        }

        body.addStatement(insertIdx, StaticJavaParser.parseStatement(statementStr));
    }

  private static void fixEmptyMethods(CompilationUnit cu) {
        for (MethodDeclaration method : cu.findAll(MethodDeclaration.class)) {
            method.getBody().ifPresent(body -> {
                if (!body.getStatements().isEmpty()) return;

                String returnType = method.getTypeAsString();
                if (returnType.equals("void")) return; // void no-op is fine

                body.addStatement(StaticJavaParser.parseStatement(defaultReturn(returnType)));
            });
        }
    }

    private static String defaultReturn(String type) {
        switch (type) {
            case "int":     return "return 0;";
            case "long":    return "return 0L;";
            case "short":   return "return (short) 0;";
            case "byte":    return "return (byte) 0;";
            case "double":  return "return 0.0;";
            case "float":   return "return 0.0f;";
            case "boolean": return "return false;";
            case "Region":  return "return new Region();";
            default:        return "return null;";
        }
    }

    private static void makeAbstract(CompilationUnit cu) {
        cu.findFirst(ClassOrInterfaceDeclaration.class).ifPresent(cls -> {
            if (!cls.isAbstract()) {
                cls.setAbstract(true);
            }
            boolean hasCopy = cls.getMethods().stream()
                .anyMatch(m -> m.getNameAsString().equals("copy")
                            && m.getParameters().isEmpty());

            if (!hasCopy) {
                MethodDeclaration copyMethod = cls.addMethod("copy", Modifier.Keyword.PUBLIC);
                copyMethod.setType("State");
                copyMethod.setAbstract(true);
                copyMethod.removeBody();
                System.out.println("  Added: public abstract State copy();");
            }
        });
    }

 
    private static void fixClassName(CompilationUnit cu) {
        cu.findFirst(ClassOrInterfaceDeclaration.class).ifPresent(cls -> {
            String name = cls.getNameAsString();
            if (!name.equals("State")) {
                System.out.println("  Renamed: " + name + " → State");
                cls.setName("State");
            }
        });

        cu.findAll(ConstructorDeclaration.class).forEach(ctor -> {
            if (!ctor.getNameAsString().equals("State")) {
                ctor.setName("State");
            }
        });
    }

    
    private static void adjustFieldVisibility(CompilationUnit cu) {
        cu.findAll(FieldDeclaration.class).forEach(field -> {
            String fieldName = field.getVariables().get(0).getNameAsString();
            if (fieldName.equals("serialVersionUID")) return;
            
            field.setPublic(false);
            field.setPrivate(false);
            field.setProtected(true);
        });
    }
    private static void makeHashHelpersProtected(CompilationUnit cu) {
        Set<String> hashHelpers = new HashSet<>(Arrays.asList(
            "updatePendingHash",
            "updateAmountHash"
        ));
        cu.findAll(MethodDeclaration.class).forEach(method -> {
            if (hashHelpers.contains(method.getNameAsString())) {
                method.setPrivate(false);
                method.setProtected(true);
            }
        });
    }
}