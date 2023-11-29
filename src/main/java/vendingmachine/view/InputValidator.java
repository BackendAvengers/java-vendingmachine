package vendingmachine.view;

import java.util.regex.Pattern;

import vendingmachine.util.ErrorMessage;

public class InputValidator {

	private static final Pattern INPUT_PRODUCTS_FORMAT = Pattern.compile("\\[(.*?),(\\d+),(\\d+)\\](?:;|$)");
	private static final Pattern POSITIVE_NUMBER_FORMAT = Pattern.compile("\\d+");

	public void validateInputProductsFormat(String inputValue) {
		if (!INPUT_PRODUCTS_FORMAT.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(ErrorMessage.INPUT_PRODUCTS_FORMAT.getMessage());
		}
	}

	public void validatePositiveNumber(String inputValue) {
		if (!POSITIVE_NUMBER_FORMAT.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(ErrorMessage.INPUT_NEGATIVE_NUMBER_FORMAT.getMessage());
		}
	}

	public void validateIsEmpty(String inputValue) {
		if (isEmpty(inputValue)) {
			throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.getMessage());
		}
	}

	private boolean isEmpty(String inputValue) {
		return inputValue == null || inputValue.isBlank();
	}
}