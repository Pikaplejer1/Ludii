package other.state.undo.a;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for AsiKeliya. Prunable fields: pendingValues, onTrackIndices. */
public final class AsiKeliyaUndoData extends UndoData {

    private final gnu.trove.set.hash.TIntHashSet pendingValues;
    private final other.state.track.OnTrackIndices onTrackIndices;

    public AsiKeliyaUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.pendingValues = (context.state().pendingValues() == null) ? null : new gnu.trove.set.hash.TIntHashSet(context.state().pendingValues());
        this.onTrackIndices = (context.state().onTrackIndices() == null) ? null : new other.state.track.OnTrackIndices(context.state().onTrackIndices());
    }

    @Override public gnu.trove.set.hash.TIntHashSet pendingValues() { return pendingValues; }
    @Override public other.state.track.OnTrackIndices onTrackIndices() { return onTrackIndices; }
}
