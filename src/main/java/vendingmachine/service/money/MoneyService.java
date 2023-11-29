package vendingmachine.service.money;

import vendingmachine.domain.money.Money;

public class MoneyService {

	public Money createCurrentAmount(int currentAmount) {
		return new Money(currentAmount);
	}

	public Money createInsertedAmount(int insertedAmount) {
		return new Money(insertedAmount);
	}
}