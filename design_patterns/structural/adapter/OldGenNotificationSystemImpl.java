package design_patterns.structural.adapter;

public class OldGenNotificationSystemImpl implements OldGenNotificationSystem{

    @Override
    public void notify(String message) {
        System.out.println("Notification sent successfully using Old Gen System");
    }
}
