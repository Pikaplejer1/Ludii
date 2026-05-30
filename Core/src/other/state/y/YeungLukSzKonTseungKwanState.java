package other.state.y;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for YeungLukSzKonTseungKwan. */
public class YeungLukSzKonTseungKwanState extends State {

    private static final long serialVersionUID = 1L;

    public YeungLukSzKonTseungKwanState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public YeungLukSzKonTseungKwanState(final YeungLukSzKonTseungKwanState other) {
        super(other);
    }

    @Override public YeungLukSzKonTseungKwanState copy() { return new YeungLukSzKonTseungKwanState(this); }

}
