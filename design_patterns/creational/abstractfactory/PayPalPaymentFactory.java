package design_patterns.creational.abstractfactory;

class PayPalPaymentFactory implements PaymentGatewayAbstractFactory {
    @Override
    public PaymentGateway createPaymentGateway() {
        return new PayPalPayment();
    }
}
