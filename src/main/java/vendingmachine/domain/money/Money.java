package vendingmachine.domain.money;

public class Money {

	private int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public void buyProduct(int productPrice) {
		amount -= productPrice;
	}

	public int getMoney() {
		return amount;
	}
}