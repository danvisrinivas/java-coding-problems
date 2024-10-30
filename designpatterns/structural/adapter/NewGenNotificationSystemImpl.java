package designpatterns.structural.adapter;

public class NewGenNotificationSystemImpl implements NewGenNotificationSystem{
    @Override
    public void sendNotification(String message) {
        System.out.println("Notification sent successfully using New Gen System");
    }
}
