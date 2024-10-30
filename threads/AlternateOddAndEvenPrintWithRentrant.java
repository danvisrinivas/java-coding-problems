package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AlternateOddAndEvenPrintWithRentrant {

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

        Thread oddThread = new Thread(oddNumberTask);
        Thread evenThread = new Thread(evenNumberTask);

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}