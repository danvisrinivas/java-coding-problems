package designpatterns.creational.abstractfactory;

class PayPalPaymentFactory implements PaymentGatewayAbstractFactory {
    @Override
    public PaymentGateway createPaymentGateway() {
        return new PayPalPayment();
    }
}
