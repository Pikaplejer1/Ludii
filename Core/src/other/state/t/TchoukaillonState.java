package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Tchoukaillon. */
public class TchoukaillonState extends State {

    private static final long serialVersionUID = 1L;

    public TchoukaillonState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TchoukaillonState(final TchoukaillonState other) {
        super(other);
    }

    @Override public TchoukaillonState copy() { return new TchoukaillonState(this); }

}
