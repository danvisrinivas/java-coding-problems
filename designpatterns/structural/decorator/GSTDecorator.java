package designpatterns.structural.decorator;

public class GSTDecorator extends Order {
    private final Order order;

    public GSTDecorator(Order order) {
        this.order = order;
    }

    @Override
    public double calculateCost() {
        double totalCost = order.calculateCost();
        // Apply 15% GST
        return totalCost + (totalCost * 0.15);
    }
}
