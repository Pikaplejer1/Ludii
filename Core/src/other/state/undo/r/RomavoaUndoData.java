package other.state.undo.r;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for Romavoa. Prunable fields: onTrackIndices. */
public final class RomavoaUndoData extends UndoData {

    private final other.state.track.OnTrackIndices onTrackIndices;

    public RomavoaUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.onTrackIndices = (context.state().onTrackIndices() == null) ? null : new other.state.track.OnTrackIndices(context.state().onTrackIndices());
    }

    @Override public other.state.track.OnTrackIndices onTrackIndices() { return onTrackIndices; }
}
