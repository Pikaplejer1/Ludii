package other.state.undo.p;

import other.UndoData;
import other.context.Context;

/** Auto-generated UndoData subclass for PareiaDeEntrada. Prunable fields: pendingValues. */
public final class PareiaDeEntradaUndoData extends UndoData {

    private final gnu.trove.set.hash.TIntHashSet pendingValues;

    public PareiaDeEntradaUndoData(final Context context, final int active, final int[] phases) {
        super(context, active, phases);
        this.pendingValues = (context.state().pendingValues() == null) ? null : new gnu.trove.set.hash.TIntHashSet(context.state().pendingValues());
    }

    @Override public gnu.trove.set.hash.TIntHashSet pendingValues() { return pendingValues; }
}
