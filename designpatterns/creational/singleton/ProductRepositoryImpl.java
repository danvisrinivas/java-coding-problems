package designpatterns.creational.singleton;

//import org.openjdk.jol.info.ClassLayout;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{

    public ProductRepositoryImpl(){
        System.out.println("Object Created for : "+ this);
//        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }

//    private static ProductRepository INSTANCE;
//
//    public static ProductRepository getInstance(){
//        if(INSTANCE == null){
//            INSTANCE = new ProductRepositoryImpl();
//        }
//        return INSTANCE;
//    }

    private static class ProductRepositoryInstance{
        private static final ProductRepository INSTANCE = new ProductRepositoryImpl();
    }

    public static ProductRepository getInstance(){
        return ProductRepositoryInstance.INSTANCE;
    }

    @Override
    public List<Product> getProducts() {
        return List.of(new Product("product 1", "Electronics", 8909.0));
    }
}
