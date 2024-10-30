package design_patterns.creational.factory;

public class FactoryPatternClient {
    public static void main(String[] args) {
        // Factory Pattern: Use CreditCardPayment with PaymentGatewayFactory
        PaymentGateway creditCardGateway = PaymentGatewayFactory
                .createPaymentGateway("creditcard");
        creditCardGateway.processPayment(100.00);

        // Factory Pattern: Use PayPalPayment with PaymentGatewayFactory
        PaymentGateway paypalGateway = PaymentGatewayFactory
                .createPaymentGateway("paypal");
        paypalGateway.processPayment(50.00);
    }
}
