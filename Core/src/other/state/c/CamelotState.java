package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Camelot. */
public class CamelotState extends State {

    private static final long serialVersionUID = 1L;

    private java.util.BitSet visited = new java.util.BitSet();
    private gnu.trove.set.hash.TIntHashSet pendingValues = new gnu.trove.set.hash.TIntHashSet();
    private gnu.trove.list.array.TIntArrayList sitesToRemove = new gnu.trove.list.array.TIntArrayList();

    public CamelotState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.requiresVisited()) visited = new java.util.BitSet(game.board().numSites());
    }

    public CamelotState(final CamelotState other) {
        super(other);
        visited = (other.visited != null) ? (java.util.BitSet) other.visited.clone() : new java.util.BitSet();
        pendingValues = (other.pendingValues != null) ? new gnu.trove.set.hash.TIntHashSet(other.pendingValues) : new gnu.trove.set.hash.TIntHashSet();
        sitesToRemove = (other.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(other.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public CamelotState copy() { return new CamelotState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final CamelotState o = (CamelotState) other;
        visited = (o.visited != null) ? (java.util.BitSet) o.visited.clone() : new java.util.BitSet();
        pendingValues = (o.pendingValues != null) ? new gnu.trove.set.hash.TIntHashSet(o.pendingValues) : new gnu.trove.set.hash.TIntHashSet();
        sitesToRemove = (o.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(o.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        if (game.requiresVisited()) visited = new java.util.BitSet(game.board().numSites());
        pendingValues.clear();
        sitesToRemove.clear();
    }

    @Override public void reInitVisited() { visited.clear(); }
    @Override public boolean isVisited(final int site) { return visited.get(site); }
    @Override public void visit(final int site) { if (visited.size() > site && site >= 0) visited.set(site, true); }
    @Override public void unvisit(final int site) { if (visited.size() > site && site >= 0) visited.set(site, false); }
    @Override public java.util.BitSet visited() { return visited; }

    @Override public gnu.trove.set.hash.TIntHashSet pendingValues() { return pendingValues; }
    @Override public void setPending(final int value) {
        super.setPending(value);
        final int pv = (value == main.Constants.UNDEFINED) ? 1 : value;
        pendingValues.add(pv);
    }
    @Override public boolean isPending() { return !pendingValues.isEmpty(); }
    @Override public void removePendingValue(final int value) { pendingValues.remove(value); }
    @Override public void rebootPending() {
        final gnu.trove.iterator.TIntIterator it = pendingValues.iterator();
        while (it.hasNext()) updatePendingHash(it.next());
        pendingValues.clear();
    }
    @Override public void restorePending(final gnu.trove.set.hash.TIntHashSet values) {
        if (values != null) { rebootPending(); final gnu.trove.iterator.TIntIterator it = values.iterator(); while (it.hasNext()) setPending(it.next()); }
    }

    @Override public void reInitCapturedPiece() { sitesToRemove.clear(); }
    @Override public void addSitesToRemove(final int site) { sitesToRemove.add(site); }
    @Override public void removeSitesToRemove(final int site) { sitesToRemove.remove(site); }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
    @Override public game.util.equipment.Region regionToRemove() {
        return new game.util.equipment.Region(sitesToRemove.toArray());
    }

}
