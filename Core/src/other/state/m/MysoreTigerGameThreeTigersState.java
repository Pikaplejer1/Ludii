package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MysoreTigerGameThreeTigers. */
public class MysoreTigerGameThreeTigersState extends State {

    private static final long serialVersionUID = 1L;

    public MysoreTigerGameThreeTigersState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MysoreTigerGameThreeTigersState(final MysoreTigerGameThreeTigersState other) {
        super(other);
    }

    @Override public MysoreTigerGameThreeTigersState copy() { return new MysoreTigerGameThreeTigersState(this); }

}
