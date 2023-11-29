package vendingmachine.domain.coin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Coin {

    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}
	
	public static Coin findBy(int amount) {
		return Arrays.stream(Coin.values())
				.filter(coin -> coin.amount == amount)
				.findAny()
				.get();
	}

	public static Map<Coin, Integer> initializeCoinCounts() {
	    return Arrays.stream(Coin.values())
	            .sorted(Comparator.comparing(Coin::getAmount).reversed())
	            .collect(Collectors.toMap(coin -> coin, coin -> 0, (e1, e2) -> e1, LinkedHashMap::new));
	}

	public static Map<Coin, Integer> getMinCoinCounts(int targetAmount) {
		Map<Coin, Integer> coinCounts = new LinkedHashMap<>();
		for (Coin coin : Coin.values()) {
			int coinValue = coin.getAmount();
			int coinCount = targetAmount / coinValue;
			if (coinCount > 0) {
				coinCounts.put(coin, coinCount);
				targetAmount %= coinValue;
			}
		}
		return coinCounts;
	}

	public static List<Integer> toList() {
        return Arrays.stream(values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
	}

	public int getAmount() {
		return amount;
	}
}