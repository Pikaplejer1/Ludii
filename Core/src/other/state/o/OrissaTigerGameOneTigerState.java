package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for OrissaTigerGameOneTiger. */
public class OrissaTigerGameOneTigerState extends State {

    private static final long serialVersionUID = 1L;

    public OrissaTigerGameOneTigerState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OrissaTigerGameOneTigerState(final OrissaTigerGameOneTigerState other) {
        super(other);
    }

    @Override public OrissaTigerGameOneTigerState copy() { return new OrissaTigerGameOneTigerState(this); }

}
