package other.state.undo.m;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for MerimuengRimueng. Prunable fields: sitesToRemove. */
public final class MerimuengRimuengUndoData extends UndoData {

    private final gnu.trove.list.array.TIntArrayList sitesToRemove;

    public MerimuengRimuengUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.sitesToRemove = (context.state().sitesToRemove() == null) ? null : new gnu.trove.list.array.TIntArrayList(context.state().sitesToRemove());
    }

    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
}
