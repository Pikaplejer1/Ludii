package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for AlquerqueDeTres. */
public class AlquerqueDeTresState extends State {

    private static final long serialVersionUID = 1L;

    public AlquerqueDeTresState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public AlquerqueDeTresState(final AlquerqueDeTresState other) {
        super(other);
    }

    @Override public AlquerqueDeTresState copy() { return new AlquerqueDeTresState(this); }

}
