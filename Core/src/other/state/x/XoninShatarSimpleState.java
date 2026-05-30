package other.state.x;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for XoninShatarSimple. */
public class XoninShatarSimpleState extends State {

    private static final long serialVersionUID = 1L;

    public XoninShatarSimpleState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public XoninShatarSimpleState(final XoninShatarSimpleState other) {
        super(other);
    }

    @Override public XoninShatarSimpleState copy() { return new XoninShatarSimpleState(this); }

}
