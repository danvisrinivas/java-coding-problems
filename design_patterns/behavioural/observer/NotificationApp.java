package design_patterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationApp implements Activity {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers(String message) {
        for(Observer observer : observers){
            observer.notify(message);
        }
    }

    public void pushNotification(String message){
        System.out.println("New Notification : "+ message);
        notifySubscribers(message);
    }
}
