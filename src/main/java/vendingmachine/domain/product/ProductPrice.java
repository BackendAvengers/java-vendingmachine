package vendingmachine.domain.product;

import vendingmachine.util.ErrorMessage;

public class ProductPrice {

	private static final int MIN_PRICE = 100;
	private static final int DIVISIBLE_AMOUNT = 10;

	private final int price;

	public ProductPrice(int price) {
		validate(price);
		this.price = price;
	}

	public void validate(int price) {
		validateMinPrice(price);
		validateDivisible(price);
	}

	private void validateMinPrice(int price) {
		if (price < MIN_PRICE) {
			throw new IllegalArgumentException(ErrorMessage.MIN_PRODUCT_PRICE.getMessage());
		}
	}

	private void validateDivisible(int price) {
		if (price % DIVISIBLE_AMOUNT != 0) {
			throw new IllegalArgumentException(ErrorMessage.PRODUCT_PRICE_DIVISIBLE_AMOUNT.getMessage());
		}
	}

	public int getPrice() {
		return price;
	}
}