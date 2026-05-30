package other.state.j;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for JumpingBeans. */
public class JumpingBeansState extends State {

    private static final long serialVersionUID = 1L;

    public JumpingBeansState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public JumpingBeansState(final JumpingBeansState other) {
        super(other);
    }

    @Override public JumpingBeansState copy() { return new JumpingBeansState(this); }

}
