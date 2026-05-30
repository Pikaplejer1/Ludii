package other.state.y;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for YaguareteKora. */
public class YaguareteKoraState extends State {

    private static final long serialVersionUID = 1L;

    public YaguareteKoraState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public YaguareteKoraState(final YaguareteKoraState other) {
        super(other);
    }

    @Override public YaguareteKoraState copy() { return new YaguareteKoraState(this); }

}
