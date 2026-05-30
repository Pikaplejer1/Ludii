package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for BamBlangBehKhla. */
public class BamBlangBehKhlaState extends State {

    private static final long serialVersionUID = 1L;

    public BamBlangBehKhlaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BamBlangBehKhlaState(final BamBlangBehKhlaState other) {
        super(other);
    }

    @Override public BamBlangBehKhlaState copy() { return new BamBlangBehKhlaState(this); }

}
