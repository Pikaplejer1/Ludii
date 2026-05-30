package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for SigWesternSahara. */
public class SigWesternSaharaState extends State {

    private static final long serialVersionUID = 1L;

    private int[] sumDice = new int[0];
    private int[][] currentDice = new int[0][];
    private boolean diceAllEqual = false;
    private int[] teams = null;
    private gnu.trove.list.array.TIntArrayList sitesToRemove = new gnu.trove.list.array.TIntArrayList();

    public SigWesternSaharaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.hasHandDice() && game.handDice() != null) sumDice = new int[game.handDice().size()];
        if (game.hasHandDice() && game.handDice() != null) {
            currentDice = new int[game.handDice().size()][];
            for (int i = 0; i < game.handDice().size(); i++) {
                final game.equipment.container.other.Dice d = game.handDice().get(i);
                currentDice[i] = new int[d.numLocs()];
            }
        }
        if (game.requiresTeams()) teams = new int[game.players().size()];
    }

    public SigWesternSaharaState(final SigWesternSaharaState other) {
        super(other);
        if (other.sumDice != null) sumDice = java.util.Arrays.copyOf(other.sumDice, other.sumDice.length);
        if (other.currentDice != null) {
            currentDice = new int[other.currentDice.length][];
            for (int i = 0; i < currentDice.length; ++i)
                currentDice[i] = java.util.Arrays.copyOf(other.currentDice[i], other.currentDice[i].length);
        }
        diceAllEqual = other.diceAllEqual;
        if (other.teams != null) teams = java.util.Arrays.copyOf(other.teams, other.teams.length);
        sitesToRemove = (other.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(other.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public SigWesternSaharaState copy() { return new SigWesternSaharaState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final SigWesternSaharaState o = (SigWesternSaharaState) other;
        if (o.sumDice != null) sumDice = java.util.Arrays.copyOf(o.sumDice, o.sumDice.length);
        if (o.currentDice != null) {
            currentDice = new int[o.currentDice.length][];
            for (int i = 0; i < currentDice.length; ++i)
                currentDice[i] = java.util.Arrays.copyOf(o.currentDice[i], o.currentDice[i].length);
        }
        diceAllEqual = o.diceAllEqual;
        if (o.teams != null) teams = java.util.Arrays.copyOf(o.teams, o.teams.length);
        sitesToRemove = (o.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(o.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        if (game.hasHandDice() && game.handDice() != null) sumDice = new int[game.handDice().size()];
        if (game.hasHandDice() && game.handDice() != null) {
            currentDice = new int[game.handDice().size()][];
            for (int i = 0; i < game.handDice().size(); i++) {
                final game.equipment.container.other.Dice d = game.handDice().get(i);
                currentDice[i] = new int[d.numLocs()];
            }
        }
        diceAllEqual = false;
        if (teams != null) for (int i = 1; i < teams.length; i++) teams[i] = i;
        sitesToRemove.clear();
    }

    @Override public int sumDice(final int index) { return sumDice[index]; }
    @Override public int[] sumDice() { return sumDice; }
    @Override public void setSumDice(final int[] sumDice) { this.sumDice = (sumDice != null) ? sumDice : new int[0]; }
    @Override public void reinitSumDice() { for (int i = 0; i < sumDice.length; i++) sumDice[i] = 0; }
    @Override public void updateSumDice(final int dieValue, final int indexHand) { sumDice[indexHand] += dieValue; }

    @Override public int[] currentDice(final int index) { return currentDice[index]; }
    @Override public int[][] currentDice() { return currentDice; }
    @Override public void setCurrentDice(final int[][] currentDice) { this.currentDice = (currentDice != null) ? currentDice : new int[0][]; }
    @Override public void reinitCurrentDice() { for (int i = 0; i < currentDice.length; i++) for (int j = 0; j < currentDice[i].length; j++) currentDice[i][j] = 0; }
    @Override public void updateCurrentDice(final int dieValue, final int dieIndex, final int indexHand) { currentDice[indexHand][dieIndex] = dieValue; }

    @Override public void setDiceAllEqual(final boolean value) { diceAllEqual = value; }
    @Override public boolean isDiceAllEqual() { return diceAllEqual; }

    @Override public boolean playerInTeam(final int pid, final int tid) { return (teams != null && pid < teams.length) && teams[pid] == tid; }
    @Override public void setPlayerToTeam(final int pid, final int tid) {
        if (teamHashes != null) updateStateHash(teamHashes[pid][teams[pid]]);
        teams[pid] = tid;
        if (teamHashes != null) updateStateHash(teamHashes[pid][teams[pid]]);
    }
    @Override public int getTeam(final int pid) { return (teams == null || pid >= teams.length) ? main.Constants.UNDEFINED : teams[pid]; }

    @Override public void reInitCapturedPiece() { sitesToRemove.clear(); }
    @Override public void addSitesToRemove(final int site) { sitesToRemove.add(site); }
    @Override public void removeSitesToRemove(final int site) { sitesToRemove.remove(site); }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
    @Override public game.util.equipment.Region regionToRemove() {
        return new game.util.equipment.Region(sitesToRemove.toArray());
    }

}
