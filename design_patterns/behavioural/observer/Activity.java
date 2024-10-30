package design_patterns.behavioural.observer;

public interface Activity {
    void subscribe(Observer observer);
    void unSubscribe(Observer observer);
    void notifySubscribers(String message);
}