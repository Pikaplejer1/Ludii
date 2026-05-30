package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Salta. */
public class SaltaState extends State {

    private static final long serialVersionUID = 1L;

    private java.util.BitSet visited = new java.util.BitSet();
    private gnu.trove.list.array.TIntArrayList sitesToRemove = new gnu.trove.list.array.TIntArrayList();

    public SaltaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.requiresVisited()) visited = new java.util.BitSet(game.board().numSites());
    }

    public SaltaState(final SaltaState other) {
        super(other);
        visited = (other.visited != null) ? (java.util.BitSet) other.visited.clone() : new java.util.BitSet();
        sitesToRemove = (other.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(other.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public SaltaState copy() { return new SaltaState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final SaltaState o = (SaltaState) other;
        visited = (o.visited != null) ? (java.util.BitSet) o.visited.clone() : new java.util.BitSet();
        sitesToRemove = (o.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(o.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        if (game.requiresVisited()) visited = new java.util.BitSet(game.board().numSites());
        sitesToRemove.clear();
    }

    @Override public void reInitVisited() { visited.clear(); }
    @Override public boolean isVisited(final int site) { return visited.get(site); }
    @Override public void visit(final int site) { if (visited.size() > site && site >= 0) visited.set(site, true); }
    @Override public void unvisit(final int site) { if (visited.size() > site && site >= 0) visited.set(site, false); }
    @Override public java.util.BitSet visited() { return visited; }

    @Override public void reInitCapturedPiece() { sitesToRemove.clear(); }
    @Override public void addSitesToRemove(final int site) { sitesToRemove.add(site); }
    @Override public void removeSitesToRemove(final int site) { sitesToRemove.remove(site); }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
    @Override public game.util.equipment.Region regionToRemove() {
        return new game.util.equipment.Region(sitesToRemove.toArray());
    }

}
