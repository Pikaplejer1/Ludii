package other.state.w;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for WolfAndSheep. */
public class WolfAndSheepState extends State {

    private static final long serialVersionUID = 1L;

    public WolfAndSheepState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public WolfAndSheepState(final WolfAndSheepState other) {
        super(other);
    }

    @Override public WolfAndSheepState copy() { return new WolfAndSheepState(this); }

}
