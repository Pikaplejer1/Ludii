package other.state.undo.b;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for Block. Prunable fields: remainingDominoes. */
public final class BlockUndoData extends UndoData {

    private final main.collections.FastTIntArrayList remainingDominoes;

    public BlockUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.remainingDominoes = (context.state().remainingDominoes() == null) ? null : new main.collections.FastTIntArrayList(context.state().remainingDominoes());
    }

    @Override public main.collections.FastTIntArrayList remainingDominoes() { return remainingDominoes; }
}
