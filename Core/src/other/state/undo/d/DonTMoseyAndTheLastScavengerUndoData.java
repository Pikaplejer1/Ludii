package other.state.undo.d;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for DonTMoseyAndTheLastScavenger. Prunable fields: sitesToRemove. */
public final class DonTMoseyAndTheLastScavengerUndoData extends UndoData {

    private final gnu.trove.list.array.TIntArrayList sitesToRemove;

    public DonTMoseyAndTheLastScavengerUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.sitesToRemove = (context.state().sitesToRemove() == null) ? null : new gnu.trove.list.array.TIntArrayList(context.state().sitesToRemove());
    }

    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
}
