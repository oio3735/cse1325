package mdi;

import java.util.Scanner; 
import java.util.ArrayList;

import mdi.Menu;
import mdi.MenuItem;

public class Controller
{

	private Store store;
	private View view;
	private Menu mainMenu;
	private String output;
	private boolean isRunning;
	private Scanner scanner;


	public Controller(String storeName){
		this.store = new Store(storeName);
		this.view = View.CUSTOMERS;
		this.mainMenu = new Menu();
		this.output = "";
		this.isRunning = true;
		this.in = new Scanner(System.in);
		
	}

	public void mdi() {
		isRunning = true;
		while(isRunning){
			selectFromMenu();
			output = "";
			try{
			mainMenu.run(getInt("Selection: "));
		}	catch(Exception e){
			System.err.println("Invalid input");
		}

		}
	}

	private void exit(){
		isRunning = false;
	}

	private void placeOrder(){
		int customerIndex = getInt("Select customer");
		Customer customer = store.getCustomers().get(customerIndex);
		int orderIndex = store.newOrder(customer);
		output = "Order placed successfully";
		while(true){
			int productIndex = getInt("Select product (-1) to finish");
			if (productIndex == -1)break;
			int quantity = getInt("Enter quantity");
			store.addToOrder(orderIndex, productIndex, quantity);
		}
		view = View.ORDERS;
	}

	private void newCustomer(){
		String name = getString("Enter customer name");
        String email = getString("Enter customer email");
        store.addCustomer(new Customer(name, email));
        output = "Customer added successfully.";
        view = View.CUSTOMERS;
	}

	private void newTool(){
		String name = getString("Enter tool name");
		double price = getDouble("Enter tool price");
		store.addProduct(new Tool(name, price));
		output = "Tool added successfully";
		view = View.PRODUCTS;
	}

	private void newPlant(){
		String name = getString("Enter plant name");
		double price = getDouble("Enter plant price");
		Exposure exposure = Exposure.valueOf(getString("Enter plant exposure (e.g., SUN, SHADE)"));
		store.addProduct(new Plant(name, price));
		output = "Plant added successfully";
		view = View.PRODUCTS;
	}

	private void switchView(){
		System.out.println("Available views: Customer, Products, Orders");
		String viewName = getString("Enter view name");
		view = View.valueOf(viewName.toUppercase());
	}
	
}

