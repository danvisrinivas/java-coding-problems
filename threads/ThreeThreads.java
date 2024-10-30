package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.atomic.AtomicInteger;

class ThreeThreads implements Runnable {
    private static final int LIMIT = 10;
    private static final AtomicInteger currentNumber = new AtomicInteger(1);
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private final int threadId;
    private final int threadCount;

    public ThreeThreads(int threadId, int threadCount) {
        this.threadId = threadId;
        this.threadCount = threadCount;
    }
    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                while (currentNumber.get() % threadCount != threadId) {
                    if (currentNumber.get() > LIMIT) {
                        condition.signalAll();
                        return;
                    }
                    condition.await();
                }

                if (currentNumber.get() > LIMIT) {
                    condition.signalAll();
                    return;
                }
                System.out.println("T" + (threadId == 0 ? threadId+3 : threadId) + " " + currentNumber.getAndIncrement());
                condition.signalAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        int threadCount = 3;

        Thread t1 = new Thread(new ThreeThreads(0, threadCount));
        Thread t2 = new Thread(new ThreeThreads(1, threadCount));
        Thread t3 = new Thread(new ThreeThreads(2, threadCount));

        t1.start();
        t2.start();
        t3.start();
    }
}

