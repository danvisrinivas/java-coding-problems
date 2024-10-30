package design_patterns.behavioural.strategy;

public class NotificationAPI {
    private final NotificationStrategy strategy;

    public NotificationAPI(NotificationStrategy strategy){
        this.strategy = strategy;
    }

    public void initiateNotification(){
        this.strategy.sendNotification("","");
    }
}
