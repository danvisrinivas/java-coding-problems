package threads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FunctionalSum {

    private static int sum = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            int partialSum = IntStream.range(0, 10).sum();
            synchronized (lock) {
                sum += partialSum;
            }
        });

        Thread t2 = new Thread(() -> {
            int partialSum = IntStream.range(0, 10).sum();
            synchronized (lock) {
                sum += partialSum;
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sum: " + sum);
    }
}
