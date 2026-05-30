package other.state.v;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for VikingChess. */
public class VikingChessState extends State {

    private static final long serialVersionUID = 1L;

    public VikingChessState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public VikingChessState(final VikingChessState other) {
        super(other);
    }

    @Override public VikingChessState copy() { return new VikingChessState(this); }

}
