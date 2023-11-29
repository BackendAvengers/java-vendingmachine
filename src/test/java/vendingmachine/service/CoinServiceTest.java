package vendingmachine.service;

import org.junit.jupiter.api.Test;

import vendingmachine.domain.coin.Coins;
import vendingmachine.service.coin.CoinService;

public class CoinServiceTest {

    @Test
    public void testCreateCoins() {
        CoinService coinService = new CoinService();

        // 테스트할 currentAmount
        int currentAmount = 500;

        Coins coins = coinService.createCoins(currentAmount);
        
        System.out.println(coins.getCoinCounts());
    }
}
