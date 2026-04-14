package other.state;

import game.Game;
import game.Game.StateConstructorLock;

/**
 * Concrete State subclass for Tic-Tac-Toe.
 *
 * TicTacToe uses only the base intersection variables, so this subclass
 * adds no extra fields — it only provides the required copy() implementation.
 *
 * For games that need removed features (votes, sitesToRemove, etc.),
 * the subclass would also override those methods. For example:
 *
 *   public class DraughtsState extends State {
 *       private TIntArrayList sitesToRemove;
 *
 *       @Override public TIntArrayList sitesToRemove() { return sitesToRemove; }
 *       @Override public void addSitesToRemove(int site) { sitesToRemove.add(site); }
 *       // ... etc
 *   }
 */
public class TicTacToeState extends State {

    private static final long serialVersionUID = 1L;

    /**
     * Primary constructor — called by the engine (via Game.java) once.
     */
    public TicTacToeState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    /**
     * Copy constructor — called by copy() below.
     */
    public TicTacToeState(final State other) {
        super(other);
    }

    /**
     * CRITICAL: The engine calls copy() on every move evaluation.
     * Without this, the mover never switches, wins are never detected,
     * and the game loops forever.
     */
    @Override
    public TicTacToeState copy() {
        return new TicTacToeState(this);
    }
}