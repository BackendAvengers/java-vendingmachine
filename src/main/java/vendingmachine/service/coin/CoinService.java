package vendingmachine.service.coin;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.Coins;

public class CoinService {

	public Coins createCoins(int currentAmount) {
		Coins coins = new Coins();

		while (!checkCurrentAmount(currentAmount)) {
			int coinAmount = Randoms.pickNumberInList(Coin.toList());

			if (isAmountSufficient(currentAmount, coinAmount)) {
				currentAmount -= coinAmount;
				Coin coin = Coin.findBy(coinAmount);
				coins.setCoin(coin);
			}
		}

		return coins;
	}

	private boolean checkCurrentAmount(int cuurentAmount) {
		return cuurentAmount == 0;
	}

	private boolean isAmountSufficient(int currentAmount, int coinAmount) {
		return currentAmount >= coinAmount;
	}
}