package supplementary.experiments.ludemes.LudemeStateAnalysis;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * SubclassGenerator v2 — 18 field recipes.
 *
 * Original 9 (bytecode-detected): amount, valuesPlayer, propositions, votes,
 * notes, sitesToRemove, rememberingValues, mapRememberingValues, valueMap.
 *
 * New 9 (flag-detected): sumDice, currentDice, diceAllEqual, visited, teams,
 * remainingDominoes, pendingValues, onTrackIndices, currentPhase.
 */
public class SubclassGenerator {

    private static final String DEFAULT_OUTPUT_DIR =
        "C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Core\\src\\other\\state";

    static class R {
        final String decl;
        final List<String> init, copy, reset, reinit, over;
        R(String d, List<String> i, List<String> c, List<String> r, List<String> ri, List<String> o) {
            decl=d; init=i; copy=c; reset=r; reinit=ri; over=o;
        }
    }

    static final Map<String, R> RECIPES = buildRecipes();

    private static Map<String, R> buildRecipes() {
        Map<String, R> m = new LinkedHashMap<>();

        // ═══════════ ORIGINAL 9 (bytecode-detected) ═══════════

        m.put("amount", new R(
        	    "private int[] amount = null;",
        	    List.of("if (game.requiresBet()) amount = new int[game.players().count() + 1];"),
        	    List.of("if (other.amount != null) amount = java.util.Arrays.copyOf(other.amount, other.amount.length);"),
        	    List.of("if (o.amount != null) amount = java.util.Arrays.copyOf(o.amount, o.amount.length);"),
        	    List.of("if (amount != null) for (int i = 0; i < amount.length; i++) amount[i] = 0;"),
        	    List.of(
        	        "@Override public int amount(final int player) { return (amount != null) ? amount[player] : 0; }",
        	        "@Override public void setAmount(final int player, final int newAmount) {",
        	        "    if (amount != null && player > 0 && player < amount.length) amount[player] = newAmount;",
        	        "}",
        	        "@Override protected void updateAmountHash(final int player) {",
        	        "    if (lowAmountHashes != null) {",
        	        "        if (amount[player] <= AMOUNT_MAX_HASH)",
        	        "            amountHash ^= lowAmountHashes[player][amount[player]];",
        	        "        else",
        	        "            amountHash ^= highAmountHashes[player][amount[player] % AMOUNT_MAX_HASH];",
        	        "    }",
        	        "}")));

        m.put("valuesPlayer", new R(
            "private int[] valuesPlayer;",
            List.of("valuesPlayer = new int[game.players().size() + 1];",
                     "java.util.Arrays.fill(valuesPlayer, main.Constants.UNDEFINED);"),
            List.of("valuesPlayer = new int[other.valuesPlayer.length];",
                     "System.arraycopy(other.valuesPlayer, 0, valuesPlayer, 0, other.valuesPlayer.length);"),
            List.of("valuesPlayer = new int[o.valuesPlayer.length];",
                     "System.arraycopy(o.valuesPlayer, 0, valuesPlayer, 0, o.valuesPlayer.length);"),
            List.of("java.util.Arrays.fill(valuesPlayer, main.Constants.UNDEFINED);"),
            List.of(
                "@Override public void setValueForPlayer(final int player, final int value) { valuesPlayer[player] = value; }",
                "@Override public int getValue(final int player) { return valuesPlayer[player]; }")));

        m.put("propositions", new R(
            "private gnu.trove.list.array.TIntArrayList propositions;",
            List.of("propositions = game.usesVote() ? new gnu.trove.list.array.TIntArrayList() : null;"),
            List.of("propositions = (other.propositions != null) ? new gnu.trove.list.array.TIntArrayList(other.propositions) : null;"),
            List.of("propositions = (o.propositions != null) ? new gnu.trove.list.array.TIntArrayList(o.propositions) : null;"),
            List.of("if (propositions != null) propositions.clear();"),
            List.of(
                "@Override public gnu.trove.list.array.TIntArrayList propositions() { return propositions; }",
                "@Override public void clearPropositions() { if (propositions != null) propositions.clear(); }")));

        m.put("votes", new R(
            "private gnu.trove.list.array.TIntArrayList votes;",
            List.of("votes = game.usesVote() ? new gnu.trove.list.array.TIntArrayList() : null;"),
            List.of("votes = (other.votes != null) ? new gnu.trove.list.array.TIntArrayList(other.votes) : null;"),
            List.of("votes = (o.votes != null) ? new gnu.trove.list.array.TIntArrayList(o.votes) : null;"),
            List.of("if (votes != null) votes.clear();"),
            List.of(
                "@Override public gnu.trove.list.array.TIntArrayList votes() { return votes; }",
                "@Override public void clearVotes() { if (votes != null) votes.clear(); }")));

        m.put("notes", new R(
            "private gnu.trove.map.TIntObjectMap<gnu.trove.map.TIntObjectMap<String>> notes = null;",
            List.of("if (game.usesNote()) notes = new gnu.trove.map.hash.TIntObjectHashMap<>();"),
            List.of("if (other.notes != null) notes = new gnu.trove.map.hash.TIntObjectHashMap<>(other.notes);"),
            List.of("if (o.notes != null) notes = new gnu.trove.map.hash.TIntObjectHashMap<>(o.notes);"),
            List.of("if (game.usesNote()) notes = new gnu.trove.map.hash.TIntObjectHashMap<>();"),
            List.of(
                "@Override public void addNote(final int move, final int player, final String message) {",
                "    if (notes == null) return;",
                "    if (notes.get(move) == null) notes.put(move, new gnu.trove.map.hash.TIntObjectHashMap<>());",
                "    notes.get(move).put(player, message);",
                "}",
                "@Override public String getNote(final int move, final int player) {",
                "    if (notes == null) return null;",
                "    final gnu.trove.map.TIntObjectMap<String> nfm = notes.get(move);",
                "    return (nfm == null) ? null : nfm.get(player);",
                "}",
                "@Override public gnu.trove.map.TIntObjectMap<gnu.trove.map.TIntObjectMap<String>> getNotes() { return notes; }")));

        m.put("sitesToRemove", new R(
            "private gnu.trove.list.array.TIntArrayList sitesToRemove = null;",
            List.of("if (game.hasSequenceCapture()) sitesToRemove = new gnu.trove.list.array.TIntArrayList();"),
            List.of("if (other.sitesToRemove != null) sitesToRemove = new gnu.trove.list.array.TIntArrayList(other.sitesToRemove);"),
            List.of("if (o.sitesToRemove != null) sitesToRemove = new gnu.trove.list.array.TIntArrayList(o.sitesToRemove);"),
            List.of(),
            List.of(
                "@Override public void reInitCapturedPiece() { if (sitesToRemove != null) sitesToRemove.clear(); }",
                "@Override public void addSitesToRemove(final int site) { if (sitesToRemove != null) sitesToRemove.add(site); }",
                "@Override public void removeSitesToRemove(final int site) { if (sitesToRemove != null) sitesToRemove.remove(site); }",
                "@Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }",
                "@Override public game.util.equipment.Region regionToRemove() {",
                "    return (sitesToRemove == null) ? new game.util.equipment.Region() : new game.util.equipment.Region(sitesToRemove.toArray());",
                "}")));

        m.put("rememberingValues", new R(
            "private main.collections.FastTIntArrayList rememberingValues;",
            List.of("rememberingValues = new main.collections.FastTIntArrayList();"),
            List.of("if (other.rememberingValues != null) rememberingValues = new main.collections.FastTIntArrayList(other.rememberingValues);"),
            List.of("if (o.rememberingValues != null) rememberingValues = new main.collections.FastTIntArrayList(o.rememberingValues);"),
            List.of(),
            List.of("@Override public main.collections.FastTIntArrayList rememberingValues() { return rememberingValues; }")));

        m.put("mapRememberingValues", new R(
            "private java.util.Map<String, main.collections.FastTIntArrayList> mapRememberingValues = null;",
            List.of("if (game.usesRememberingValues()) mapRememberingValues = new java.util.HashMap<>();"),
            List.of("if (other.mapRememberingValues != null) {",
                     "    mapRememberingValues = new java.util.HashMap<>();",
                     "    for (var e : other.mapRememberingValues.entrySet())",
                     "        mapRememberingValues.put(e.getKey(), new main.collections.FastTIntArrayList(e.getValue()));",
                     "}"),
            List.of("if (o.mapRememberingValues != null) {",
                     "    mapRememberingValues = new java.util.HashMap<>();",
                     "    for (var e : o.mapRememberingValues.entrySet())",
                     "        mapRememberingValues.put(e.getKey(), new main.collections.FastTIntArrayList(e.getValue()));",
                     "}"),
            List.of(),
            List.of("@Override public java.util.Map<String, main.collections.FastTIntArrayList> mapRememberingValues() { return mapRememberingValues; }")));

        m.put("valueMap", new R(
            "private gnu.trove.map.TObjectIntMap<String> valueMap = null;",
            List.of("if (game.usesValueMap()) valueMap = new gnu.trove.map.hash.TObjectIntHashMap<>();"),
            List.of("if (other.valueMap != null) valueMap = new gnu.trove.map.hash.TObjectIntHashMap<>(other.valueMap);"),
            List.of("if (o.valueMap != null) valueMap = new gnu.trove.map.hash.TObjectIntHashMap<>(o.valueMap);"),
            List.of(),
            List.of(
                "@Override public void setValue(final String key, final int value) { if (valueMap != null) valueMap.put(key, value); }",
                "@Override public void removeKeyValue(final String key) { if (valueMap != null) valueMap.remove(key); }",
                "@Override public int getValue(final String key) { return (valueMap == null || !valueMap.containsKey(key)) ? main.Constants.OFF : valueMap.get(key); }",
                "@Override public gnu.trove.map.TObjectIntMap<String> getValueMap() { return valueMap; }")));

        // ═══════════ NEW 9 (flag-detected) ═══════════

        m.put("sumDice", new R(
            "private int[] sumDice;",
            List.of("if (game.hasHandDice()) sumDice = new int[game.handDice().size()];"),
            List.of("if (other.sumDice != null) sumDice = java.util.Arrays.copyOf(other.sumDice, other.sumDice.length);"),
            List.of("if (o.sumDice != null) sumDice = java.util.Arrays.copyOf(o.sumDice, o.sumDice.length);"),
            List.of(),
            List.of(
                "@Override public int sumDice(final int index) { return sumDice[index]; }",
                "@Override public int[] sumDice() { return sumDice; }",
                "@Override public void setSumDice(final int[] sumDice) { this.sumDice = sumDice; }",
                "@Override public void reinitSumDice() { for (int i = 0; i < sumDice.length; i++) sumDice[i] = 0; }",
                "@Override public void updateSumDice(final int dieValue, final int indexHand) { sumDice[indexHand] += dieValue; }")));

        m.put("currentDice", new R(
            "private int[][] currentDice;",
            List.of("if (game.hasHandDice()) {",
                     "    currentDice = new int[game.handDice().size()][];",
                     "    for (int i = 0; i < game.handDice().size(); i++) {",
                     "        final game.equipment.container.other.Dice d = game.handDice().get(i);",
                     "        currentDice[i] = new int[d.numLocs()];",
                     "    }",
                     "}"),
            List.of("if (other.currentDice != null) {",
                     "    currentDice = new int[other.currentDice.length][];",
                     "    for (int i = 0; i < currentDice.length; ++i)",
                     "        currentDice[i] = java.util.Arrays.copyOf(other.currentDice[i], other.currentDice[i].length);",
                     "}"),
            List.of("if (o.currentDice != null) {",
                     "    currentDice = new int[o.currentDice.length][];",
                     "    for (int i = 0; i < currentDice.length; ++i)",
                     "        currentDice[i] = java.util.Arrays.copyOf(o.currentDice[i], o.currentDice[i].length);",
                     "}"),
            List.of(),
            List.of(
                "@Override public int[] currentDice(final int index) { return currentDice[index]; }",
                "@Override public int[][] currentDice() { return currentDice; }",
                "@Override public void setCurrentDice(final int[][] currentDice) { this.currentDice = currentDice; }",
                "@Override public void reinitCurrentDice() { for (int i = 0; i < currentDice.length; i++) for (int j = 0; j < currentDice[i].length; j++) currentDice[i][j] = 0; }",
                "@Override public void updateCurrentDice(final int dieValue, final int dieIndex, final int indexHand) { currentDice[indexHand][dieIndex] = dieValue; }")));

        m.put("diceAllEqual", new R(
            "private boolean diceAllEqual = false;",
            List.of(),
            List.of("diceAllEqual = other.diceAllEqual;"),
            List.of("diceAllEqual = o.diceAllEqual;"),
            List.of("diceAllEqual = false;"),
            List.of(
                "@Override public void setDiceAllEqual(final boolean value) { diceAllEqual = value; }",
                "@Override public boolean isDiceAllEqual() { return diceAllEqual; }")));

        m.put("visited", new R(
            "private java.util.BitSet visited = null;",
            List.of("if (game.requiresVisited()) visited = new java.util.BitSet(game.board().numSites());"),
            List.of("if (other.visited != null) visited = (java.util.BitSet) other.visited.clone();"),
            List.of("if (o.visited != null) visited = (java.util.BitSet) o.visited.clone();"),
            List.of(),
            List.of(
                "@Override public void reInitVisited() { if (visited != null) visited.clear(); }",
                "@Override public boolean isVisited(final int site) { return visited != null && visited.get(site); }",
                "@Override public void visit(final int site) { if (visited != null && visited.size() > site && site >= 0) visited.set(site, true); }",
                "@Override public void unvisit(final int site) { if (visited != null && visited.size() > site && site >= 0) visited.set(site, false); }",
                "@Override public java.util.BitSet visited() { return visited; }")));

        m.put("teams", new R(
            "private int[] teams = null;",
            List.of("if (game.requiresTeams()) teams = new int[game.players().size()];"),
            List.of("if (other.teams != null) teams = java.util.Arrays.copyOf(other.teams, other.teams.length);"),
            List.of("if (o.teams != null) teams = java.util.Arrays.copyOf(o.teams, o.teams.length);"),
            List.of("if (teams != null) for (int i = 1; i < teams.length; i++) teams[i] = i;"),
            List.of(
                "@Override public boolean playerInTeam(final int pid, final int tid) { return (teams != null && pid < teams.length) && teams[pid] == tid; }",
                "@Override public void setPlayerToTeam(final int pid, final int tid) {",
                "    if (teamHashes != null) updateStateHash(teamHashes[pid][teams[pid]]);",
                "    teams[pid] = tid;",
                "    if (teamHashes != null) updateStateHash(teamHashes[pid][teams[pid]]);",
                "}",
                "@Override public int getTeam(final int pid) { return (teams == null || pid >= teams.length) ? main.Constants.UNDEFINED : teams[pid]; }")));

        m.put("remainingDominoes", new R(
            "private main.collections.FastTIntArrayList remainingDominoes;",
            List.of("if (game.hasDominoes()) remainingDominoes = new main.collections.FastTIntArrayList();"),
            List.of("if (other.remainingDominoes != null) remainingDominoes = new main.collections.FastTIntArrayList(other.remainingDominoes);"),
            List.of("if (o.remainingDominoes != null) remainingDominoes = new main.collections.FastTIntArrayList(o.remainingDominoes);"),
            List.of(),
            List.of("@Override public main.collections.FastTIntArrayList remainingDominoes() { return remainingDominoes; }")));

        m.put("pendingValues", new R(
            "private gnu.trove.set.hash.TIntHashSet pendingValues = null;",
            List.of("if (game.usesPendingValues()) pendingValues = new gnu.trove.set.hash.TIntHashSet();"),
            List.of("if (other.pendingValues != null) pendingValues = new gnu.trove.set.hash.TIntHashSet(other.pendingValues);"),
            List.of("if (o.pendingValues != null) pendingValues = new gnu.trove.set.hash.TIntHashSet(o.pendingValues);"),
            List.of(),
            List.of(
                "@Override public gnu.trove.set.hash.TIntHashSet pendingValues() { return pendingValues; }",
                "@Override public void setPending(final int value) {",
                "    super.setPending(value);",
                "    final int pv = (value == main.Constants.UNDEFINED) ? 1 : value;",
                "    if (pendingValues != null) pendingValues.add(pv);",
                "}",
                "@Override public boolean isPending() { return pendingValues != null && !pendingValues.isEmpty(); }",
                "@Override public void removePendingValue(final int value) { if (pendingValues != null) pendingValues.remove(value); }",
                "@Override public void rebootPending() {",
                "    if (pendingValues != null) {",
                "        final gnu.trove.iterator.TIntIterator it = pendingValues.iterator();",
                "        while (it.hasNext()) updatePendingHash(it.next());",
                "        pendingValues.clear();",
                "    }",
                "}",
                "@Override public void restorePending(final gnu.trove.set.hash.TIntHashSet values) {",
                "    if (values != null) { rebootPending(); final gnu.trove.iterator.TIntIterator it = values.iterator(); while (it.hasNext()) setPending(it.next()); }",
                "}")));

        m.put("onTrackIndices", new R(
            "private transient other.state.track.OnTrackIndices onTrackIndices;",
            List.of("if (game.hasTrack() && game.hasInternalLoopInTrack())",
                     "    onTrackIndices = new other.state.track.OnTrackIndices(game.board().tracks(), game.equipment().components().length);"),
            List.of("onTrackIndices = copyOnTrackIndices(other.onTrackIndices);"),
            List.of("onTrackIndices = copyOnTrackIndices(o.onTrackIndices);"),
            List.of(),
            List.of(
                "@Override public other.state.track.OnTrackIndices onTrackIndices() { return onTrackIndices; }",
                "@Override public void setOnTrackIndices(final other.state.track.OnTrackIndices oti) {",
                "    this.onTrackIndices = (oti == null) ? null : new other.state.track.OnTrackIndices(oti);",
                "}")));

        

        return m;
    }

