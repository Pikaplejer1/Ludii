package other.state.a;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for AcedrexDeLosCuatrosTiempos. */
public class AcedrexDeLosCuatrosTiemposState extends State {

    private static final long serialVersionUID = 1L;

    private gnu.trove.map.TIntObjectMap<gnu.trove.map.TIntObjectMap<String>> notes = null;
    private int[] amount = null;
    private gnu.trove.list.array.TIntArrayList sitesToRemove = new gnu.trove.list.array.TIntArrayList();

    public AcedrexDeLosCuatrosTiemposState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.usesNote()) notes = new gnu.trove.map.hash.TIntObjectHashMap<>();
        if (game.requiresBet()) amount = new int[game.players().count() + 1];
    }

    public AcedrexDeLosCuatrosTiemposState(final AcedrexDeLosCuatrosTiemposState other) {
        super(other);
        if (other.notes != null) notes = new gnu.trove.map.hash.TIntObjectHashMap<>(other.notes);
        if (other.amount != null) amount = java.util.Arrays.copyOf(other.amount, other.amount.length);
        sitesToRemove = (other.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(other.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public AcedrexDeLosCuatrosTiemposState copy() { return new AcedrexDeLosCuatrosTiemposState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final AcedrexDeLosCuatrosTiemposState o = (AcedrexDeLosCuatrosTiemposState) other;
        if (o.notes != null) notes = new gnu.trove.map.hash.TIntObjectHashMap<>(o.notes);
        if (o.amount != null) amount = java.util.Arrays.copyOf(o.amount, o.amount.length);
        sitesToRemove = (o.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(o.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        if (game.usesNote()) notes = new gnu.trove.map.hash.TIntObjectHashMap<>();
        if (amount != null) for (int i = 0; i < amount.length; i++) amount[i] = 0;
        sitesToRemove.clear();
    }

    @Override public void addNote(final int move, final int player, final String message) {
        if (notes == null) return;
        if (notes.get(move) == null) notes.put(move, new gnu.trove.map.hash.TIntObjectHashMap<>());
        notes.get(move).put(player, message);
    }
    @Override public String getNote(final int move, final int player) {
        if (notes == null) return null;
        final gnu.trove.map.TIntObjectMap<String> nfm = notes.get(move);
        return (nfm == null) ? null : nfm.get(player);
    }
    @Override public gnu.trove.map.TIntObjectMap<gnu.trove.map.TIntObjectMap<String>> getNotes() { return notes; }

    @Override public int amount(final int player) { return (amount != null) ? amount[player] : 0; }
    @Override public void setAmount(final int player, final int newAmount) {
        if (amount != null && player > 0 && player < amount.length) amount[player] = newAmount;
    }
    @Override protected void updateAmountHash(final int player) {
        if (lowAmountHashes != null) {
            if (amount[player] <= AMOUNT_MAX_HASH)
                amountHash ^= lowAmountHashes[player][amount[player]];
            else
                amountHash ^= highAmountHashes[player][amount[player] % AMOUNT_MAX_HASH];
        }
    }

    @Override public void reInitCapturedPiece() { sitesToRemove.clear(); }
    @Override public void addSitesToRemove(final int site) { sitesToRemove.add(site); }
    @Override public void removeSitesToRemove(final int site) { sitesToRemove.remove(site); }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
    @Override public game.util.equipment.Region regionToRemove() {
        return new game.util.equipment.Region(sitesToRemove.toArray());
    }

}
