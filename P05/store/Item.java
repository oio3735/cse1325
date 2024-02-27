package store;

public class Item {
	private Product product;
	private int quantity;

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