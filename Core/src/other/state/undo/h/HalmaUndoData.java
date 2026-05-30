package other.state.undo.h;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for Halma. Prunable fields: visited, sitesToRemove. */
public final class HalmaUndoData extends UndoData {

    private final java.util.BitSet visited;
    private final gnu.trove.list.array.TIntArrayList sitesToRemove;

    public HalmaUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.visited = (context.state().visited() == null) ? null : (java.util.BitSet) context.state().visited().clone();
        this.sitesToRemove = (context.state().sitesToRemove() == null) ? null : new gnu.trove.list.array.TIntArrayList(context.state().sitesToRemove());
    }

    @Override public java.util.BitSet visited() { return visited; }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
}
