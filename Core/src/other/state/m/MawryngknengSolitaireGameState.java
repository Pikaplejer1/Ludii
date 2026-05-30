package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MawryngknengSolitaireGame. */
public class MawryngknengSolitaireGameState extends State {

    private static final long serialVersionUID = 1L;

    public MawryngknengSolitaireGameState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MawryngknengSolitaireGameState(final MawryngknengSolitaireGameState other) {
        super(other);
    }

    @Override public MawryngknengSolitaireGameState copy() { return new MawryngknengSolitaireGameState(this); }

}
