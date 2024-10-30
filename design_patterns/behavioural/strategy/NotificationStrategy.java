package design_patterns.behavioural.strategy;

public interface NotificationStrategy {
    public void sendNotification(String message, String recipient);
}