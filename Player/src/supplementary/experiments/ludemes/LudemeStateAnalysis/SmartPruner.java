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

/**
 * SmartPruner — generates an abstract State.java from the original monolith.
 *
 * STRATEGY (learned from FreshPruner bugs):
 *
 * 1. ONLY remove collection/array DATA fields not in the all-game intersection.
 *    Scalar fields (int, long, boolean) cost 4–8 bytes — not worth the risk.
 *    Removing them breaks hash consistency, triggers(), setActive(), etc.
 *
 * 2. Keep ALL hash infrastructure intact — every hash field, hash array,
 *    hash initialization, and hash method. These are either shared references
 *    (zero per-state cost) or single longs (8 bytes each).
 *
 * 3. Keep ALL engine-critical fields: containerStates, playerOrder, owned,
 *    onTrackIndices.
 *
 * 4. For removed fields: methods become no-ops / return safe defaults.
 *    Subclasses override them for games that need the feature.
 *
 * 5. Add abstract copy() — the engine calls this constantly and every
 *    concrete subclass MUST provide it.
 *
 * 6. Make the class abstract.
 *
 * 7. Smart purging: only check control expressions of compound statements,
 *    recurse into bodies. Track local variables tainted by removed fields.
 *    Check both NameExpr AND FieldAccessExpr (for other.field patterns).
 *
 * 8. Rescue collateral damage: when a kept field (like isDecided) shares
 *    an if-block with removed fields (votes/propositions), re-add its
 *    assignment after pruning.
 *
 * @author SmartPruner v2 — replaces FreshPruner
 */
public class SmartPruner {

    // ── PATHS ────────────────────────────────────────────────────────────────
    // Point STATE_INPUT_PATH at your ORIGINAL unmodified State.java monolith.
    // Keep the original safe — maybe name it State_Master.java.
    private static final String STATE_INPUT_PATH =
        "C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Core\\src\\other\\state\\State.java";

    private static final String STATE_OUTPUT_PATH =
        "C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Core\\src\\other\\state\\StateNew.java";

    // ── REMOVE SET ───────────────────────────────────────────────────────────
    // Only collection/array fields NOT in the all-game intersection.
    // These are the fields that actually allocate heap memory per state.
    // Scalar fields (triggered, tempValue, trumpSuit, moneyPot, diceAllEqual,
    // storedState, numConsecutivePassesHashCap) are kept — negligible memory,
    // removing them breaks hash methods and engine behavior.
    private static final Set<String> REMOVE_FIELDS = new HashSet<>(Arrays.asList(
        "amount",               // int[] — only for betting games
        "valuesPlayer",         // int[] — per-player values
        "propositions",         // TIntArrayList — only for voting games
        "votes",                // TIntArrayList — only for voting games
        "notes",                // TIntObjectMap<TIntObjectMap<String>> — note games
        "sitesToRemove",        // TIntArrayList — sequence capture (draughts)
        "rememberingValues",    // FastTIntArrayList — remembering ludeme
        "mapRememberingValues", // Map<String, FastTIntArrayList> — named remembering
        "valueMap"              // TObjectIntMap<String> — value map ludeme
    ));

