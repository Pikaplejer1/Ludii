package other.state.u;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for UmElBagara. */
public class UmElBagaraState extends State {

    private static final long serialVersionUID = 1L;

    public UmElBagaraState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public UmElBagaraState(final UmElBagaraState other) {
        super(other);
    }

    @Override public UmElBagaraState copy() { return new UmElBagaraState(this); }

}
