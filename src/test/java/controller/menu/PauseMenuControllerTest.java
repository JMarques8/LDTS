package controller.menu;

import org.example.Game;
import org.example.controller.menu.PauseMenuController;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.model.menu.Menu;
import org.example.model.menu.PauseMenu;
import org.example.state.GameState;
import org.example.state.MenuState;
import org.example.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class PauseMenuControllerTest {

    @Mock
    private PauseMenu mockPauseMenu;

    @Mock
    private Game mockGame;

    private PauseMenuController pauseMenuController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pauseMenuController = new PauseMenuController(mockPauseMenu);
    }

    @Test
    void testStepUp() throws IOException {
        when(mockPauseMenu.isSelectedResume()).thenReturn(true);

        pauseMenuController.step(mockGame, GUI.ACTION.UP, 100);

        verify(mockPauseMenu).previousChoice();
    }

    @Test
    void testStepDown() throws IOException {
        when(mockPauseMenu.isSelectedResume()).thenReturn(true);

        pauseMenuController.step(mockGame, GUI.ACTION.DOWN, 100);

        verify(mockPauseMenu).nextChoice();
    }

    @Test
    void testStepSelectResume() throws IOException {
        when(mockPauseMenu.isSelectedResume()).thenReturn(true);

        pauseMenuController.step(mockGame, GUI.ACTION.SELECT, 100);

        verify(mockGame).setState(ArgumentMatchers.any());
    }

    @Test
    void testStepSelectRestart() throws IOException {
        when(mockPauseMenu.isSelectedRestart()).thenReturn(true);

        pauseMenuController.step(mockGame, GUI.ACTION.SELECT, 100);

        verify(mockGame).setState(ArgumentMatchers.any(GameState.class));
    }

    @Test
    void testStepSelectMenu() throws IOException {
        when(mockPauseMenu.isSelectedMenu()).thenReturn(true);

        pauseMenuController.step(mockGame, GUI.ACTION.SELECT, 100);

        verify(mockGame).setState(ArgumentMatchers.any(MenuState.class));
    }

    @Test
    void testStepSelectExit() throws IOException {
        when(mockPauseMenu.isSelectedExit()).thenReturn(true);

        pauseMenuController.step(mockGame, GUI.ACTION.SELECT, 100);

        verify(mockGame).setState(null);
    }
}
