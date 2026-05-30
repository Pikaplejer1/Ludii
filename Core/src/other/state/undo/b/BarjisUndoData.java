package other.state.undo.b;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for Barjis. Prunable fields: onTrackIndices. */
public final class BarjisUndoData extends UndoData {

    private final other.state.track.OnTrackIndices onTrackIndices;

    public BarjisUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.onTrackIndices = (context.state().onTrackIndices() == null) ? null : new other.state.track.OnTrackIndices(context.state().onTrackIndices());
    }

    @Override public other.state.track.OnTrackIndices onTrackIndices() { return onTrackIndices; }
}
