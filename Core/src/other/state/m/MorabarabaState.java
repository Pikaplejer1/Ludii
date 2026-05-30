package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Morabaraba. */
public class MorabarabaState extends State {

    private static final long serialVersionUID = 1L;

    public MorabarabaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MorabarabaState(final MorabarabaState other) {
        super(other);
    }

    @Override public MorabarabaState copy() { return new MorabarabaState(this); }

}
