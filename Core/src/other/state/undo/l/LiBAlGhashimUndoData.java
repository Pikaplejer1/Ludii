package other.state.undo.l;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for LiBAlGhashim. Prunable fields: pendingValues. */
public final class LiBAlGhashimUndoData extends UndoData {

    private final gnu.trove.set.hash.TIntHashSet pendingValues;

    public LiBAlGhashimUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.pendingValues = (context.state().pendingValues() == null) ? null : new gnu.trove.set.hash.TIntHashSet(context.state().pendingValues());
    }

    @Override public gnu.trove.set.hash.TIntHashSet pendingValues() { return pendingValues; }
}
