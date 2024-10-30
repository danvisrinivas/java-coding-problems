package designpatterns.creational.singleton;

import java.util.List;

public class ProductServiceImpl implements  ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
//        System.out.println("Object created for : "+ this);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }
}
