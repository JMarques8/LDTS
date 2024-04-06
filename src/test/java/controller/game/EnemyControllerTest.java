package controller.game;

import org.example.controller.game.EnemyController;
import org.example.model.game.elements.Enemy;
import org.example.model.game.elements.Miner;
import org.example.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class EnemyControllerTest {

    private EnemyController enemyController;
    private Map map;

    @BeforeEach
    void setUp() {
        map = Mockito.mock(Map.class);
        enemyController = new EnemyController(map);
    }

    @Test
    void moveEnemyShouldChangeDirectionIfHitWall() {
        Enemy enemy = new Enemy(0, 0);
        enemy.setDirection(1);

        when(map.isWall(any())).thenReturn(true);

        enemyController.moveEnemy(enemy, null);

        verify(map, atLeastOnce()).isWall(any());
        assertNotEquals(1, enemy.getDirection());
    }

    @Test
    void moveEnemyShouldDecreaseMinerLivesIfCollisionOccurs() {
        Enemy enemy = new Enemy(0, 0);

        when(map.isWall(any())).thenReturn(false);

        Miner miner = Mockito.mock(Miner.class);
        when(map.getMiner()).thenReturn(miner);

        when(miner.getPosition()).thenReturn(enemy.getPosition());

        enemyController.moveEnemy(enemy, null);

        verify(map, atLeastOnce()).getMiner();
        verify(miner, times(1)).decreaseLives();
    }
}
