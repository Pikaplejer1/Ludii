package app;

import game.Game;
import other.GameLoader;


public class BenchmarkMain
{
	public static void main(String[] args) {
//		measureMemoryForGame(GameType.GO);
	}
	
	
	
	
	private static void measureMemoryForGame(GameType type ) {
		try {
			System.gc();
			Thread.sleep(100);
			
			long innitialMemoery = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			
			Game game = GameLoader.loadGameFromName(type.toString(), ".lud");
		}
		catch(Exception e){
//			break;
		}
	}
	
}
