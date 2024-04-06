package view.game;

import org.example.view.game.GameViewer;
import org.example.view.game.ElementViewer;
import org.example.view.game.MinerViewer;
import org.example.view.game.CoinViewer;
import org.example.view.game.WallViewer;
import org.example.view.game.EnemyViewer;
import org.example.model.game.elements.Element;
import org.example.model.game.elements.Coin;
import org.example.model.game.elements.Enemy;
import org.example.model.game.elements.Miner;
import org.example.model.game.elements.Wall;
import org.example.model.game.map.Map;
import org.example.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class GameViewerTest {

    private GUI mockGui;
    private Map mockMap;
    private GameViewer gameViewer;

    @BeforeEach
    void setUp() {
        mockGui = mock(GUI.class);
        mockMap = mock(Map.class);
        gameViewer = new GameViewer(mockMap);
    }

    @Test
    void testDrawElements() {
        List<Wall> walls = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>();
        List<Coin> coins = new ArrayList<>();
        Miner miner = new Miner(1, 1);

        when(mockMap.getWalls()).thenReturn(walls);
        when(mockMap.getEnemies()).thenReturn(enemies);
        when(mockMap.getCoins()).thenReturn(coins);
        when(mockMap.getMiner()).thenReturn(miner);

        gameViewer.drawElements(mockGui);

        verify(mockGui).gameFrame();
        verifyDrawElements(mockGui, walls, new WallViewer());
        verifyDrawElements(mockGui, enemies, new EnemyViewer());
        //verifyDrawElement(mockGui, miner, new MinerViewer());
        verifyDrawElements(mockGui, coins, new CoinViewer());
    }

    private <T extends Element> void verifyDrawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements) {
            verifyDrawElement(gui, element, viewer);
        }
    }

    private <T extends Element> void verifyDrawElement(GUI gui, T element, ElementViewer<T> viewer) {
        verify(viewer).draw(element, gui);
    }
}
