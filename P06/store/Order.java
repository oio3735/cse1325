package store;

import java.util.ArrayList;
/**
 * @author Oyebola Ibrahim Oyewunmi
 * @version 0.2
 * @since [February 11, 2024]
 */

public class Order {
    
private static int nextOrderNumber = 1000; // Initial order number
    private int orderNumber;
    private Customer customer;
    private ArrayList<Item> items;

    /**
     * Constructs an order with the customer
     * @param customer the customer placing the order
     * @since feb 11
     */
    public Order(Customer customer) {
        this.customer = customer;
        this.orderNumber = nextOrderNumber++;
        this.items = new ArrayList<>();
    }

     public void save(BufferedWriter bw) throws IOException {
        // Save each item to the file
        for (Item item : items) {
            item.save(bw);
        }
    }

    public Order(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            // Determine the type of item and restore it
            Item item = new Item();
            item.restore(br);
            items.add(item);
        }
    /**
     * Adds item to order
     * @param item item to add
     * @since feb 11
     */
    
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Calculates the total price of the order
     * @return the total price of the order
     * @since feb 11
     */
    public int getPrice() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    /**
     * Return a string of the order
     * @return a string of the order
     * @since feb 11
     */   
    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Order Number: ").append(orderNumber).append("\n");
        receipt.append("Customer: ").append(customer.getName()).append("\n");
        receipt.append("Items:\n");
        for (Item item : items) {
            receipt.append(item).append("\n");
        }
        receipt.append("Total Price: $").append(getPrice() / 100).append(".").append(getPrice() % 100).append("\n");
        return receipt.toString();
    }
}
