package design_patterns.structural.decorator;

public class DeliveryClient {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new Product("Burger", 5.0));
        order.addItem(new Product("Pizza", 5.0));

        Order gstOrder = new GSTDecorator(order);

        double totalCost = gstOrder.calculateCost();

        System.out.println("Total Cost of the order: "+  totalCost);
    }
}
