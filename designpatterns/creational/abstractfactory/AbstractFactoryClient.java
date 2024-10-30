package designpatterns.creational.abstractfactory;

public class AbstractFactoryClient {
    public static void main(String[] args) {
        // Abstract Factory Pattern: Use CreditCardPaymentFactory to create CreditCardPayment
        PaymentGatewayAbstractFactory creditCardFactory = new CreditCardPaymentFactory();
        PaymentGateway creditCardGateway = creditCardFactory.createPaymentGateway();
        creditCardGateway.processPayment(450.00);

        // Abstract Factory Pattern: Use PayPalPaymentFactory to create PayPalPayment
        PaymentGatewayAbstractFactory paypalFactory = new PayPalPaymentFactory();
        PaymentGateway paypalGateway = paypalFactory.createPaymentGateway();
        paypalGateway.processPayment(100.00);
    }
}
