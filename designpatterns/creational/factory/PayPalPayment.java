package designpatterns.creational.factory;

class PayPalPayment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // Actual logic to process PayPal payment
    }
}
