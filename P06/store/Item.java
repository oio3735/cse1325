package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Item {
	private Product product;
	private int quantity;

	public void save(BufferedWriter bw) throws IOException{
		product.save(bw);
	}

	public Item(BufferedReader br) throws IOException{
		String type = br.readLine();
		if(type.equals("Plant")){
			product = new Plant(br);
		}
		else if(type.equals("Tool")){
			product = new Tool(br);
		}
		}
	}

	public Item(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
}
	public int getPrice () {
		return quantity * product.getPrice();
}
	@Override
	public String toString() {
		int price = getPrice();
		return String.format("%3d %-40s $ %5d.%02d", quantity, product, price/100, price%100);

	}

}