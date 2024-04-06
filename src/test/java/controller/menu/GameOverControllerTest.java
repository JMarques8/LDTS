package controller.menu;

import org.example.Game;
import org.example.controller.menu.GameOverController;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.model.menu.GameOver;
import org.example.view.gui.GUI;
import org.example.model.menu.Menu;
import org.example.state.GameState;
import org.example.state.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameOverControllerTest {

    @Mock
    private GameOver mockGameOver;

    @Mock
    private Game mockGame;

    @Mock
    private GUI mockGUI;

    private GameOverController gameOverController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameOverController = new GameOverController(mockGameOver);
    }

    @Test
    void testStepUp() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.UP);

        gameOverController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGameOver).previousChoice();
    }

    @Test
    void testStepDown() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.DOWN);

        gameOverController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGameOver).nextChoice();
    }

    @Test
    void testStepSelectRestart() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(mockGameOver.isSelectedRestart()).thenReturn(true);

        gameOverController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGame).setState(ArgumentMatchers.isA(GameState.class));
    }

    @Test
    void testStepSelectMenu() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(mockGameOver.isSelectedMenu()).thenReturn(true);

        gameOverController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGame).setState(ArgumentMatchers.isA(MenuState.class));
    }

    @Test
    void testStepSelectExit() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(mockGameOver.isSelectedExit()).thenReturn(true);

        gameOverController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGame).setState(null);
    }
}
