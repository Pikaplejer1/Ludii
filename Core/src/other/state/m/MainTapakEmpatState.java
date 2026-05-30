package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MainTapakEmpat. */
public class MainTapakEmpatState extends State {

    private static final long serialVersionUID = 1L;

    public MainTapakEmpatState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MainTapakEmpatState(final MainTapakEmpatState other) {
        super(other);
    }

    @Override public MainTapakEmpatState copy() { return new MainTapakEmpatState(this); }

}
