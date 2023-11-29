package vendingmachine.domain.vendingMachine;

import java.util.Map;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.money.Money;
import vendingmachine.domain.product.Products;

public class VendingMachine {

	private final Coins coins;
	private final Products products;
	private Money insertedMoney;

	public VendingMachine(Coins coins, Products products, Money insertedMoney) {
		this.coins = coins;
		this.products = products;
		this.insertedMoney = insertedMoney;
	}

	public void sellProduct(String productName) {
		int productPrice = products.getSpetificProductPriceByName(productName);
		products.removeProductByName(productName);
		insertedMoney.buyProduct(productPrice);
	}

	
}