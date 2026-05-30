package other.state.undo.q;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for QuantumLeap. Prunable fields: sitesToRemove. */
public final class QuantumLeapUndoData extends UndoData {

    private final gnu.trove.list.array.TIntArrayList sitesToRemove;

    public QuantumLeapUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.sitesToRemove = (context.state().sitesToRemove() == null) ? null : new gnu.trove.list.array.TIntArrayList(context.state().sitesToRemove());
    }

    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
}
