package experiments.fastGameLengths.Thesis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import game.Game;
import other.GameLoader;
import other.context.Context;
import other.trial.Trial;

public class ExperimentForThesis {
	
	private static final int TEST_DURATION_MS = 5000;
	
	
	public static void main(String[] args) {
		System.out.println("========================================");
		System.out.println("THESIS BENCHMARK SUITE - PHASE 1");
		System.out.println("========================================");
		runMemoryBenchmark("Tic-Tac-Toe");
		runTHroughputBenchmark("Tic-Tac-Toe");
//		runMemoryBenchmark("Go");
//		runTHroughputBenchmark("Go");
	}

	
	private static void runMemoryBenchmark(String gameName) {
		System.out.println("Memory analysis of: " + gameName);
		try {
			System.gc();
			Thread.sleep(200);
			final long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			
			
			final Game game = GameLoader.loadGameFromName(gameName + ".lud");
			final Trial trail = new Trial(game);
			final Context context= new Context(game, trail);
			
			game.start(context);
			
			
			final Object state = context.state();
			
			final long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			final long estimated = after - before; 
			
			System.out.println("Game Loaded: "+ game.name());
			System.out.println("Raw delta: " + estimated + " bytes\n\n");
			
			if (state==null) System.err.println("Error: state was null");
			
			
		}catch(Exception e) {
			System.err.println("Failed to measre memory: "+ e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	
	private static void runTHroughputBenchmark(String gameName) {
		System.out.println("Throughput baseline: " + gameName);
		try {
			final Game game = GameLoader.loadGameFromName(gameName+ ".lud");
			
			final int numThreads = Runtime.getRuntime().availableProcessors();
			final ExecutorService executor = Executors.newFixedThreadPool(numThreads); 
			final AtomicLong totalMoves = new AtomicLong(0); 
			
			
			System.out.println("Num threads: " + numThreads + "\nDuration: "+  (TEST_DURATION_MS/1000) + "s");
			
			final CountDownLatch latch = new CountDownLatch(numThreads);
			
			for(int i=0;i<numThreads; i++) {
				executor.submit(()->{
					try {
						final Trial trail = new Trial(game);
						final Context context = new Context(game,trail);
						
						
						long threadMoves = 0;
						final long threadStart = System.currentTimeMillis();
						while (System.currentTimeMillis() - threadStart < TEST_DURATION_MS) {
							game.start(context);
							
							game.playout(context, null, -1, null, 0, -1, ThreadLocalRandom.current());
							threadMoves +=trail.numMoves();
							
							
						}
						
						totalMoves.addAndGet(threadMoves);
						
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						latch.countDown();
					}
				});
				
			}
			latch.await();
			executor.shutdown();
			
			final double seconds = TEST_DURATION_MS/1000;
			final long moves = totalMoves.get();
			final long pps = (long) (moves/seconds);
			System.out.println("Total moves: "+ moves);
			System.out.println("Result: " + pps+ " moves/sec");
						
		}catch (Exception e) {
			System.err.println("Failed to measre throughput: "+ e.getMessage());
			e.printStackTrace();
		}
		System.out.println("\n");
	}
	
}
