package other.state.b;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for ButtonsAndLights. */
public class ButtonsAndLightsState extends State {

    private static final long serialVersionUID = 1L;

    public ButtonsAndLightsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public ButtonsAndLightsState(final ButtonsAndLightsState other) {
        super(other);
    }

    @Override public ButtonsAndLightsState copy() { return new ButtonsAndLightsState(this); }

}
