package other.state.undo.m;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for MysoreTigerGame. Prunable fields: sitesToRemove. */
public final class MysoreTigerGameUndoData extends UndoData {

    private final gnu.trove.list.array.TIntArrayList sitesToRemove;

    public MysoreTigerGameUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.sitesToRemove = (context.state().sitesToRemove() == null) ? null : new gnu.trove.list.array.TIntArrayList(context.state().sitesToRemove());
    }

    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
}
