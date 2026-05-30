package other.state.p;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Pachgarhwa. */
public class PachgarhwaState extends State {

    private static final long serialVersionUID = 1L;

    private gnu.trove.set.hash.TIntHashSet pendingValues = new gnu.trove.set.hash.TIntHashSet();

    public PachgarhwaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public PachgarhwaState(final PachgarhwaState other) {
        super(other);
        pendingValues = (other.pendingValues != null) ? new gnu.trove.set.hash.TIntHashSet(other.pendingValues) : new gnu.trove.set.hash.TIntHashSet();
    }

    @Override public PachgarhwaState copy() { return new PachgarhwaState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final PachgarhwaState o = (PachgarhwaState) other;
        pendingValues = (o.pendingValues != null) ? new gnu.trove.set.hash.TIntHashSet(o.pendingValues) : new gnu.trove.set.hash.TIntHashSet();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        pendingValues.clear();
    }

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

}
