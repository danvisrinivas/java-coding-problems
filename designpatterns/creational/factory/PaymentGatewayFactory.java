package designpatterns.creational.factory;

class PaymentGatewayFactory {
    public static PaymentGateway createPaymentGateway(String gatewayType) {
        return switch (gatewayType.toLowerCase()) {
            case "creditcard" -> new CreditCardPayment();
            case "paypal" -> new PayPalPayment();
            default -> throw new IllegalArgumentException("Invalid payment gateway type: "
                    + gatewayType);
        };
    }
}