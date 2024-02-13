package store;

import java.util.ArrayList;

public class Order {
private static int nextOrderNumber = 1000; // Initial order number
    private int orderNumber;
    private Customer customer;
    private ArrayList<Item> items;

    // Constructor
    public Order(Customer customer) {
        this.customer = customer;
        this.orderNumber = nextOrderNumber++;
        this.items = new ArrayList<>();
    }

    // Method to add an item to the order
    public void addItem(Item item) {
        items.add(item);
    }

    // Method to calculate the total price of the order
    public int getPrice() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    // Method to generate the receipt
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
