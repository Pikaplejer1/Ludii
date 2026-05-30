package other.state.o;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for OrissaTigerGameFourTigers. */
public class OrissaTigerGameFourTigersState extends State {

    private static final long serialVersionUID = 1L;

    public OrissaTigerGameFourTigersState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public OrissaTigerGameFourTigersState(final OrissaTigerGameFourTigersState other) {
        super(other);
    }

    @Override public OrissaTigerGameFourTigersState copy() { return new OrissaTigerGameFourTigersState(this); }

}
