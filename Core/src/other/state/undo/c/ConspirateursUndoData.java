package other.state.undo.c;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for Conspirateurs. Prunable fields: visited. */
public final class ConspirateursUndoData extends UndoData {

    private final java.util.BitSet visited;

    public ConspirateursUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.visited = (context.state().visited() == null) ? null : (java.util.BitSet) context.state().visited().clone();
    }

    @Override public java.util.BitSet visited() { return visited; }
}
