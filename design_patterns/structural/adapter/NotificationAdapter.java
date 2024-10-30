package design_patterns.structural.adapter;

public class NotificationAdapter implements NewGenNotificationSystem {

    private final OldGenNotificationSystem oldGenNotificationSystem;

    public NotificationAdapter(OldGenNotificationSystem oldGenNotificationSystem) {
        this.oldGenNotificationSystem = oldGenNotificationSystem;
    }

    @Override
    public void sendNotification(String message) {
        NewGenNotificationSystem newGenNotificationSystem = new NewGenNotificationSystemImpl();
        try {
            newGenNotificationSystem.sendNotification("");
        }catch(Exception e){
            System.out.println("NewGen Notification service is down, using old gen notification system to send notification");
            this.oldGenNotificationSystem.notify("");
        }
    }
}
