package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ChineseCheckers. */
public class ChineseCheckersState extends State {

    private static final long serialVersionUID = 1L;

    private java.util.BitSet visited = new java.util.BitSet();

    public ChineseCheckersState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.requiresVisited()) visited = new java.util.BitSet(game.board().numSites());
    }

    public ChineseCheckersState(final ChineseCheckersState other) {
        super(other);
        visited = (other.visited != null) ? (java.util.BitSet) other.visited.clone() : new java.util.BitSet();
    }

    @Override public ChineseCheckersState copy() { return new ChineseCheckersState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final ChineseCheckersState o = (ChineseCheckersState) other;
        visited = (o.visited != null) ? (java.util.BitSet) o.visited.clone() : new java.util.BitSet();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        if (game.requiresVisited()) visited = new java.util.BitSet(game.board().numSites());
    }

    @Override public void reInitVisited() { visited.clear(); }
    @Override public boolean isVisited(final int site) { return visited.get(site); }
    @Override public void visit(final int site) { if (visited.size() > site && site >= 0) visited.set(site, true); }
    @Override public void unvisit(final int site) { if (visited.size() > site && site >= 0) visited.set(site, false); }
    @Override public java.util.BitSet visited() { return visited; }

}
