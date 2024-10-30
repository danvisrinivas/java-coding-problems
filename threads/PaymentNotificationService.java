package threads;

public class PaymentNotificationService implements Runnable {

    @Override
    public void run() {
        sendNotification();
    }

    public void sendNotification() {
        System.out.println("Payment status notification sending is in progress");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Payment status notification sending is complete");
    }
}
