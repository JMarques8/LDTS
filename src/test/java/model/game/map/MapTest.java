package model.game.map;

import org.example.model.game.map.Map;
import org.example.model.Position;
import org.example.model.game.elements.Enemy;
import org.example.model.game.elements.Miner;
import org.example.model.game.elements.Coin;
import org.example.model.game.elements.Wall;
import org.example.model.game.elements.Final;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    private Map map;

    @BeforeEach
    public void setUp() {
        map = new Map(10, 10);

    }

    @Test
    public void testGetWidth() {
        assertEquals(10, map.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(10, map.getHeight());
    }

    @Test
    public void testGetMiner() {
        Miner miner = new Miner(1, 1);
        map.setMiner(miner);
        assertEquals(miner, map.getMiner());
    }

    @Test
    public void testGetEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(1, 1));
        map.setEnemies(enemies);
        assertEquals(enemies, map.getEnemies());
    }

    @Test
    public void testGetCoins() {
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(1, 1));
        map.setCoins(coins);
        assertEquals(coins, map.getCoins());
    }

    @Test
    public void testGetWalls() {
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(1, 1));
        map.setWalls(walls);
        assertEquals(walls, map.getWalls());
    }

    @Test
    public void testGetFinal() {
        List<Final> finals = new ArrayList<>();
        finals.add(new Final(1, 1));
        map.setFinal(finals);
        assertEquals(finals, map.getFinal());
    }

    @Test
    public void testSetMiner() {
        Miner miner = new Miner(1, 1);
        map.setMiner(miner);
        assertEquals(miner, map.getMiner());
    }

    @Test
    public void testSetEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(1, 1));
        map.setEnemies(enemies);
        assertEquals(enemies, map.getEnemies());
    }

    @Test
    public void testSetCoins() {
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(1, 1));
        map.setCoins(coins);
        assertEquals(coins, map.getCoins());
    }

    @Test
    public void testSetWalls() {
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(1, 1));
        map.setWalls(walls);
        assertEquals(walls, map.getWalls());
    }

    @Test
    public void testSetFinal() {
        List<Final> finals = new ArrayList<>();
        finals.add(new Final(1, 1));
        map.setFinal(finals);
        assertEquals(finals, map.getFinal());
    }

    @Test
    public void testIsWall() {
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(1, 1));
        map.setWalls(walls);
        assertTrue(map.isWall(new Position(1, 1)));
    }

    @Test
    public void testIsEnemy() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(1, 1));
        map.setEnemies(enemies);
        assertTrue(map.isEnemy(new Position(1, 1)));
    }

    @Test
    public void testIsCoin() {
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(1, 1));
        map.setCoins(coins);
        assertTrue(map.isCoin(new Position(1, 1)));
    }

    @Test
    public void testIsFinal() {
        List<Final> finals = new ArrayList<>();
        finals.add(new Final(1, 1));
        map.setFinal(finals);
        assertTrue(map.isFinal(new Position(1, 1)));
    }

    @Test
    public void testRemoveCoin() {
        List<Coin> coins = new ArrayList<>();
        Coin coin = new Coin(1, 1);
        coins.add(coin);
        map.setCoins(coins);
        map.removeCoin(coin);
        assertEquals(0, map.getCoins().size());
    }
}
