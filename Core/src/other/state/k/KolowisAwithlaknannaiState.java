package other.state.k;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for KolowisAwithlaknannai. */
public class KolowisAwithlaknannaiState extends State {

    private static final long serialVersionUID = 1L;

    public KolowisAwithlaknannaiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public KolowisAwithlaknannaiState(final KolowisAwithlaknannaiState other) {
        super(other);
    }

    @Override public KolowisAwithlaknannaiState copy() { return new KolowisAwithlaknannaiState(this); }

}
