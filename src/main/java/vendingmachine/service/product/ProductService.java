package vendingmachine.service.product;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.Products;

public class ProductService {

	public Products createProducts(String inputValue) {
		List<Product> products = new ArrayList<>();

		String[] productStrings = inputValue.split(";");
		for (String productString : productStrings) {
			Product product = parseProductString(productString);
			if (products != null) {
				products.add(product);
			}
		}

		return new Products(products);
	}

	private Product parseProductString(String productString) {
		String[] tokens = productString.replaceAll("[\\[\\]]", "").split(",");
		if (tokens.length >= 3) {
			String productName = tokens[0];
			int price = Integer.parseInt(tokens[1]);
			int productNumber = Integer.parseInt(tokens[2]);
			Product product = new Product(productName, price, productNumber);
			return product;
		}
		return null;
	}
}