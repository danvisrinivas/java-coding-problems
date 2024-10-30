package designpatterns.creational.singleton;

public class ProductWebClient {

    public static void getAllProducts(){
        ProductService productService = new ProductServiceImpl(ProductRepositoryImpl.getInstance());
        productService.getProducts();
    }
}
