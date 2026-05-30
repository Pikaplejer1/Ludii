package other.state.undo.f;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for FourPlayerChaturangaAlBiruni. Prunable fields: sitesToRemove. */
public final class FourPlayerChaturangaAlBiruniUndoData extends UndoData {

    private final gnu.trove.list.array.TIntArrayList sitesToRemove;

    public FourPlayerChaturangaAlBiruniUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.sitesToRemove = (context.state().sitesToRemove() == null) ? null : new gnu.trove.list.array.TIntArrayList(context.state().sitesToRemove());
    }

    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
}