    // ── NEVER TOUCH ──────────────────────────────────────────────────────────
    // Safety net — if any of these accidentally end up in REMOVE_FIELDS,
    // this set overrides and protects them.
    private static final Set<String> PROTECTED_FIELDS = new HashSet<>(Arrays.asList(
        // Engine fields
        "containerStates", "playerOrder", "owned", "onTrackIndices",
        // Scalar state (keep — negligible memory, removing breaks things)
        "mover", "next", "prev", "triggered", "stalemated",
        "counter", "tempValue", "moneyPot", "numTurnSamePlayer", "numTurn",
        "trumpSuit", "isDecided", "diceAllEqual", "numConsecutivePasses",
        "storedState", "numConsecutivePassesHashCap",
        // Collections in intersection (keep)
        "pendingValues", "currentPhase", "sumDice", "currentDice",
        "visited", "teams", "remainingDominoes",
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

    // ── COLLATERAL DAMAGE RESCUE ─────────────────────────────────────────────
    // Kept fields that share an if-block with removed fields and would be
    // lost as collateral damage. After purging, these assignments are re-added.
    //
    // Why: The original has:
    //   if (other.votes != null) { votes=...; propositions=...; isDecided=other.isDecided; }
    //   else { votes=null; propositions=null; isDecided=other.isDecided; }
    // Purging removes the entire if-else because the condition references 'votes'.
    // But isDecided is a KEPT field that needs to be copied.
    private static final String ISDECIDED_RESCUE = "isDecided = other.isDecided;";

    // ══════════════════════════════════════════════════════════════════════════
    public static void main(String[] args) throws Exception {
        System.out.println("=== SmartPruner: Generating abstract State.java ===\n");

        // Parse the original monolith
        CompilationUnit cu = StaticJavaParser.parse(new File(STATE_INPUT_PATH));

        // ── Step 1: Remove field declarations ────────────────────────────────
        Set<String> removed = removeFieldDeclarations(cu);
        System.out.println("Removed " + removed.size() + " field declarations: " + removed);

        // ── Step 2: Purge tainted statements from all bodies ─────────────────
        System.out.println("Purging tainted statements...");
        purgeAllBodies(cu, removed);

        // ── Step 3: Rescue collateral damage ─────────────────────────────────
        System.out.println("Rescuing collateral damage...");
        rescueCollateralDamage(cu);

        // ── Step 4: Fix empty non-void methods ───────────────────────────────
        System.out.println("Fixing empty methods...");
        fixEmptyMethods(cu);

        // ── Step 5: Make class abstract + add abstract copy() ────────────────
        System.out.println("Making class abstract, adding copy()...");
        makeAbstract(cu);

        // ── Step 6: Fix class name if needed ─────────────────────────────────
        fixClassName(cu);

        // ── Step 7: Make data fields protected for subclass access ───────────
        adjustFieldVisibility(cu);

        // ── Step 8: Write output ─────────────────────────────────────────────
        String output = cu.toString();
        Files.writeString(Path.of(STATE_OUTPUT_PATH), output);
        System.out.println("\nWritten to: " + STATE_OUTPUT_PATH);
        System.out.println("=== SmartPruner complete ===");
    }

    // ══════════════════════════════════════════════════════════════════════════
    // STEP 1: Remove field declarations
    // ══════════════════════════════════════════════════════════════════════════

    private static Set<String> removeFieldDeclarations(CompilationUnit cu) {
        Set<String> removed = new LinkedHashSet<>();

        for (FieldDeclaration field : new ArrayList<>(cu.findAll(FieldDeclaration.class))) {
            for (VariableDeclarator var : field.getVariables()) {
                String name = var.getNameAsString();
                if (REMOVE_FIELDS.contains(name) && !PROTECTED_FIELDS.contains(name)) {
                    removed.add(name);
                    field.remove();
                    break; // typically one variable per declaration
                }
            }
        }

        return removed;
    }

    // ══════════════════════════════════════════════════════════════════════════
    // STEP 2: Purge tainted statements
    // ══════════════════════════════════════════════════════════════════════════

    private static void purgeAllBodies(CompilationUnit cu, Set<String> removed) {
        // Purge constructors
        for (ConstructorDeclaration ctor : cu.findAll(ConstructorDeclaration.class)) {
            purgeBlock(ctor.getBody(), removed);
        }

        // Purge methods
        for (MethodDeclaration method : cu.findAll(MethodDeclaration.class)) {
            method.getBody().ifPresent(body -> purgeBlock(body, removed));
        }
    }

    /**
     * Recursively purge statements that reference removed fields.
     *
     * For compound statements (if/for/foreach/while):
     *   - If the CONTROL expression references a removed field → remove entire statement
     *   - Otherwise → recurse into body blocks (preserving the control structure)
     *
     * For simple statements:
     *   - If it references a removed field → remove it
     *   - Track local variable declarations that depend on removed fields,
     *     so subsequent references to those locals also get purged.
     */
    private static void purgeBlock(BlockStmt block, Set<String> removedFields) {
        // Tainted = removed fields + local variables that were assigned from removed fields
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
                // Simple statement (ExpressionStmt, ReturnStmt, etc.)
                if (referencesAny(stmt, tainted)) {
                    collectLocalDeclarations(stmt, tainted);
                    stmt.remove();
                }
            }
        }
    }

