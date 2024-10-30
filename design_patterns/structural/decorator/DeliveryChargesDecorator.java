package design_patterns.structural.decorator;

public class DeliveryChargesDecorator  extends Order {
    private final Order order;
    private final double deliveryCharges;

    public DeliveryChargesDecorator(Order order, double deliveryCharges) {
        this.order = order;
        this.deliveryCharges = deliveryCharges;
    }

    @Override
    public double calculateCost() {
        return order.calculateCost() + deliveryCharges;
    }
}
