package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AlternateOddAndEvenPrintWithExecutorService {

    private static boolean printOdd = true;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {

        Runnable oddNumberTask = new Runnable() {
            @Override
            public void run() {
                for (int num = 1; num <= 20; num += 2) {
                    lock.lock();
                    try {
                        while (!printOdd) {
                            condition.await();
                        }
                        System.out.print(" " + num);
                        printOdd = false;
                        condition.signal();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        Runnable evenNumberTask = new Runnable() {
            @Override
            public void run() {
                for (int num = 2; num <= 20; num += 2) {
                    lock.lock();
                    try {
                        while (printOdd) {
                            condition.await();
                        }
                        System.out.print(" " + num);
                        printOdd = true;
                        condition.signal();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        // Create an ExecutorService with a fixed thread pool of 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit the tasks to the ExecutorService
        executor.submit(oddNumberTask);
        executor.submit(evenNumberTask);

        // Shut down the ExecutorService after the tasks are completed
        executor.shutdown();
    }
}
