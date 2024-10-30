package design_patterns.structural.decorator;

public class RestaurantChargesDecorator extends Order {
    private final Order order;
    private final double restaurantCharges;

    public RestaurantChargesDecorator(Order order, double restaurantCharges) {
        this.order = order;
        this.restaurantCharges = restaurantCharges;
    }

    @Override
    public double calculateCost() {
        return order.calculateCost() + restaurantCharges;
    }
}
