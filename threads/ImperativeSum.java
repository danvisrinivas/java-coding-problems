package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class ImperativeSum {
    private AtomicInteger sum = new AtomicInteger(0);

    public void calculateSum() {
        for (int i = 0; i < 10; i++) {
            sum.addAndGet(i); // Using AtomicInteger's atomic operation
            try {
                Thread.sleep(10); // Introduce some delay to encourage race conditions
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getSum() {
        return sum.get(); // Get the value atomically
    }

    public static void main(String[] args) {
        ImperativeSum obj = new ImperativeSum();

        Thread t1 = new Thread(() -> {
            obj.calculateSum();
        });

        Thread t2 = new Thread(() -> {
            obj.calculateSum();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sum: " + obj.getSum());
    }
}
