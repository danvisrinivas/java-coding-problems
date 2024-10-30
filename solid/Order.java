package solid;

public abstract class Order {
    private Integer orderID;
    private Integer userId;

    public Order(Integer userId, Integer orderID) {
        this.userId = userId;
        this.orderID = orderID;
    }

    public abstract double calculateTotal();
    public abstract void processPayment();

    public void shipOrder(){
        System.out.println("Shipping has been processed and completed");
    }
}