    // ══════════════════════════════════════════════════════════════════════
    // GENERATE
    // ══════════════════════════════════════════════════════════════════════

    public static void generate(String gameName, Set<String> fields, String outputDir) {
        String cls = gameName + "State";
        StringBuilder s = new StringBuilder();

        s.append("package other.state;\n\nimport game.Game;\nimport game.Game.StateConstructorLock;\n\n");
        s.append("/** Auto-generated State subclass for ").append(gameName).append(". */\n");
        s.append("public class ").append(cls).append(" extends State {\n\n");
        s.append("    private static final long serialVersionUID = 1L;\n\n");

        // Fields
        for (String f : fields) { R r = RECIPES.get(f); if (r != null) s.append("    ").append(r.decl).append("\n"); }
        if (!fields.isEmpty()) s.append("\n");

        // Primary constructor
        s.append("    public ").append(cls).append("(final Game game, final StateConstructorLock lock) {\n");
        s.append("        super(game, lock);\n");
        for (String f : fields) { R r = RECIPES.get(f); if (r != null) for (String l : r.init) s.append("        ").append(l).append("\n"); }
        s.append("    }\n\n");

        // Copy constructor
        s.append("    public ").append(cls).append("(final ").append(cls).append(" other) {\n");
        s.append("        super(other);\n");
        for (String f : fields) { R r = RECIPES.get(f); if (r != null) for (String l : r.copy) s.append("        ").append(l).append("\n"); }
        s.append("    }\n\n");

        // copy()
        s.append("    @Override public ").append(cls).append(" copy() { return new ").append(cls).append("(this); }\n\n");

        // resetStateTo
        if (!fields.isEmpty()) {
            s.append("    @Override public void resetStateTo(final State other, final Game game) {\n");
            s.append("        super.resetStateTo(other, game);\n");
            s.append("        final ").append(cls).append(" o = (").append(cls).append(") other;\n");
            for (String f : fields) { R r = RECIPES.get(f); if (r != null) for (String l : r.reset) s.append("        ").append(l).append("\n"); }
            s.append("    }\n\n");
        }

        // initialise
        boolean hasInit = fields.stream().anyMatch(f -> RECIPES.containsKey(f) && !RECIPES.get(f).reinit.isEmpty());
        if (hasInit) {
            s.append("    @Override public void initialise(final Game game) {\n");
            s.append("        super.initialise(game);\n");
            for (String f : fields) { R r = RECIPES.get(f); if (r != null) for (String l : r.reinit) s.append("        ").append(l).append("\n"); }
            s.append("    }\n\n");
        }

        // Method overrides
        for (String f : fields) {
            R r = RECIPES.get(f);
            if (r != null && !r.over.isEmpty()) {
                for (String l : r.over) s.append("    ").append(l).append("\n");
                s.append("\n");
            }
        }

        s.append("}\n");

        try {
            Path p = Path.of(outputDir, cls + ".java");
            Files.writeString(p, s.toString());
            System.out.println("  Generated: " + p);
        } catch (Exception e) {
            System.err.println("  FAILED: " + e.getMessage());
        }
    }

    public static void generate(String gameName, Set<String> fields) {
        generate(gameName, fields, DEFAULT_OUTPUT_DIR);
    }

    public static void main(String[] args) {
        System.out.println("=== SubclassGenerator v2 test ===\n");
        generate("TicTacToe", Set.of());
        generate("EnglishDraughts", Set.of("sitesToRemove"));
        generate("Backgammon", new LinkedHashSet<>(List.of("sumDice", "currentDice", "diceAllEqual")));
        generate("Full", new LinkedHashSet<>(RECIPES.keySet()));
        System.out.println("\nDone.");
    }
}