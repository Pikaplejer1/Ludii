package other.state.s;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Suffragetto. */
public class SuffragettoState extends State {

    private static final long serialVersionUID = 1L;

    private gnu.trove.list.array.TIntArrayList propositions = new gnu.trove.list.array.TIntArrayList();
    private gnu.trove.list.array.TIntArrayList votes = new gnu.trove.list.array.TIntArrayList();
    private gnu.trove.map.TIntObjectMap<gnu.trove.map.TIntObjectMap<String>> notes = null;
    private gnu.trove.map.TObjectIntMap<String> valueMap = new gnu.trove.map.hash.TObjectIntHashMap<>();
    private gnu.trove.list.array.TIntArrayList sitesToRemove = new gnu.trove.list.array.TIntArrayList();

    public SuffragettoState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.usesNote()) notes = new gnu.trove.map.hash.TIntObjectHashMap<>();
    }

    public SuffragettoState(final SuffragettoState other) {
        super(other);
        propositions = (other.propositions != null) ? new gnu.trove.list.array.TIntArrayList(other.propositions) : new gnu.trove.list.array.TIntArrayList();
        votes = (other.votes != null) ? new gnu.trove.list.array.TIntArrayList(other.votes) : new gnu.trove.list.array.TIntArrayList();
        if (other.notes != null) notes = new gnu.trove.map.hash.TIntObjectHashMap<>(other.notes);
        valueMap = (other.valueMap != null) ? new gnu.trove.map.hash.TObjectIntHashMap<>(other.valueMap) : new gnu.trove.map.hash.TObjectIntHashMap<>();
        sitesToRemove = (other.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(other.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public SuffragettoState copy() { return new SuffragettoState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final SuffragettoState o = (SuffragettoState) other;
        propositions = (o.propositions != null) ? new gnu.trove.list.array.TIntArrayList(o.propositions) : new gnu.trove.list.array.TIntArrayList();
        votes = (o.votes != null) ? new gnu.trove.list.array.TIntArrayList(o.votes) : new gnu.trove.list.array.TIntArrayList();
        if (o.notes != null) notes = new gnu.trove.map.hash.TIntObjectHashMap<>(o.notes);
        valueMap = (o.valueMap != null) ? new gnu.trove.map.hash.TObjectIntHashMap<>(o.valueMap) : new gnu.trove.map.hash.TObjectIntHashMap<>();
        sitesToRemove = (o.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(o.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        propositions.clear();
        votes.clear();
        if (game.usesNote()) notes = new gnu.trove.map.hash.TIntObjectHashMap<>();
        valueMap.clear();
        sitesToRemove.clear();
    }

    @Override public gnu.trove.list.array.TIntArrayList propositions() { return propositions; }
    @Override public void clearPropositions() { propositions.clear(); }

    @Override public gnu.trove.list.array.TIntArrayList votes() { return votes; }
    @Override public void clearVotes() { votes.clear(); }

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

    @Override public void setValue(final String key, final int value) { valueMap.put(key, value); }
    @Override public void removeKeyValue(final String key) { valueMap.remove(key); }
    @Override public int getValue(final String key) { return valueMap.containsKey(key) ? valueMap.get(key) : main.Constants.OFF; }
    @Override public gnu.trove.map.TObjectIntMap<String> getValueMap() { return valueMap; }

    @Override public void reInitCapturedPiece() { sitesToRemove.clear(); }
    @Override public void addSitesToRemove(final int site) { sitesToRemove.add(site); }
    @Override public void removeSitesToRemove(final int site) { sitesToRemove.remove(site); }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
    @Override public game.util.equipment.Region regionToRemove() {
        return new game.util.equipment.Region(sitesToRemove.toArray());
    }

}
