package vendingmachine.controller.money;

import vendingmachine.domain.money.Money;
import vendingmachine.service.money.MoneyService;

public class MoneyController {
	
	private final MoneyService service;
	
	public MoneyController(MoneyService service) {
		this.service = service;
	}
	
	public Money createCurrentAmount(int currentAmount) {
		return service.createCurrentAmount(currentAmount);
	}
	
	public Money createInsertedAmount(int insertedAmount) {
		return service.createInsertedAmount(insertedAmount);
	}
}
