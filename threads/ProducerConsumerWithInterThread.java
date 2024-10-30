package threads;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerWithInterThread {

    private static final int CAPACITY = 1;
    private static final Queue<Integer> buffer = new LinkedList<>();
    private static final int PRODUCE_LIMIT = 2;
    private static final int CONSUME_LIMIT = 2;

    public static void main(String[] args) {

        Runnable producerTask = new Runnable() {
            @Override
            public void run() {
                int value = 0;
                while(value < PRODUCE_LIMIT){
                    synchronized (buffer){
                        while(buffer.size() == CAPACITY){
                            try{
                                buffer.wait();
                            }catch (InterruptedException ex){
                                System.out.println(ex.getMessage());
                            }
                        }
                        buffer.add(++value);
                        System.out.println("Produced : "+ value);
                        buffer.notify();
                    }
                }
            }
        };

        Runnable consumerTask = new Runnable() {
            @Override
            public void run() {
                int consumedValue = 0;
                while(consumedValue < CONSUME_LIMIT){
                    synchronized (buffer){
                        while(buffer.isEmpty()){
                            try{
                                buffer.wait();
                            }catch(InterruptedException ex){
                                System.out.println(ex.getMessage());
                            }
                        }
                        consumedValue = buffer.poll();
                        System.out.println("Consumed : "+ consumedValue);
                        buffer.notify();
                    }
                }
            }
        };

         ExecutorService service = Executors.newFixedThreadPool(2);

         service.submit(producerTask);
         service.submit(consumerTask);

         service.shutdown();
    }
}

