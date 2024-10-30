package design_patterns.creational.abstractfactory;

class CreditCardPaymentFactory implements PaymentGatewayAbstractFactory {
    @Override
    public PaymentGateway createPaymentGateway() {
        return new CreditCardPayment();
    }
}
