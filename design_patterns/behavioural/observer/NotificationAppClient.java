package design_patterns.behavioural.observer;

public class NotificationAppClient {
    public static void main(String[] args) {
        NotificationApp notificationApp = new NotificationApp();

        User user1 = new User("Mike");
        User user2 = new User("Romak");
        User user3 = new User("Shiv");

        notificationApp.subscribe(user1);
        notificationApp.subscribe(user2);
        notificationApp.subscribe(user3);

        notificationApp.pushNotification("Hey, new video content for Java 8 is added. Please checkout ");

        notificationApp.unSubscribe(user1);

        notificationApp.pushNotification("New Video on Solid Design Priciples added.");
    }
}
