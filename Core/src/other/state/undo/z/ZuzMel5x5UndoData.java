package other.state.undo.z;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for ZuzMel5x5. Prunable fields: sitesToRemove. */
public final class ZuzMel5x5UndoData extends UndoData {

    private final gnu.trove.list.array.TIntArrayList sitesToRemove;

    public ZuzMel5x5UndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.sitesToRemove = (context.state().sitesToRemove() == null) ? null : new gnu.trove.list.array.TIntArrayList(context.state().sitesToRemove());
    }

    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
}
