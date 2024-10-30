package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void process1() {
        lock1.lock();
        System.out.println("Process 1 acquired lock1");

        try {
            // Simulating some work
            Thread.sleep(50);
            lock2.lock();  // Trying to acquire lock2
            System.out.println("Process 1 acquired lock2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
            lock1.unlock();
        }
    }

    public void process2() {
        lock2.lock();
        System.out.println("Process 2 acquired lock2");

        try {
            // Simulating some work
            Thread.sleep(50);
            lock1.lock();  // Trying to acquire lock1
            System.out.println("Process 2 acquired lock1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
            lock2.unlock();
        }
    }

    public static void main(String[] args) {
        DeadlockExample deadlockExample = new DeadlockExample();

        Thread t1 = new Thread(deadlockExample::process1);
        Thread t2 = new Thread(deadlockExample::process2);

        t1.start();
        t2.start();
    }
}

