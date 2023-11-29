package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.Coins;

public class CoinTest {

    @Test
    public void testInitializeCoinCounts() {
        // Given

        // When
        Map<Coin, Integer> coinCounts = Coin.initializeCoinCounts();

        // Then
        for (Coin coin : Coin.values()) {
//            System.out.println(coin.getAmount());
        }
    }
    
    @Test
    public void testGetMinCoinCounts() {
        Coins coins = new Coins();
        coins.setCoin(Coin.COIN_500);
        coins.setCoin(Coin.COIN_100);
        coins.setCoin(Coin.COIN_50);

        Map<Coin, Integer> result = coins.getMinCoinCounts(610);

        System.out.println(result);
        
    }
}
