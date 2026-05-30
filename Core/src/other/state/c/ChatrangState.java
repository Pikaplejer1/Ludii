package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for Chatrang. */
public class ChatrangState extends State {

    private static final long serialVersionUID = 1L;

    private int[] teams = null;
    private gnu.trove.list.array.TIntArrayList sitesToRemove = new gnu.trove.list.array.TIntArrayList();

    public ChatrangState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
        if (game.requiresTeams()) teams = new int[game.players().size()];
    }

    public ChatrangState(final ChatrangState other) {
        super(other);
        if (other.teams != null) teams = java.util.Arrays.copyOf(other.teams, other.teams.length);
        sitesToRemove = (other.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(other.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public ChatrangState copy() { return new ChatrangState(this); }

    @Override public void resetStateTo(final State other, final Game game) {
        super.resetStateTo(other, game);
        final ChatrangState o = (ChatrangState) other;
        if (o.teams != null) teams = java.util.Arrays.copyOf(o.teams, o.teams.length);
        sitesToRemove = (o.sitesToRemove != null) ? new gnu.trove.list.array.TIntArrayList(o.sitesToRemove) : new gnu.trove.list.array.TIntArrayList();
    }

    @Override public void initialise(final Game game) {
        super.initialise(game);
        if (teams != null) for (int i = 1; i < teams.length; i++) teams[i] = i;
        sitesToRemove.clear();
    }

    @Override public boolean playerInTeam(final int pid, final int tid) { return (teams != null && pid < teams.length) && teams[pid] == tid; }
    @Override public void setPlayerToTeam(final int pid, final int tid) {
        if (teamHashes != null) updateStateHash(teamHashes[pid][teams[pid]]);
        teams[pid] = tid;
        if (teamHashes != null) updateStateHash(teamHashes[pid][teams[pid]]);
    }
    @Override public int getTeam(final int pid) { return (teams == null || pid >= teams.length) ? main.Constants.UNDEFINED : teams[pid]; }

    @Override public void reInitCapturedPiece() { sitesToRemove.clear(); }
    @Override public void addSitesToRemove(final int site) { sitesToRemove.add(site); }
    @Override public void removeSitesToRemove(final int site) { sitesToRemove.remove(site); }
    @Override public gnu.trove.list.array.TIntArrayList sitesToRemove() { return sitesToRemove; }
    @Override public game.util.equipment.Region regionToRemove() {
        return new game.util.equipment.Region(sitesToRemove.toArray());
    }

}
