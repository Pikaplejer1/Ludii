package other.state.t;

import game.Game;
import game.Game.StateConstructorLock;
import other.state.State;

/** Auto-generated State subclass for TrafficLights. */
public class TrafficLightsState extends State {

    private static final long serialVersionUID = 1L;

    public TrafficLightsState(final Game game, final StateConstructorLock lock) {
        super(game, lock);
    }

    public TrafficLightsState(final TrafficLightsState other) {
        super(other);
    }

    @Override public TrafficLightsState copy() { return new TrafficLightsState(this); }

}
