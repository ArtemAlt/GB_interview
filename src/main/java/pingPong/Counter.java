package pingPong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {
    private int count;
    private ReentrantLock lock;

    public Counter( ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            count++;
            System.out.println("Current count - "+count+" counted by thread id- "+ Thread.currentThread().getId());
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
       Counter counter = new Counter(new ReentrantLock());
        for(int i = 0; i <100; i++) {
            executor.execute(counter);
        }
        executor.shutdown();

    }
}
