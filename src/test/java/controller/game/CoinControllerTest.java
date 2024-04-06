package controller.game;

import org.example.controller.game.CoinController;
import org.example.model.game.elements.Coin;
import org.example.model.game.elements.Miner;
import org.example.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CoinControllerTest {

    private CoinController coinController;
    private Map map;

    @BeforeEach
    void setUp() {
        map = Mockito.mock(Map.class);
        coinController = new CoinController(map);
    }

    @Test
    void handleCollisionShouldIncreaseMinerCoinsAndRemoveCoinFromMap() {
        Miner miner = new Miner(0, 0);
        Coin coin = new Coin(0, 0);

        List<Coin> coins = new ArrayList<>();
        coins.add(coin);

        doNothing().when(map).removeCoin(any(Coin.class));

        when(map.getCoins()).thenReturn(coins);

        coinController.handleCollision(miner);

        assertEquals(1, miner.getCoinsCollected());
        verify(map, times(1)).removeCoin(coin);
    }
}
