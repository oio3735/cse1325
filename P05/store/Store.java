package store;
import java.util.ArrayList;

import store.Customer;
import store.Product;
import store.Order;
import store.Item;

public class Store{
	private String name;
	private ArrayList<Customer> customers;
	private ArrayList<Product> products;
	private ArrayList<Order> orders;

	public Store(String name){
		this.name = name;
		this.customers = new ArrayList<>();
		this.products = new ArrayList<>();
		this.orders = new ArrayList<>();
	}
	public String getName(){
		return name;
	}

	public void addCustomer(Customer customer){
		customers.add(customer);
	}
	public String getCustomerList(){
		StringBuilder customerList = new StringBuilder();
		for(int i = 0; i < customers.size(); i++){
			customerList.append(i).append(": ").append(customers.get(i)).append("\n");
		}
		return customerList.toString();
}	

	public void addProduct(Product product){

		products.add(product);
	}

	public String getProductList(){
		StringBuilder productList = new StringBuilder();
		for(int i = 0; i < products.size(); i++){
			productList.append(i).append(": ").append(products.get(i)).append("\n");
		}
		return productList.toString();
	}

	public int newOrder(int customerIndex){
		if (customerIndex < 0 || customerIndex >= customers.size()) {
            
            return -1;
        }
        Customer customer = customers.get(customerIndex);
        Order newOrder = new Order(customer);
        orders.add(newOrder);
        return orders.indexOf(newOrder);
	}
	public void addToOrder(int orderIndex, int productIndex, int quantity){
		if (orderIndex < 0 || orderIndex >= orders.size() ||
            productIndex < 0 || productIndex >= products.size()) {
            
            return;
        }
        Order order = orders.get(orderIndex);
        Product product = products.get(productIndex);
        Item item = new Item(product, quantity);
        order.addItem(item);
	}
	public String getOrderList(){
		StringBuilder orderList = new StringBuilder();
		for(int i = 0; i < orders.size(); i++) {
        orderList.append(i).append(": ").append(orders.get(i)).append("\n");
    }
    return orderList.toString();
	}
}