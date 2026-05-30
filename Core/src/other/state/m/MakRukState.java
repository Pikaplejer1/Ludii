package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MakRuk. */
public class MakRukState extends State {

    private static final long serialVersionUID = 1L;

    public MakRukState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MakRukState(final MakRukState other) {
        super(other);
    }

    @Override public MakRukState copy() { return new MakRukState(this); }

}
