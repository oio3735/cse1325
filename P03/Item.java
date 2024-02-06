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
		String productString = String.format("%-40s", product.toString());
		String itemPrice = String.format("%5.2f", getPrice());

		return String.format("%3d %s $ %s", quantity, productString, itemPrice);
	}

}