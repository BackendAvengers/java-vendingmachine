package vendingmachine.domain.coin;

import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {

	private final Map<Coin, Integer> coinCounts;

	public Coins() {
		coinCounts = Coin.initializeCoinCounts();
	}

	public void setCoin(Coin coin) {
		coinCounts.put(coin, coinCounts.getOrDefault(coin, 0) + 1);
	}

	public Map<Coin, Integer> getMinCoinCounts(int targetAmount) {
		Map<Coin, Integer> returnCoinCounts = new LinkedHashMap<>();

		for (Map.Entry<Coin, Integer> entry : coinCounts.entrySet()) {
			calculateCoinToReturnAndReduce(returnCoinCounts, entry, targetAmount);
			if (targetAmount < 0) {
				break;
			}
		}

		return returnCoinCounts;
	}

	private void calculateCoinToReturnAndReduce(Map<Coin, Integer> returnCoinCounts, Map.Entry<Coin, Integer> entry,
			int targetAmount) {
		Coin coin = entry.getKey();
		int coinAmount = coin.getAmount();
		int coinNumber = entry.getValue();
		int numCoinsToReturn = Math.min(coinNumber, targetAmount / coinAmount);
		returnCoinCounts.put(coin, numCoinsToReturn);
		targetAmount -= numCoinsToReturn * coinAmount;
	}

	public Map<Coin, Integer> getCoinCounts() {
		return coinCounts;
	}
}