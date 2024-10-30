package solid;

public class InStore extends Order {
    private String paymentMode;

    public InStore(Integer userId, Integer orderID, String paymentMode) {
        super(userId, orderID);
        this.paymentMode = paymentMode;
    }

    @Override
    public double calculateTotal() {
        return 80.0;
    }

    @Override
    public void processPayment() {
        System.out.println("Payment processed by mode : "+ paymentMode +
                " with total cost as "+ calculateTotal());
    }
}
