package threads;

public class OrderNotificationService implements Runnable {

    @Override
    public void run() {
        sendNotification();
    }

    public void sendNotification() {
        System.out.println("Order notification sending is in progress along with products ordered by user is in progress");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Order notification sending is in progress along with products ordered by user is complete");
    }
}
