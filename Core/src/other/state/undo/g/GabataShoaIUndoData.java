package other.state.undo.g;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for GabataShoaI. Prunable fields: pendingValues. */
public final class GabataShoaIUndoData extends UndoData {

    private final gnu.trove.set.hash.TIntHashSet pendingValues;

    public GabataShoaIUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.pendingValues = (context.state().pendingValues() == null) ? null : new gnu.trove.set.hash.TIntHashSet(context.state().pendingValues());
    }

    @Override public gnu.trove.set.hash.TIntHashSet pendingValues() { return pendingValues; }
}
