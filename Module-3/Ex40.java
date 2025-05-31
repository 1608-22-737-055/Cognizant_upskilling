// Virtual Threads Example (Java 21)
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Ex40 {
    public static void main(String[] args) {
        int threadCount = 100_000;
        
        // Measure time with traditional threads
        Instant start = Instant.now();
        try {
            runWithPlatformThreads(threadCount);
        } catch (InterruptedException e) {
            System.out.println("Platform threads interrupted: " + e.getMessage());
        }
        Duration platformDuration = Duration.between(start, Instant.now());
        
        // Measure time with virtual threads
        start = Instant.now();
        try {
            runWithVirtualThreads(threadCount);
        } catch (InterruptedException e) {
            System.out.println("Virtual threads interrupted: " + e.getMessage());
        }
        Duration virtualDuration = Duration.between(start, Instant.now());
        
        // Print results
        System.out.println("\nPerformance Comparison:");
        System.out.println("Thread count: " + threadCount);
        System.out.println("Platform threads took: " + platformDuration.toMillis() + "ms");
        System.out.println("Virtual threads took: " + virtualDuration.toMillis() + "ms");
    }
    
    private static void runWithPlatformThreads(int count) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(count);
        
        IntStream.range(0, count).forEach(i -> {
            Thread thread = new Thread(() -> {
                try {
                    // Simulate some work
                    Thread.sleep(100);
                    latch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            thread.start();
        });
        
        latch.await();
    }
    
    private static void runWithVirtualThreads(int count) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(count);
        
        IntStream.range(0, count).forEach(i -> {
            Thread.startVirtualThread(() -> {
                try {
                    // Simulate some work
                    Thread.sleep(100);
                    latch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        });
        
        latch.await();
    }
}
