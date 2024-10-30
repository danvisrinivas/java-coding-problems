package threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockPrevention {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void process1() {
        try {
            // Try to acquire both locks within 1 second
            if (lock1.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println("Process 1 acquired lock1");

                try {
                    Thread.sleep(50); // Simulating work
                    if (lock2.tryLock(1, TimeUnit.SECONDS)) {
                        try {
                            System.out.println("Process 1 acquired lock2");
                        } finally {
                            lock2.unlock();
                        }
                    } else {
                        System.out.println("Process 1 failed to acquire lock2, releasing lock1");
                    }
                } finally {
                    lock1.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void process2() {
        try {
            // Try to acquire both locks within 1 second
            if (lock2.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println("Process 2 acquired lock2");

                try {
                    Thread.sleep(50); // Simulating work
                    if (lock1.tryLock(1, TimeUnit.SECONDS)) {
                        try {
                            System.out.println("Process 2 acquired lock1");
                        } finally {
                            lock1.unlock();
                        }
                    } else {
                        System.out.println("Process 2 failed to acquire lock1, releasing lock2");
                    }
                } finally {
                    lock2.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DeadlockPrevention deadlockPrevention = new DeadlockPrevention();

        Thread t1 = new Thread(deadlockPrevention::process1);
        Thread t2 = new Thread(deadlockPrevention::process2);

        t1.start();
        t2.start();
    }
}

