package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MuvalavalaQuioco. */
public class MuvalavalaQuiocoState extends State {

    private static final long serialVersionUID = 1L;

    public MuvalavalaQuiocoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MuvalavalaQuiocoState(final MuvalavalaQuiocoState other) {
        super(other);
    }

    @Override public MuvalavalaQuiocoState copy() { return new MuvalavalaQuiocoState(this); }

}
