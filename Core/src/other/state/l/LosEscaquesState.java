package other.state.l;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for LosEscaques. */
public class LosEscaquesState extends State {

    private static final long serialVersionUID = 1L;

    private int[] sumDice = new int[0];
    private int[][] currentDice = new int[0][];
    private boolean diceAllEqual = false;
    private gnu.trove.list.array.TIntArrayList propositions = new gnu.trove.list.array.TIntArrayList();
    private gnu.trove.list.array.TIntArrayList votes = new gnu.trove.list.array.TIntArrayList();

    public LosEscaquesState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.hasHandDice() && game.handDice() != null) sumDice = new int[game.handDice().size()];
        if (game.hasHandDice() && game.handDice() != null) {
            currentDice = new int[game.handDice().size()][];
            for (int i = 0; i < game.handDice().size(); i++) {
                final game.equipment.container.other.Dice d = game.handDice().get(i);
                currentDice[i] = new int[d.numLocs()];
            }
        }
    }

    public LosEscaquesState(final LosEscaquesState other) {
        super(other);
        if (other.sumDice != null) sumDice = java.util.Arrays.copyOf(other.sumDice, other.sumDice.length);
        if (other.currentDice != null) {
            currentDice = new int[other.currentDice.length][];
            for (int i = 0; i < currentDice.length; ++i)
                currentDice[i] = java.util.Arrays.copyOf(other.currentDice[i], other.currentDice[i].length);
        }
        diceAllEqual = other.diceAllEqual;
        propositions = (other.propositions != null) ? new gnu.trove.list.array.TIntArrayList(other.propositions) : new gnu.trove.list.array.TIntArrayList();
        votes = (other.votes != null) ? new gnu.trove.list.array.TIntArrayList(other.votes) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public LosEscaquesState copy() { return new LosEscaquesState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final LosEscaquesState o = (LosEscaquesState) other;
        if (o.sumDice != null) sumDice = java.util.Arrays.copyOf(o.sumDice, o.sumDice.length);
        if (o.currentDice != null) {
            currentDice = new int[o.currentDice.length][];
            for (int i = 0; i < currentDice.length; ++i)
                currentDice[i] = java.util.Arrays.copyOf(o.currentDice[i], o.currentDice[i].length);
        }
        diceAllEqual = o.diceAllEqual;
        propositions = (o.propositions != null) ? new gnu.trove.list.array.TIntArrayList(o.propositions) : new gnu.trove.list.array.TIntArrayList();
        votes = (o.votes != null) ? new gnu.trove.list.array.TIntArrayList(o.votes) : new gnu.trove.list.array.TIntArrayList();
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
        propositions.clear();
        votes.clear();
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

    @Override public gnu.trove.list.array.TIntArrayList propositions() { return propositions; }
    @Override public void clearPropositions() { propositions.clear(); }

    @Override public gnu.trove.list.array.TIntArrayList votes() { return votes; }
    @Override public void clearVotes() { votes.clear(); }

}
