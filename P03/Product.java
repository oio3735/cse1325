public class Product{
	private static int nextStockNumber = 0;

	private int stockNumber;
	private String name; 
	private int price;

	public Product(String name, int price){
		validatePrice(price);
		this.stockNumber = nextStockNumber++;
		this.name = name;
		this.price = price;
	}

	private void validatePrice(int price) {
		if (price<0)
			throw new IllegalArgumentException("Invalid price of" + name + ": " + price);
	}
	public int getstockNumber() {
		return stockNumber;
	}
	public int getPrice(){
		return price;
	}
	@Override
	public String toString(){
		String formatPrice = String.format("%5d", price);
		return String.format("%-30s $ %5d", name, price);
	}
}