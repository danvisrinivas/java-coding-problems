package designpatterns.structural.decorator;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> items = new ArrayList<>();

    public void addItem(Product item){
        items.add(item);
    }

    public double calculateCost(){
        double totalCost=0;
        for(Product item : items){
            totalCost += item.getPrice();
        }
        return totalCost;
    }
}
