package threads;

public class AlternateOddAndEvenPrint {
    private static boolean printOdd = true;

    private static final Object lock = new Object();

    public static void main(String[] args) {

        Runnable oddNumberTask = new Runnable() {
            @Override
            public void run() {
                for (int num = 1; num <= 20; num += 2) {
                    synchronized (lock) {
                        if (!printOdd) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.print(" " + num);
                        printOdd = false;
                        lock.notify();
                    }
                }
            }
        };

        Runnable evenNumberTask = new Runnable() {
            @Override
            public void run() {
                for (int num = 2; num <= 20; num += 2) {
                    synchronized (lock) {
                        if (printOdd) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.print(" " + num);
                        printOdd = true;
                        lock.notify();
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

