package view.game;

import org.example.view.game.EnemyViewer;
import org.example.model.Position;
import org.example.model.game.elements.Enemy;
import org.example.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EnemyViewerTest {

    private GUI mockGui;
    private Enemy mockEnemy;
    private EnemyViewer enemyViewer;

    @BeforeEach
    void setUp() {
        mockGui = mock(GUI.class);
        mockEnemy = mock(Enemy.class);
        enemyViewer = new EnemyViewer();
    }

    @Test
    void testDraw() {
        // Stubbing the behavior of the Enemy object
        when(mockEnemy.getPosition()).thenReturn(new Position(4, 5));

        // Performing the method to be tested
        enemyViewer.draw(mockEnemy, mockGui);

        // Verifying the interactions with the GUI
        verify(mockGui).drawGameElement(4, 5, 'E', "#dc143c");
    }
}
