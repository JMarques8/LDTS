package model.game.elements;

import org.example.model.game.elements.Coin;
import org.example.model.game.elements.Miner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoinTest {
    @Test
    public void testCoinCreation() {
        Coin coin = new Coin(3, 5);
        assertEquals(3, coin.getPosition().getX());
        assertEquals(5, coin.getPosition().getY());
    }

    @Test
    public void testCollidesWithMiner() {
        Miner miner = new Miner(0, 0);
        Coin coin = new Coin(0, 0);
        assertTrue(coin.collidesWithMiner(miner));
    }
}
