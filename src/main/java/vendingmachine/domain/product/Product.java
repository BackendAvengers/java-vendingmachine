package vendingmachine.domain.product;

public class Product {

	private final ProductName productName;
	private final ProductPrice price;
	private int productNumber;

	public Product(String productName, int price, int productNumber) {
		this.productName = new ProductName(productName);
		this.price = new ProductPrice(price);
		this.productNumber = productNumber;
	}

	public boolean checkBy(String productName) {
		return this.productName.checkBy(productName);
	}

	public void sell() {
		this.productNumber--;
	}

	public int getPrice() {
		return price.getPrice();
	}
}