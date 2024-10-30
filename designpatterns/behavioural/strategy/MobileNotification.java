package designpatterns.behavioural.strategy;

public class MobileNotification implements NotificationStrategy{
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("SMS Notification sent");
    }
}
