package solid;

public class OrderProcessor {
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    public void processOrder(){
        order.calculateTotal();
        order.processPayment();
        order.shipOrder();
    }

}
