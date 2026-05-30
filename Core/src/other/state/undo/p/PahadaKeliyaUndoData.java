package other.state.undo.p;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for PahadaKeliya. Prunable fields: onTrackIndices, sitesToRemove. */
public final class PahadaKeliyaUndoData extends UndoData {

    private final other.state.track.OnTrackIndices onTrackIndices;
    private final gnu.trove.list.array.TIntArrayList sitesToRemove;

    public PahadaKeliyaUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.onTrackIndices = (context.state().onTrackIndices() == null) ? null : new other.state.track.OnTrackIndices(context.state().onTrackIndices());
        this.sitesToRemove = (context.state().sitesToRemove() == null) ? null : new gnu.trove.list.array.TIntArrayList(context.state().sitesToRemove());
    }

    @Override public other.state.track.OnTrackIndices onTrackIndices() { return onTrackIndices; }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
}
