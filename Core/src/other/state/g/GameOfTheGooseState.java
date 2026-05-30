package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for GameOfTheGoose. */
public class GameOfTheGooseState extends State {

    private static final long serialVersionUID = 1L;

    private int[] amount = null;
    private int[] sumDice = new int[0];
    private int[][] currentDice = new int[0][];
    private boolean diceAllEqual = false;

    public GameOfTheGooseState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.requiresBet()) amount = new int[game.players().count() + 1];
        if (game.hasHandDice() && game.handDice() != null) sumDice = new int[game.handDice().size()];
        if (game.hasHandDice() && game.handDice() != null) {
            currentDice = new int[game.handDice().size()][];
            for (int i = 0; i < game.handDice().size(); i++) {
                final game.equipment.container.other.Dice d = game.handDice().get(i);
                currentDice[i] = new int[d.numLocs()];
            }
        }
    }

    public GameOfTheGooseState(final GameOfTheGooseState other) {
        super(other);
        if (other.amount != null) amount = java.util.Arrays.copyOf(other.amount, other.amount.length);
        if (other.sumDice != null) sumDice = java.util.Arrays.copyOf(other.sumDice, other.sumDice.length);
        if (other.currentDice != null) {
            currentDice = new int[other.currentDice.length][];
            for (int i = 0; i < currentDice.length; ++i)
                currentDice[i] = java.util.Arrays.copyOf(other.currentDice[i], other.currentDice[i].length);
        }
        diceAllEqual = other.diceAllEqual;
    }

    @Override public GameOfTheGooseState copy() { return new GameOfTheGooseState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final GameOfTheGooseState o = (GameOfTheGooseState) other;
        if (o.amount != null) amount = java.util.Arrays.copyOf(o.amount, o.amount.length);
        if (o.sumDice != null) sumDice = java.util.Arrays.copyOf(o.sumDice, o.sumDice.length);
        if (o.currentDice != null) {
            currentDice = new int[o.currentDice.length][];
            for (int i = 0; i < currentDice.length; ++i)
                currentDice[i] = java.util.Arrays.copyOf(o.currentDice[i], o.currentDice[i].length);
        }
        diceAllEqual = o.diceAllEqual;
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        if (amount != null) for (int i = 0; i < amount.length; i++) amount[i] = 0;
        if (game.hasHandDice() && game.handDice() != null) sumDice = new int[game.handDice().size()];
        if (game.hasHandDice() && game.handDice() != null) {
            currentDice = new int[game.handDice().size()][];
            for (int i = 0; i < game.handDice().size(); i++) {
                final game.equipment.container.other.Dice d = game.handDice().get(i);
                currentDice[i] = new int[d.numLocs()];
            }
        }
        diceAllEqual = false;
    }

    @Override public int amount(final int player) { return (amount != null) ? amount[player] : 0; }
    @Override public void setAmount(final int player, final int newAmount) {
        if (amount != null && player > 0 && player < amount.length) amount[player] = newAmount;
    }
    @Override protected void updateAmountHash(final int player) {
        if (lowAmountHashes != null) {
            if (amount[player] <= AMOUNT_MAX_HASH)
                amountHash ^= lowAmountHashes[player][amount[player]];
            else
                amountHash ^= highAmountHashes[player][amount[player] % AMOUNT_MAX_HASH];
        }
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

}
