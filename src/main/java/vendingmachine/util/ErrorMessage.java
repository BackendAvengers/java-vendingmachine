package vendingmachine.util;

public enum ErrorMessage {

	PREFIX("[ERROR] "),
	MIN_PRODUCT_PRICE("상품 가격은 100원이상이어야 합니다."),
	PRODUCT_PRICE_DIVISIBLE_AMOUNT("상품 가격은 10원으로 나누어떨어져야 합니다."),
	INPUT_PRODUCTS_FORMAT(";을 구분으로 [상품이름,상품가격,상품갯수]형태로 입력해주세요. ex) [콜라,1500,20];[사이다,1000,10]"),
	INPUT_EMPTY("값이 비어있습니다."),
	INPUT_NEGATIVE_NUMBER_FORMAT("0이상의 숫자만 입력해주세요.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return PREFIX.message + message;
	}
}