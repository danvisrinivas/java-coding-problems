package threads;

public class AlternateLetterAndNumberPrint {
    private static boolean printLetter = true;

    private static final Object lock = new Object();

    public static void main(String[] args) {

        Runnable letterTask = new Runnable() {
            @Override
            public void run() {
                for(char ch='A';ch<='Z';ch++){
                    synchronized (lock){
                        if(!printLetter){
                            try {
                                System.out.print(" Ch locked");
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.print(" Printing ch");
                        System.out.print(" "+ch);
                        printLetter = false;
                        lock.notify();
                        System.out.print(" ch notify");
                    }
                }
            }
        };

        Runnable numberTask = new Runnable() {
            @Override
            public void run() {
                for(int num=1;num<=26;num++){
                    synchronized (lock){
                        if(printLetter){
                            try {
                                System.out.print(" num locked");
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.print(" Printing num");
                        System.out.print(" "+num);
                        printLetter = true;
                        lock.notify();
                        System.out.print(" num notify");
                    }
                }
            }
        };

        Thread letterThread = new Thread(letterTask);
        Thread numberThread = new Thread(numberTask);

        letterThread.start();
        numberThread.start();

        try{
            letterThread.join();
            numberThread.join();
        }catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }

    }
}
