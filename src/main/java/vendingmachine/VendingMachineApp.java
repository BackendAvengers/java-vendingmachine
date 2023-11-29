package vendingmachine;

import vendingmachine.controller.coin.CoinController;
import vendingmachine.controller.money.MoneyController;
import vendingmachine.controller.product.ProductController;
import vendingmachine.controller.vendingMachine.VendingMachineController;
import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.money.Money;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.vendingMachine.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineApp {

	private final CoinController coinController;
	private final MoneyController moneyController;
	private final ProductController productController;
	private final VendingMachineController vendingMachineController;
	private final InputView inputView;
	private final OutputView outputView;

	public VendingMachineApp(CoinController coinController, MoneyController moneyController,
			ProductController productController, VendingMachineController vendingMachineController,
			InputView inputView, OutputView outputView) {
		this.coinController = coinController;
		this.moneyController = moneyController;
		this.productController = productController;
		this.vendingMachineController = vendingMachineController;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		try {
			VendingMachine ven = getVendingMachine();

			buyProduct(ven);

			outputView.printInsertedAmount(ven.getInsertedMoney());

			outputView.printGiveReturn(ven.giveReturn());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void buyProduct(VendingMachine ven) {

		while (ven.isNotPurchaseAvailable()) {
			outputView.printInsertedAmount(ven.getInsertedMoney());
			String productName = inputView.inputProductName();
			ven.sellProduct(productName);
		}
	}

	private VendingMachine getVendingMachine() {
		int inputCurrenetMoney = inputView.inputCurrentMoney();
		Money currentMoney = moneyController.createCurrentAmount(inputCurrenetMoney);
		Coins coins = coinController.createCoins(currentMoney.getMoney());
		outputView.printCoins(coins);
		Products products = productController.createProducts(inputView.inputProducts());

		int inputInsertedMoney = inputView.inputInsertedAmount();
		Money insertedMoney = moneyController.createInsertedAmount(inputInsertedMoney);
		VendingMachine ven = vendingMachineController.createVendingMachine(coins, products, insertedMoney);

		return ven;
	}
}
