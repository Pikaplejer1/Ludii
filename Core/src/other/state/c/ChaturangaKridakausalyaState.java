package other.state.c;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ChaturangaKridakausalya. */
public class ChaturangaKridakausalyaState extends State {

    private static final long serialVersionUID = 1L;

    public ChaturangaKridakausalyaState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ChaturangaKridakausalyaState(final ChaturangaKridakausalyaState other) {
        super(other);
    }

    @Override public ChaturangaKridakausalyaState copy() { return new ChaturangaKridakausalyaState(this); }

}
