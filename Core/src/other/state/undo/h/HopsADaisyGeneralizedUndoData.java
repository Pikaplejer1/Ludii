package other.state.undo.h;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for HopsADaisyGeneralized. Prunable fields: pendingValues, sitesToRemove. */
public final class HopsADaisyGeneralizedUndoData extends UndoData {

    private final gnu.trove.set.hash.TIntHashSet pendingValues;
    private final gnu.trove.list.array.TIntArrayList sitesToRemove;

    public HopsADaisyGeneralizedUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.pendingValues = (context.state().pendingValues() == null) ? null : new gnu.trove.set.hash.TIntHashSet(context.state().pendingValues());
        this.sitesToRemove = (context.state().sitesToRemove() == null) ? null : new gnu.trove.list.array.TIntArrayList(context.state().sitesToRemove());
    }

    @Override public gnu.trove.set.hash.TIntHashSet pendingValues() { return pendingValues; }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
}
