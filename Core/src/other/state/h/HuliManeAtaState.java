package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for HuliManeAta. */
public class HuliManeAtaState extends State {

    private static final long serialVersionUID = 1L;

    public HuliManeAtaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HuliManeAtaState(final HuliManeAtaState other) {
        super(other);
    }

    @Override public HuliManeAtaState copy() { return new HuliManeAtaState(this); }

}
