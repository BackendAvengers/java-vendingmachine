package vendingmachine.view;

import java.util.Map;
import java.util.StringJoiner;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.Coins;
import vendingmachine.io.ViewPrinter;

public class OutputView {

	private static final String NEW_LINE = System.lineSeparator();

	private final ViewPrinter printer;

	public OutputView(ViewPrinter printer) {
		this.printer = printer;
		;
	}

	public void printCoins(Coins coins) {
		StringJoiner coinsMessage = new StringJoiner(NEW_LINE);
		coinsMessage.add(NEW_LINE + NEW_LINE + NEW_LINE + "자판기가 보유한 동전" + NEW_LINE);
		for (Map.Entry<Coin, Integer> entry : coins.getCoinCounts().entrySet()) {
			int coinAmount = entry.getKey().getAmount();
			int coinNumber = entry.getValue();

			coinsMessage.add(String.format("%,d원 - %d개" + NEW_LINE, coinAmount, coinNumber));
		}

		coinsMessage.add(NEW_LINE);

		printer.printLine(coinsMessage.toString());
	}

	public void printInsertedAmount(int insertedAmount) {
		printer.printLine(NEW_LINE + NEW_LINE + NEW_LINE + String.format("투입 금액: %d원", insertedAmount) + NEW_LINE);
	}

	public void printGiveReturn(Map<Coin, Integer> coins) {
		StringJoiner coinsMessage = new StringJoiner(NEW_LINE);
		coinsMessage.add("잔돈" + NEW_LINE);
		for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
			int coinAmount = entry.getKey().getAmount();
			int coinNumber = entry.getValue();

			coinsMessage.add(String.format("%,d원 - %d개" + NEW_LINE, coinAmount, coinNumber));
		}

		coinsMessage.add("");

		printer.printLine(coinsMessage.toString());
	}
}
