package other.state.undo.t;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for TriItOut. Prunable fields: pendingValues. */
public final class TriItOutUndoData extends UndoData {

    private final gnu.trove.set.hash.TIntHashSet pendingValues;

    public TriItOutUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.pendingValues = (context.state().pendingValues() == null) ? null : new gnu.trove.set.hash.TIntHashSet(context.state().pendingValues());
    }

    @Override public gnu.trove.set.hash.TIntHashSet pendingValues() { return pendingValues; }
}
