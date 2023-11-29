package vendingmachine.domain.product;

import java.util.List;

public class Products {

	private final List<Product> products;

	public Products(List<Product> products) {
		this.products = products;
	}

	public int getSpetificProductPriceByName(String productName) {
		return findBy(productName).getPrice();
	}

	private Product findBy(String productName) {
		return products.stream()
				.filter(product -> product.checkBy(productName))
				.findAny()
				.get();
	}
	
	public void removeProductByName(String productName) {
		products.stream()
				.filter(product -> product.checkBy(productName))
				.findAny()
				.get()
				.sell();		
	}

	public boolean isEnoughMoneyForPurchase(int money) {
		return products.stream()
				.allMatch(product -> money >= product.getPrice());
	}

	public boolean isProductEmpty() {
		return products.size() == 0;
	}
}