package other.state;

import game.Game;
import game.Game.StateConstructorLock;

/** Auto-generated State subclass for EnglishDraughts. */
public class EnglishDraughtsState extends State {

    private static final long serialVersionUID = 1L;

    private gnu.trove.list.array.TIntArrayList sitesToRemove = null;

    public EnglishDraughtsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.hasSequenceCapture()) sitesToRemove = new gnu.trove.list.array.TIntArrayList();
    }

    public EnglishDraughtsState(final EnglishDraughtsState other) {
        super(other);
        if (other.sitesToRemove != null) sitesToRemove = new gnu.trove.list.array.TIntArrayList(other.sitesToRemove);
    }

    @Override public EnglishDraughtsState copy() { return new EnglishDraughtsState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final EnglishDraughtsState o = (EnglishDraughtsState) other;
        if (o.sitesToRemove != null) sitesToRemove = new gnu.trove.list.array.TIntArrayList(o.sitesToRemove);
    }

    @Override public void reInitCapturedPiece() { if (sitesToRemove != null) sitesToRemove.clear(); }
    @Override public void addSitesToRemove(final int site) { if (sitesToRemove != null) sitesToRemove.add(site); }
    @Override public void removeSitesToRemove(final int site) { if (sitesToRemove != null) sitesToRemove.remove(site); }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
    @Override public game.util.equipment.Region regionToRemove() {
        return (sitesToRemove == null) ? new game.util.equipment.Region() : new game.util.equipment.Region(sitesToRemove.toArray());
    }

}
