package designpatterns.creational.abstractfactory;

class CreditCardPayment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
