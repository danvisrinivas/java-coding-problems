package solid;

import java.util.Random;

public class OrderProcessingApi {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        Order onlineStoreOrder = new OnlineStore(9801,
                new Random().nextInt(),"Stripe");
        orderProcessor.setOrder(onlineStoreOrder);
        orderProcessor.processOrder();
        Order inlineStore = new InStore(1201,
                new Random().nextInt(), "Cash");
        orderProcessor.setOrder(inlineStore);
        orderProcessor.processOrder();
    }
}
