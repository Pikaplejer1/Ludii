package other.state.e;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Enindji. */
public class EnindjiState extends State {

    private static final long serialVersionUID = 1L;

    private gnu.trove.list.array.TIntArrayList propositions = new gnu.trove.list.array.TIntArrayList();
    private gnu.trove.list.array.TIntArrayList votes = new gnu.trove.list.array.TIntArrayList();

    public EnindjiState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public EnindjiState(final EnindjiState other) {
        super(other);
        propositions = (other.propositions != null) ? new gnu.trove.list.array.TIntArrayList(other.propositions) : new gnu.trove.list.array.TIntArrayList();
        votes = (other.votes != null) ? new gnu.trove.list.array.TIntArrayList(other.votes) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public EnindjiState copy() { return new EnindjiState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final EnindjiState o = (EnindjiState) other;
        propositions = (o.propositions != null) ? new gnu.trove.list.array.TIntArrayList(o.propositions) : new gnu.trove.list.array.TIntArrayList();
        votes = (o.votes != null) ? new gnu.trove.list.array.TIntArrayList(o.votes) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        propositions.clear();
        votes.clear();
    }

    @Override public gnu.trove.list.array.TIntArrayList propositions() { return propositions; }
    @Override public void clearPropositions() { propositions.clear(); }

    @Override public gnu.trove.list.array.TIntArrayList votes() { return votes; }
    @Override public void clearVotes() { votes.clear(); }

}
