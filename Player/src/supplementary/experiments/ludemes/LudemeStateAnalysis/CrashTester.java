package supplementary.experiments.ludemes.LudemeStateAnalysis;

import game.Game;
import other.GameLoader;
import other.context.Context;
import other.trial.Trial;

public class CrashTester {

    public static void main(String[] args) {
        System.out.println("Initiating Trial with the mutant State.java...");
        
        try {
            Game game = GameLoader.loadGameFromName("Tic-Tac-Toe.lud");
//            Game game = GameLoader.loadGameFromName("Go.lud");
            
            Trial trial = new Trial(game);
            Context context = new Context(game, trial);
            
            game.start(context);
            System.out.println("Is the game over immediately? " + trial.over());
            System.out.println("Whose turn is it? Player " + context.state().mover());
            System.out.println("Number of legal moves: " + game.moves(context).count());
            
        } catch (Throwable e) { 
            System.err.println("smth is not right");
            e.printStackTrace();
        }
    }
}