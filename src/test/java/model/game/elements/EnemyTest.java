package model.game.elements;

import org.example.model.game.elements.Enemy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EnemyTest {

    @Test
    public void testEnemy() {
        Enemy enemy = new Enemy(0, 0);
        assertEquals(0, enemy.getPosition().getX());
        assertEquals(0, enemy.getPosition().getY());
    }

    @Test
    public void testSetDirection() {
        Enemy enemy = new Enemy(0, 0);
        enemy.setDirection(1);
        assertEquals(1, enemy.getDirection());
    }

    @Test
    public void testGetDirection() {
        Enemy enemy = new Enemy(0, 0);
        assertEquals(0, enemy.getDirection());
        enemy.setDirection(1);
        assertEquals(1, enemy.getDirection());
    }

    @Test
    public void testGetStartPosition() {
        Enemy enemy = new Enemy(0, 0);
        assertEquals(0, enemy.getStartPosition().getX());
        assertEquals(0, enemy.getStartPosition().getY());
    }
}
