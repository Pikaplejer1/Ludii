package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MysoreTigerGameTwoTigers. */
public class MysoreTigerGameTwoTigersState extends State {

    private static final long serialVersionUID = 1L;

    public MysoreTigerGameTwoTigersState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MysoreTigerGameTwoTigersState(final MysoreTigerGameTwoTigersState other) {
        super(other);
    }

    @Override public MysoreTigerGameTwoTigersState copy() { return new MysoreTigerGameTwoTigersState(this); }

}
