// Thread Creation Example

// Thread class implementation
class MessageThread extends Thread {
    private String message;
    private int count;
    
    public MessageThread(String message, int count) {
        this.message = message;
        this.count = count;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + message + " " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                return;
            }
        }
    }
}

// Runnable implementation
class MessageRunnable implements Runnable {
    private String message;
    private int count;
    
    public MessageRunnable(String message, int count) {
        this.message = message;
        this.count = count;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + message + " " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                return;
            }
        }
    }
}

public class Ex26 {
    public static void main(String[] args) {
        // Create threads using Thread class
        MessageThread thread1 = new MessageThread("Hello from Thread", 5);
        thread1.setName("Thread-1");
        
        // Create thread using Runnable interface
        MessageRunnable runnable = new MessageRunnable("Hello from Runnable", 5);
        Thread thread2 = new Thread(runnable, "Thread-2");
        
        // Start both threads
        System.out.println("Starting threads...");
        thread1.start();
        thread2.start();
        
        // Wait for both threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        
        System.out.println("All threads completed!");
    }
}
