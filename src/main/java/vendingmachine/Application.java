package vendingmachine;

import vendingmachine.controller.coin.CoinController;
import vendingmachine.controller.money.MoneyController;
import vendingmachine.controller.product.ProductController;
import vendingmachine.controller.vendingMachine.VendingMachineController;
import vendingmachine.io.ViewPrinter;
import vendingmachine.io.ViewReader;
import vendingmachine.service.coin.CoinService;
import vendingmachine.service.money.MoneyService;
import vendingmachine.service.product.ProductService;
import vendingmachine.service.vendingMachine.VendingMachineService;
import vendingmachine.view.InputValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
	public static void main(String[] args) {
		CoinController coinController = new CoinController(new CoinService());
		MoneyController moneyController = new MoneyController(new MoneyService());
		ProductController productController = new ProductController(new ProductService());
		VendingMachineController vendingMachineController = new VendingMachineController(new VendingMachineService());
		InputView inputView = new InputView(new ViewReader(), new ViewPrinter(), new InputValidator());
		OutputView outputView = new OutputView(new ViewPrinter());

		VendingMachineApp app = new VendingMachineApp(coinController, moneyController, productController,
				vendingMachineController, inputView, outputView);
		app.run();
	}
}
