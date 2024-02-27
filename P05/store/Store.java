package store;

import java.util.ArrayList;

public class Store {
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;

    public Store(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String getCustomerList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customers.size(); i++) {
            sb.append(i).append(": ").append(customers.get(i)).append("\n");
        }
        return sb.toString();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String getProductList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < products.size(); i++) {
            sb.append(i).append(": ").append(products.get(i)).append("\n");
        }
        return sb.toString();
    }

    public int newOrder(Customer customer) {
        Order newOrder = new Order(customer);
        orders.add(newOrder);
        return orders.indexOf(newOrder);
    }

    public void addToOrder(int orderIndex, int productIndex, int quantity) {
        Order order = orders.get(orderIndex);
        Product product = products.get(productIndex);
        order.addItem(new Item(product, quantity));
    }

    // Other methods as needed

    // Getter for the store name
    public String getName() {
        return name;
    }
}