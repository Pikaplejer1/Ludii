package other.state;

import game.Game;
import game.Game.StateConstructorLock;
import game.rules.phase.Phase;
import game.types.play.RoleType;

/** Auto-generated State subclass for Backgammon. */
public class BackgammonState extends State {

    private static final long serialVersionUID = 1L;

    private int[] sumDice;
    private int[][] currentDice;
    private boolean diceAllEqual = false;
    private int[] currentPhase;

    public BackgammonState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.hasHandDice()) sumDice = new int[game.handDice().size()];
        if (game.hasHandDice()) {
            currentDice = new int[game.handDice().size()][];
            for (int i = 0; i < game.handDice().size(); i++) {
                final game.equipment.container.other.Dice d = game.handDice().get(i);
                currentDice[i] = new int[d.numLocs()];
            }
        }
    }

    public BackgammonState(final BackgammonState other) {
        super(other);
        if (other.sumDice != null) sumDice = java.util.Arrays.copyOf(other.sumDice, other.sumDice.length);
        if (other.currentDice != null) {
            currentDice = new int[other.currentDice.length][];
            for (int i = 0; i < currentDice.length; ++i)
                currentDice[i] = java.util.Arrays.copyOf(other.currentDice[i], other.currentDice[i].length);
        }
        diceAllEqual = other.diceAllEqual;
        if (other.currentPhase != null) currentPhase = java.util.Arrays.copyOf(other.currentPhase, other.currentPhase.length);
    }

    @Override public BackgammonState copy() { return new BackgammonState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final BackgammonState o = (BackgammonState) other;
        if (o.sumDice != null) sumDice = java.util.Arrays.copyOf(o.sumDice, o.sumDice.length);
        if (o.currentDice != null) {
            currentDice = new int[o.currentDice.length][];
            for (int i = 0; i < currentDice.length; ++i)
                currentDice[i] = java.util.Arrays.copyOf(o.currentDice[i], o.currentDice[i].length);
        }
        diceAllEqual = o.diceAllEqual;
        if (o.currentPhase != null) currentPhase = java.util.Arrays.copyOf(o.currentPhase, o.currentPhase.length);
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        diceAllEqual = false;
    }

    @Override public int sumDice(final int index) { return sumDice[index]; }
    @Override public int[] sumDice() { return sumDice; }
    @Override public void setSumDice(final int[] sumDice) { this.sumDice = sumDice; }
    @Override public void reinitSumDice() { for (int i = 0; i < sumDice.length; i++) sumDice[i] = 0; }
    @Override public void updateSumDice(final int dieValue, final int indexHand) { sumDice[indexHand] += dieValue; }

    @Override public int[] currentDice(final int index) { return currentDice[index]; }
    @Override public int[][] currentDice() { return currentDice; }
    @Override public void setCurrentDice(final int[][] currentDice) { this.currentDice = currentDice; }
    @Override public void reinitCurrentDice() { for (int i = 0; i < currentDice.length; i++) for (int j = 0; j < currentDice[i].length; j++) currentDice[i][j] = 0; }
    @Override public void updateCurrentDice(final int dieValue, final int dieIndex, final int indexHand) { currentDice[indexHand][dieIndex] = dieValue; }

    @Override public void setDiceAllEqual(final boolean value) { diceAllEqual = value; }
    @Override public boolean isDiceAllEqual() { return diceAllEqual; }

    @Override public int currentPhase(final int indexPlayer) { return currentPhase != null ? currentPhase[indexPlayer] : 0; }
    @Override public void setPhase(final int indexPlayer, final int newPhase) {
        if (phaseHashes != null) updateStateHash(phaseHashes[indexPlayer][currentPhase[indexPlayer]]);
        currentPhase[indexPlayer] = newPhase;
        if (phaseHashes != null) updateStateHash(phaseHashes[indexPlayer][currentPhase[indexPlayer]]);
    }
    @Override public void initPhase(final Game game)
   	{
   		if (game.rules() != null && game.rules().phases() != null)
   		{
   			currentPhase = new int[game.players().count() + 1];
   			for (int pid = 1; pid <= game.players().count(); pid++)
   			{
   				for (int indexPhase = 0; indexPhase < game.rules().phases().length; indexPhase++)
   				{
   					final Phase phase = game.rules().phases()[indexPhase];
   					
   					final RoleType roleType = phase.owner();
   					if (roleType == null) 
   						continue;
   					
   					final int phaseOwner = roleType.owner();
   					if (phaseOwner == pid || roleType == RoleType.Shared)
   					{
   						currentPhase[pid] = indexPhase;
   						break;
   					}
   				}
   			}

//   			System.out.println("INIT PHASES:");
//   			for (int i = 1; i <= currentPhase.length; i++)
//   				System.out.println("Player " + i + " Phase = " + currentPhase[i - 1]);
   		}
   	}
}
