package threads;

public class OrderStatusNotificationService implements Runnable {

    public void sendNotification() {
        System.out.println("Order status related notifications sending is in progress to your mobile-app");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Order status related notifications sent to mobile-app is complete");
    }

    @Override
    public void run() {
        sendNotification();
    }
}
