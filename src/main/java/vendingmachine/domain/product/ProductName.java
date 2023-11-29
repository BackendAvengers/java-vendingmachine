package vendingmachine.domain.product;

public class ProductName {

	private final String productName;

	public ProductName(String productName) {
		this.productName = productName;
	}

	public boolean checkBy(String productName) {
		return this.productName.equals(productName);
	}
}