    private static void handleIfStatement(IfStmt ifStmt, Set<String> tainted) {
        // Check if the CONDITION itself references tainted fields
        if (referencesAny(ifStmt.getCondition(), tainted)) {
            // Entire if-else is tainted at the control level — remove it all
            collectLocalDeclarations(ifStmt, tainted);
            ifStmt.remove();
            return;
        }

        // Condition is clean — recurse into then-branch
        Statement thenStmt = ifStmt.getThenStmt();
        if (thenStmt.isBlockStmt()) {
            purgeBlock(thenStmt.asBlockStmt(), tainted);
        } else if (referencesAny(thenStmt, tainted)) {
            // Single-line then-body references tainted field → empty it
            ifStmt.setThenStmt(new BlockStmt());
        }

        // Recurse into else-branch (if present)
        ifStmt.getElseStmt().ifPresent(elseStmt -> {
            if (elseStmt.isBlockStmt()) {
                purgeBlock(elseStmt.asBlockStmt(), tainted);
            } else if (elseStmt.isIfStmt()) {
                handleIfStatement(elseStmt.asIfStmt(), tainted);
            } else if (referencesAny(elseStmt, tainted)) {
                ifStmt.removeElseStmt();
            }
        });

        // After pruning: if both branches are empty, remove the entire if
        boolean thenEmpty = isEmptyBody(ifStmt.getThenStmt());
        boolean elseEmpty = !ifStmt.getElseStmt().isPresent()
                            || isEmptyBody(ifStmt.getElseStmt().get());
        if (thenEmpty && elseEmpty) {
            ifStmt.remove();
        }
    }

