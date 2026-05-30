package other.state.f;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for FirstAttack. */
public class FirstAttackState extends State {

    private static final long serialVersionUID = 1L;

    public FirstAttackState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public FirstAttackState(final FirstAttackState other) {
        super(other);
    }

    @Override public FirstAttackState copy() { return new FirstAttackState(this); }

}
