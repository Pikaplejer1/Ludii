package other;

import java.util.BitSet;

import gnu.trove.list.array.TIntArrayList;
import gnu.trove.set.hash.TIntHashSet;
import main.collections.FastTIntArrayList;
import other.UndoData;
import other.context.Context;
import other.state.State;
import other.state.track.OnTrackIndices;

/** Auto-generated UndoData fallback carrying ALL prunable fields. */
public final class FullUndoData extends UndoData
{
	private final TIntHashSet pendingValues;
	private final FastTIntArrayList remainingDominoes;
	private final BitSet visited;
	private final TIntArrayList sitesToRemove;
	private final OnTrackIndices onTrackIndices;

	public FullUndoData(final Context context, final int active, final int[] phases)
	{
		super(context, active, phases);
		final State state = context.state();
		this.pendingValues = (state.pendingValues() == null) ? null : new TIntHashSet(state.pendingValues());
		this.remainingDominoes = (state.remainingDominoes() == null) ? null : new FastTIntArrayList(state.remainingDominoes());
		this.visited = (state.visited() == null) ? null : (BitSet) state.visited().clone();
		this.sitesToRemove = (state.sitesToRemove() == null) ? null : new TIntArrayList(state.sitesToRemove());
		this.onTrackIndices = (state.onTrackIndices() == null) ? null : new OnTrackIndices(state.onTrackIndices());
	}

	@Override public TIntHashSet pendingValues() { return pendingValues; }
	@Override public FastTIntArrayList remainingDominoes() { return remainingDominoes; }
	@Override public BitSet visited() { return visited; }
	@Override public TIntArrayList sitesToRemove() { return sitesToRemove; }
	@Override public OnTrackIndices onTrackIndices() { return onTrackIndices; }
}