package StreamAPI;

import java.util.List;

public class Order {
    private List<String> products;

    public Order(List<String> products) {
        this.products = products;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
