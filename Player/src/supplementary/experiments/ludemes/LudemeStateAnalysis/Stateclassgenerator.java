package supplementary.experiments.ludemes.LudemeStateAnalysis;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Stateclassgenerator {
	private static final String OUTPUT_DIR = 
			"C:\\Users\\pendy\\Desktop\\wszystko\\studia\\thesis\\ludii\\Ludii\\Ludiiiiii\\Core\\src\\other\\state";
	private static final Set<String> REMOVABLE = new LinkedHashSet<>(Arrays.asList(
			"amount", "valuesPlayer", "propositions", "votes", "notes",
	        "sitesToRemove", "rememberingValues", "mapRememberingValues", "valueMap"));
	public static void main (String[] args) {
		if (args.length == 0) {
			System.out.println("Pass in as paremeters a gme game to generate");
		}
		String gamename = args[0];
		generate(gamename);
	}
	
	public static void generate(String gamename) {
		
	}
}
