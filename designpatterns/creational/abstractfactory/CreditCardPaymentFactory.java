package designpatterns.creational.abstractfactory;

class CreditCardPaymentFactory implements PaymentGatewayAbstractFactory {
    @Override
    public PaymentGateway createPaymentGateway() {
        return new CreditCardPayment();
    }
}
