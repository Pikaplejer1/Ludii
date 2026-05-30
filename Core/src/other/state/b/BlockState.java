package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Block. */
public class BlockState extends State {

    private static final long serialVersionUID = 1L;

    private main.collections.FastTIntArrayList remainingDominoes = new main.collections.FastTIntArrayList();

    public BlockState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public BlockState(final BlockState other) {
        super(other);
        remainingDominoes = (other.remainingDominoes != null) ? new main.collections.FastTIntArrayList(other.remainingDominoes) : new main.collections.FastTIntArrayList();
    }

    @Override public BlockState copy() { return new BlockState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final BlockState o = (BlockState) other;
        remainingDominoes = (o.remainingDominoes != null) ? new main.collections.FastTIntArrayList(o.remainingDominoes) : new main.collections.FastTIntArrayList();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        remainingDominoes.clear();
    }

    @Override public main.collections.FastTIntArrayList remainingDominoes() { return remainingDominoes; }

}
