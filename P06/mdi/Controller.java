package mdi;

import java.util.Scanner; 
import java.util.ArrayList;

import store.Store;
import store.Customer;
import store.Order;
import store.Item;
import store.Product;
import store.Tool;
import store.Plant;
import store.Exposure;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Controller
{

	private Store store;
	private View view;
	private Menu mainMenu;
	private String output;
	private boolean isRunning;
	private Scanner scanner;
	private String filename;


	public Controller(String storeName){
		this.store = new Store(storeName);
		this.view = View.CUSTOMERS;
		this.mainMenu = new Menu();
		this.output = "";
		this.isRunning = true;
		this.in = new Scanner(System.in);
		this.filename = "Untitled";

		
	}

	public void mdi() {
		boolean isRunning = true;
		while(isRunning){
			selectFromMenu();
			output = "";
			System.out.print("Select: ");
			int choice = getInt();
			switch(choice){
				case 0: 
					exit();
					break;
				case 1:
					placeOrder();
					break;
				case 2:
					newCustomer();
					break;
				case 3:
					newTool();
					break;
				case 4:
					newPlant();
					break;
				case 5:
					switchView();
					break;
				default:
					System.out.println("Not an option, try again.");
				}
				}

			}

	private void selectFromMenu(){
		clearScreen();
        System.out.println(storeName + " Main Menu");
        System.out.println("0] Exit");
        System.out.println("1] Place Order");
        System.out.println("2] Welcome new Customer");
        System.out.println("3] Define new Tool");
        System.out.println("4] Define new Plant");
        System.out.println("5] Switch View");
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
		String name = getString("Ibrahim Oyewunmi");
        String email = getString("ibrahimoyew@gmail.com");
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

	public void save(){
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
			store.save(bw);
			System.out.println("Data saved to: " + filename);
		} catch (IOException e){
			System.out.println("Error saving data");
		}
	}
	public void saveAs(String newFilename){
		this.filename = newFilename;
		save();
	}
	public void open(String filename){
		this.filename = filename;
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			store = new Store(br);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
}

