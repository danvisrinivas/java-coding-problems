package design_patterns.behavioural.strategy;

public class EmailNotification implements NotificationStrategy{
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Email Notification sent");
    }
}
