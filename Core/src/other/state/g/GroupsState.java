package other.state.g;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Groups. */
public class GroupsState extends State {

    private static final long serialVersionUID = 1L;

    public GroupsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public GroupsState(final GroupsState other) {
        super(other);
    }

    @Override public GroupsState copy() { return new GroupsState(this); }

}
