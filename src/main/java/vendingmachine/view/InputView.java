package vendingmachine.view;

import vendingmachine.io.ViewPrinter;
import vendingmachine.io.ViewReader;

public class InputView {

	private static final String NEW_LINE = System.lineSeparator();

	private final ViewReader reader;
	private final ViewPrinter printer;
	private final InputValidator validator;

	public InputView(ViewReader reader, ViewPrinter printer, InputValidator validator) {
		this.reader = reader;
		this.printer = printer;
		this.validator = validator;
	}

	public int inputCurrentMoney() {
		printer.printLine("자판기가 보유하고 있는 금액을 입력해 주세요." + NEW_LINE);

		String inputValue = reader.readLine();

		validator.validateIsEmpty(inputValue);
		validator.validatePositiveNumber(inputValue);

		return Integer.parseInt(inputValue);
	}

	public String inputProducts() {
		printer.printLine("상품명과 가격, 수량을 입력해 주세요." + NEW_LINE);

		String inputValue = reader.readLine();

		validator.validateIsEmpty(inputValue);
		validator.validateInputProductsFormat(inputValue);

		return inputValue;
	}

	public int inputInsertedAmount() {
		printer.printLine(NEW_LINE + NEW_LINE  + NEW_LINE + "투입 금액을 입력해 주세요." + NEW_LINE);

		String inputValue = reader.readLine();

		validator.validateIsEmpty(inputValue);
		validator.validatePositiveNumber(inputValue);

		return Integer.parseInt(inputValue);
	}

	public String inputProductName() {
		printer.printLine("구매할 상품명을 입력해 주세요." + NEW_LINE);

		String inputValue = reader.readLine();

		validator.validateIsEmpty(inputValue);

		return inputValue;
	}
}