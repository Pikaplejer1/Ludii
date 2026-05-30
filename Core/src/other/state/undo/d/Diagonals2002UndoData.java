package other.state.undo.d;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for Diagonals2002. Prunable fields: sitesToRemove. */
public final class Diagonals2002UndoData extends UndoData {

    private final gnu.trove.list.array.TIntArrayList sitesToRemove;

    public Diagonals2002UndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.sitesToRemove = (context.state().sitesToRemove() == null) ? null : new gnu.trove.list.array.TIntArrayList(context.state().sitesToRemove());
    }

    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
}
