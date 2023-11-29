package vendingmachine.controller.product;

import vendingmachine.domain.product.Products;
import vendingmachine.service.product.ProductService;

public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	public Products createProducts(String inputValue) {
		return service.createProducts(inputValue);
	}
}