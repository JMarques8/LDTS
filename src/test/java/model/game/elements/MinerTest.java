package model.game.elements;

import org.example.model.game.elements.Miner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinerTest {

    @Test
    public void testMinerCreation() {
        Miner miner = new Miner(3, 5);
        assertEquals(3, miner.getPosition().getX());
        assertEquals(5, miner.getPosition().getY());
        assertEquals(0, miner.getScore());
        assertEquals(-1, miner.getTime());
        assertEquals(3, miner.getLives());
        assertEquals(0, miner.getCoinsCollected());
    }

    @Test
    public void testIncreaseScore() {
        Miner miner = new Miner(0, 0);
        miner.increaseScore();
        assertEquals(1, miner.getScore());
        miner.increaseScore();
        assertEquals(2, miner.getScore());
    }

    @Test
    public void testSetScore() {
        Miner miner = new Miner(0, 0);
        miner.setScore(10);
        assertEquals(10, miner.getScore());
    }

    @Test
    public void testGetScore() {
        Miner miner = new Miner(0, 0);
        assertEquals(0, miner.getScore());
        miner.setScore(10);
        assertEquals(10, miner.getScore());
    }

    @Test
    public void testSetTime() {
        Miner miner = new Miner(0, 0);
        miner.setTime(10);
        assertEquals(10, miner.getTime());
    }

    @Test
    public void testIncreaseTime() {
        Miner miner = new Miner(0, 0);
        miner.increaseTime();
        assertEquals(0, miner.getTime());
        miner.setTime(10);
        miner.increaseTime();
        assertEquals(11, miner.getTime());
    }

    @Test
    public void testGetTime() {
        Miner miner = new Miner(0, 0);
        assertEquals(-1, miner.getTime());
        miner.setTime(10);
        assertEquals(10, miner.getTime());
    }

    @Test
    public void testDecreaseLives() {
        Miner miner = new Miner(0, 0);
        miner.decreaseLives();
        assertEquals(2, miner.getLives());
        miner.decreaseLives();
        assertEquals(1, miner.getLives());
    }

    @Test
    public void testGetLives() {
        Miner miner = new Miner(0, 0);
        assertEquals(3, miner.getLives());
        miner.decreaseLives();
        assertEquals(2, miner.getLives());
    }

    @Test
    public void testIncreaseCoins() {
        Miner miner = new Miner(0, 0);
        miner.increaseCoins();
        assertEquals(1, miner.getCoinsCollected());
        miner.increaseCoins();
        assertEquals(2, miner.getCoinsCollected());
    }

    @Test
    public void testGetCoinsCollected() {
        Miner miner = new Miner(0, 0);
        assertEquals(0, miner.getCoinsCollected());
        miner.increaseCoins();
        assertEquals(1, miner.getCoinsCollected());
    }


}
