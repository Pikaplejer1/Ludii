package other.state;

import game.Game;
import game.Game.StateConstructorLock;

@SuppressWarnings("serial")
public class FullState extends State{

	public FullState(Game game, StateConstructorLock stateConstructorLock) {
		super(game, stateConstructorLock);
//		System.out.println("this uses a fullstate implementation");
		// TODO Auto-generated constructor stub
	}

	public FullState(State stateReference) {
		super(stateReference);
	}

	@Override
	public State copy() {
		// TODO Auto-generated method stub
		return null;
	}

}
