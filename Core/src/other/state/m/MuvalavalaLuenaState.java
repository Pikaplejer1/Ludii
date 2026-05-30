package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MuvalavalaLuena. */
public class MuvalavalaLuenaState extends State {

    private static final long serialVersionUID = 1L;

    public MuvalavalaLuenaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MuvalavalaLuenaState(final MuvalavalaLuenaState other) {
        super(other);
    }

    @Override public MuvalavalaLuenaState copy() { return new MuvalavalaLuenaState(this); }

}
