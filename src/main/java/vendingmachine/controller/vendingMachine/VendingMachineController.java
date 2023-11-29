package vendingmachine.controller.vendingMachine;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.money.Money;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.vendingMachine.VendingMachine;
import vendingmachine.service.vendingMachine.VendingMachineService;

public class VendingMachineController {

	private final VendingMachineService service;

	public VendingMachineController(VendingMachineService service) {
		this.service = service;
	}

	public VendingMachine createVendingMachine(Coins coins, Products products, Money insertedMoney) {
		return service.createVendingMachine(coins, products, insertedMoney);
	}
}