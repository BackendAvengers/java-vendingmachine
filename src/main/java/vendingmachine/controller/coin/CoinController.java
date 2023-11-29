package vendingmachine.controller.coin;

import vendingmachine.domain.coin.Coins;
import vendingmachine.service.coin.CoinService;

public class CoinController {

	private final CoinService service;

	public CoinController(CoinService service) {
		this.service = service;
	}

	public Coins createCoins(int curretnAmount) {
		return service.createCoins(curretnAmount);
	}
}