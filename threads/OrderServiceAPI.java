package threads;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrderServiceAPI {
    public static void main(String[] args) {

//        Instant startTime = Instant.now();
//
//        PaymentNotificationService paymentNotificationService = new PaymentNotificationService();
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl();
//        OrderNotificationService orderNotificationService = new OrderNotificationService();
//        OrderStatusNotificationService orderStatusNotificationService = new OrderStatusNotificationService();
//        ShippingServiceNotification shippingNotificationService = new ShippingServiceNotification();
//
//        paymentNotificationService.sendNotification();
//        inventoryService.updateInventory();
//        orderNotificationService.sendNotification();
//        orderStatusNotificationService.sendNotification();
//        shippingNotificationService.sendNotification();
//
//        System.out.println(Duration.between(startTime, Instant.now()).toMillis());


        //Using Multithreading approach

        Instant startTime = Instant.now();

        PaymentNotificationService paymentNotificationService = new PaymentNotificationService();
        InventoryServiceImpl inventoryService = new InventoryServiceImpl();
        OrderNotificationService orderNotificationService = new OrderNotificationService();
        OrderStatusNotificationService orderStatusNotificationService = new OrderStatusNotificationService();
        ShippingServiceNotification shippingNotificationService = new ShippingServiceNotification();

        Thread paymentNotificationServiceThread = new Thread(paymentNotificationService);
        Thread inventoryServiceThread = new Thread(inventoryService);
        Thread orderNotificationServiceThread = new Thread(orderNotificationService);
        Thread orderStatusNotificationServiceThread = new Thread(orderStatusNotificationService);
        Thread shippingNotificationServiceThread = new Thread(shippingNotificationService);

        paymentNotificationServiceThread.start();
        inventoryServiceThread.start();
        orderNotificationServiceThread.start();
        orderStatusNotificationServiceThread.start();
        shippingNotificationServiceThread.start();
        try {
            paymentNotificationServiceThread.join();
            inventoryServiceThread.join();
            orderNotificationServiceThread.join();
            orderStatusNotificationServiceThread.join();
            shippingNotificationServiceThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Duration.between(startTime, Instant.now()).toSeconds()+" Minutes");

//        Instant startTime = Instant.now();
//
//        PaymentNotificationService paymentNotificationService = new PaymentNotificationService();
//        InventoryServiceImpl inventoryService = new InventoryServiceImpl();
//        OrderNotificationService orderNotificationService = new OrderNotificationService();
//        OrderStatusNotificationService orderStatusNotificationService = new OrderStatusNotificationService();
//        ShippingServiceNotification shippingNotificationService = new ShippingServiceNotification();
//
//        ExecutorService service = Executors.newFixedThreadPool(5);
//        service.submit(paymentNotificationService);
//        service.submit(inventoryService);
//        service.submit(orderNotificationService);
//        service.submit(orderStatusNotificationService);
//        service.submit(shippingNotificationService);
//
//        service.shutdown();
//
//        try{
//            service.awaitTermination(15, TimeUnit.SECONDS);
//        }catch(InterruptedException e){
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println(Duration.between(startTime, Instant.now()).toSeconds()+" Seconds");
    }
}
