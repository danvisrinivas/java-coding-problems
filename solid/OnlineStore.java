package solid;

public class OnlineStore extends Order {

    private String paymentGateway;

    public OnlineStore(Integer userId, Integer orderID, String paymentGateway) {
        super(userId, orderID);
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void processPayment() {
        System.out.println("Payment has been processed " +
                "using paymentGateway : "+ paymentGateway +
                " with total cost as "+ calculateTotal() );
    }

    @Override
    public double calculateTotal() {
        return 100.0;
    }
}
