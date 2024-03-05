package store;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;


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

    public void save(BufferedWriter bw) throws IOException{
        bw.write(Integer.toString(customers.size()));
        bw.newLine();
        for(Customer customer : customers){
            customer.save(bw);
        }
    }

    public Store(BufferedReader br) throws IOException{
        this.orders = new ArrayList<>();
        int numCustomers = Integer.parseInt(br.readLine());
        this.products = newArrayList<>();
        for(int i = 0; i < numCustomers; i++){
            customers.add(new Customer(br));
            if(type.equals("Tool")){
                products.add(new Tool(br));
            }
            else if(type.equals("Plant")){
                products.add(new Plant(br));
            }
        }
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

    public String getName() {
        return name;
    }
}