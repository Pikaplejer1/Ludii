package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TripleTangle. */
public class TripleTangleState extends State {

    private static final long serialVersionUID = 1L;

    private gnu.trove.list.array.TIntArrayList sitesToRemove = new gnu.trove.list.array.TIntArrayList();

    public TripleTangleState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TripleTangleState(final TripleTangleState other) {
        super(other);
        sitesToRemove = (other.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(other.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public TripleTangleState copy() { return new TripleTangleState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final TripleTangleState o = (TripleTangleState) other;
        sitesToRemove = (o.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(o.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        sitesToRemove.clear();
    }

    @Override public void reInitCapturedPiece() { sitesToRemove.clear(); }
    @Override public void addSitesToRemove(final int site) { sitesToRemove.add(site); }
    @Override public void removeSitesToRemove(final int site) { sitesToRemove.remove(site); }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
    @Override public game.util.equipment.Region regionToRemove() {
        return new game.util.equipment.Region(sitesToRemove.toArray());
    }

}
