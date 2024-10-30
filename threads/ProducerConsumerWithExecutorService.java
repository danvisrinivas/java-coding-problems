package threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithExecutorService {
    private static final int CAPACITY = 1;
    private static final Queue<Integer> buffer = new LinkedList<>();
    private static final int PRODUCE_LIMIT = 2;
    private static final int CONSUME_LIMIT = 2;

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition notFull = lock.newCondition();
    private static final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        Runnable producerTask = new Runnable() {
            @Override
            public void run() {
                int value = 0;
                while(value < PRODUCE_LIMIT){
                    lock.lock();
                    try{
                        while(buffer.size() == CAPACITY){
                            notFull.await();
                        }
                        buffer.add(++value);
                        System.out.println("Produced:"+ value);
                        notEmpty.signal();
                    }catch(InterruptedException ex){
                        System.out.println(ex.getMessage());
                    }finally {
                        lock.unlock();
                    }
                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                int consumedValue = 0;
                while(consumedValue < CONSUME_LIMIT){
                    lock.lock();
                    try{
                        while(buffer.isEmpty()){
                            notEmpty.await();
                        }
                        consumedValue = buffer.poll();
                        System.out.println("Consumed : "+ consumedValue);
                        notFull.signal();
                    }catch(InterruptedException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(producerTask);
        service.submit(consumer);

        service.shutdown();

    }
}
