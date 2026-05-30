package other.state.h;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for HewakamKeliya. */
public class HewakamKeliyaState extends State {

    private static final long serialVersionUID = 1L;

    private gnu.trove.list.array.TIntArrayList sitesToRemove = new gnu.trove.list.array.TIntArrayList();

    public HewakamKeliyaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public HewakamKeliyaState(final HewakamKeliyaState other) {
        super(other);
        sitesToRemove = (other.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(other.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public HewakamKeliyaState copy() { return new HewakamKeliyaState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final HewakamKeliyaState o = (HewakamKeliyaState) other;
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
