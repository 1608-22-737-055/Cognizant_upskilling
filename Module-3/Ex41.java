// Executor Service and Callable Example
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.Random;

class NumberCruncher implements Callable<Integer> {
    private final int id;
    private final int computationTime;
    
    public NumberCruncher(int id, int computationTime) {
        this.id = id;
        this.computationTime = computationTime;
    }
    
    @Override
    public Integer call() throws Exception {
        System.out.printf("Task %d: Starting computation for %d ms%n", id, computationTime);
        Thread.sleep(computationTime); // Simulate work
        int result = new Random().nextInt(100) + 1;
        System.out.printf("Task %d: Completed with result: %d%n", id, result);
        return result;
    }
}

public class Ex41 {
    public static void main(String[] args) {
        // Create a fixed thread pool
        int numberOfTasks = 5;
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();
        
        try {
            // Submit tasks
            System.out.println("Submitting tasks...");
            for (int i = 1; i <= numberOfTasks; i++) {
                // Each task will take random time between 1-5 seconds
                int computationTime = new Random().nextInt(4000) + 1000;
                Callable<Integer> task = new NumberCruncher(i, computationTime);
                Future<Integer> future = executor.submit(task);
                futures.add(future);
            }
            
            // Collect results
            System.out.println("\nCollecting results...");
            int sum = 0;
            for (int i = 0; i < futures.size(); i++) {
                try {
                    int result = futures.get(i).get(6, TimeUnit.SECONDS);
                    System.out.printf("Result from task %d: %d%n", i + 1, result);
                    sum += result;
                } catch (TimeoutException e) {
                    System.out.printf("Task %d timed out!%n", i + 1);
                    futures.get(i).cancel(true);
                } catch (Exception e) {
                    System.out.printf("Task %d failed: %s%n", i + 1, e.getMessage());
                }
            }
            
            System.out.println("\nAll tasks completed!");
            System.out.println("Sum of all results: " + sum);
            System.out.println("Average result: " + (double) sum / numberOfTasks);
            
        } finally {
            // Shutdown the executor
            System.out.println("\nShutting down executor...");
            executor.shutdown();
            try {
                if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
        }
    }
}