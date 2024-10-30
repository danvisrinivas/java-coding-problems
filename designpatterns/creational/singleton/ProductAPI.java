package designpatterns.creational.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProductAPI {
    public static void main(String[] args) {
//        ProductWebClient.getAllProducts();
//        ProductWebClient.getAllProducts();
//        ProductWebClient.getAllProducts();
//        ProductWebClient.getAllProducts();
//        ProductWebClient.getAllProducts();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(ProductWebClient::getAllProducts);
        executorService.execute(ProductWebClient::getAllProducts);
        executorService.execute(ProductWebClient::getAllProducts);
        executorService.execute(ProductWebClient::getAllProducts);
        executorService.execute(ProductWebClient::getAllProducts);

        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
