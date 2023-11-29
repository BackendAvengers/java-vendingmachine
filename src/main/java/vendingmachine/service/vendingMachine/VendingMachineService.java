package vendingmachine.service.vendingMachine;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.money.Money;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.vendingMachine.VendingMachine;

public class VendingMachineService {
	
	public VendingMachine createVendingMachine(Coins coins, Products products, Money insertedMoney) {
		return new VendingMachine(coins, products, insertedMoney);
	}
}