    private static void handleForStatement(ForStmt forStmt, Set<String> tainted) {
        // Check control expressions: initialization, compare, update
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
        // Check iterable expression
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

    // ══════════════════════════════════════════════════════════════════════════
    // Reference checking — the KEY improvement over FreshPruner
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * Checks if a node references any of the given names.
     *
     * Checks BOTH:
     *   - NameExpr: direct references like `votes`, `amount[i]`, `notes.get(x)`
     *   - FieldAccessExpr: qualified references like `other.votes`, `this.amount`
     *
     * FreshPruner only checked NameExpr, which missed `other.fieldName` patterns
     * in the copy constructor and resetStateTo — a major source of bugs.
     */
    private static boolean referencesAny(Node node, Set<String> names) {
        // Check direct name references: votes, amount, notes, etc.
        boolean hasNameRef = node.findAll(NameExpr.class).stream()
            .anyMatch(ne -> names.contains(ne.getNameAsString()));
        if (hasNameRef) return true;

        // Check field access references: other.votes, this.amount, etc.
        boolean hasFieldRef = node.findAll(FieldAccessExpr.class).stream()
            .anyMatch(fa -> names.contains(fa.getNameAsString()));
        return hasFieldRef;
    }

    /**
     * When removing a statement, track any local variable declarations it contains.
     * If a statement like `final X foo = notes.get(...)` is removed, subsequent
     * statements referencing `foo` must also be removed.
     *
     * This prevents the FreshPruner bug where `notesForMove` (a local variable
     * in getNote()) was left dangling after `notes` was removed.
     */
    private static void collectLocalDeclarations(Node node, Set<String> tainted) {
        node.findAll(VariableDeclarator.class).forEach(v ->
            tainted.add(v.getNameAsString())
        );
    }

    private static boolean isEmptyBody(Statement stmt) {
        if (stmt.isBlockStmt()) {
            return stmt.asBlockStmt().getStatements().isEmpty();
        }
        return false; // single-line body is never "empty"
    }

    // ══════════════════════════════════════════════════════════════════════════
    // STEP 3: Rescue collateral damage
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * Re-add assignments for KEPT fields that were lost as collateral damage.
     *
     * The main case: `isDecided = other.isDecided` lives inside an if-block
     * whose condition references `votes` (removed). The entire if-else gets
     * purged, taking isDecided with it. We re-add it as a standalone assignment.
     */
    private static void rescueCollateralDamage(CompilationUnit cu) {
        // ── Copy constructor: rescue isDecided ───────────────────────────────
        cu.findAll(ConstructorDeclaration.class).stream()
            .filter(c -> c.getParameters().size() == 1
                      && c.getParameters().get(0).getTypeAsString().equals("State"))
            .forEach(c -> {
                if (!bodyContainsAssignment(c.getBody(), "isDecided")) {
                    System.out.println("  Rescued: isDecided in copy constructor");
                    c.getBody().addStatement(StaticJavaParser.parseStatement(ISDECIDED_RESCUE));
                }
            });

        // ── resetStateTo: rescue isDecided ───────────────────────────────────
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

    /**
     * Check if a block body already contains an assignment to the given field.
     */
    private static boolean bodyContainsAssignment(BlockStmt body, String fieldName) {
        return body.toString().contains(fieldName + " =")
            || body.toString().contains(fieldName + "=");
    }

    /**
     * Insert a statement before the hash-copy block at the end of a method body.
     * The hash copies are lines like `stateHash = other.stateHash;` which are
     * typically the last ~10 lines.
     */
    private static void addBeforeHashCopies(BlockStmt body, String statementStr) {
        int insertIdx = body.getStatements().size(); // default: end

        // Walk backwards to find first hash copy line
        for (int i = body.getStatements().size() - 1; i >= 0; i--) {
            String line = body.getStatements().get(i).toString();
            if (line.contains("stateHash") || line.contains("moverHash")
                || line.contains("nextHash") || line.contains("prevHash")
                || line.contains("activeHash") || line.contains("checkmatedHash")
                || line.contains("stalematedHash") || line.contains("pendingHash")
                || line.contains("scoreHash") || line.contains("amountHash")) {
                insertIdx = i;
            } else if (insertIdx < body.getStatements().size()) {
                break; // found end of non-hash block
            }
        }

        body.addStatement(insertIdx, StaticJavaParser.parseStatement(statementStr));
    }

    // ══════════════════════════════════════════════════════════════════════════
    // STEP 4: Fix empty methods
    // ══════════════════════════════════════════════════════════════════════════

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

    // ══════════════════════════════════════════════════════════════════════════
    // STEP 5: Make abstract + add copy()
    // ══════════════════════════════════════════════════════════════════════════

    private static void makeAbstract(CompilationUnit cu) {
        cu.findFirst(ClassOrInterfaceDeclaration.class).ifPresent(cls -> {
            // Make the class abstract
            if (!cls.isAbstract()) {
                cls.setAbstract(true);
            }

            // Add: public abstract State copy();
            // Only if it doesn't already exist
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

    // ══════════════════════════════════════════════════════════════════════════
    // STEP 6: Fix class name
    // ══════════════════════════════════════════════════════════════════════════

    private static void fixClassName(CompilationUnit cu) {
        cu.findFirst(ClassOrInterfaceDeclaration.class).ifPresent(cls -> {
            String name = cls.getNameAsString();
            if (!name.equals("State")) {
                System.out.println("  Renamed: " + name + " → State");
                cls.setName("State");
            }
        });

        // Also fix constructor names to match
        cu.findAll(ConstructorDeclaration.class).forEach(ctor -> {
            if (!ctor.getNameAsString().equals("State")) {
                ctor.setName("State");
            }
        });
    }

    // ══════════════════════════════════════════════════════════════════════════
    // STEP 7: Adjust field visibility
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * Make data fields protected so subclasses can access them.
     * Hash value fields (stateHash, moverHash, etc.) stay private —
     * subclasses should use the public API (updateStateHash, fullHash, etc.)
     * not manipulate hashes directly.
     */
    private static void adjustFieldVisibility(CompilationUnit cu) {
        // Hash value fields that should stay private
        Set<String> keepPrivate = new HashSet<>(Arrays.asList(
            "stateHash", "moverHash", "nextHash", "prevHash",
            "activeHash", "checkmatedHash", "stalematedHash",
            "pendingHash", "scoreHash", "amountHash"
        ));

        cu.findAll(FieldDeclaration.class).forEach(field -> {
            String fieldName = field.getVariables().get(0).getNameAsString();

            // Skip constants (static final) and serialVersionUID
            if (field.isStatic() && field.isFinal()) return;

            if (keepPrivate.contains(fieldName)) {
                // Hash values: private (use API, not direct access)
                field.setPublic(false);
                field.setProtected(false);
                field.setPrivate(true);
            } else {
                // Data fields: protected (subclass access)
                field.setPublic(false);
                field.setPrivate(false);
                field.setProtected(true);
            }
        });
    }
}