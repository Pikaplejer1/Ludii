package other.state.m;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for MainChatorBatak. */
public class MainChatorBatakState extends State {

    private static final long serialVersionUID = 1L;

    private gnu.trove.list.array.TIntArrayList sitesToRemove = new gnu.trove.list.array.TIntArrayList();

    public MainChatorBatakState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public MainChatorBatakState(final MainChatorBatakState other) {
        super(other);
        sitesToRemove = (other.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(other.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public MainChatorBatakState copy() { return new MainChatorBatakState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final MainChatorBatakState o = (MainChatorBatakState) other;
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
