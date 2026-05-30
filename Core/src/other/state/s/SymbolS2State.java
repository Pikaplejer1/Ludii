package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for SymbolS2. */
public class SymbolS2State extends State {

    private static final long serialVersionUID = 1L;

    public SymbolS2State(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public SymbolS2State(final SymbolS2State other) {
        super(other);
    }

    @Override public SymbolS2State copy() { return new SymbolS2State(this); }

}
