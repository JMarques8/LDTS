package controller.menu;

import org.example.Game;
import org.example.controller.menu.SelectDifficultyMenuController;
import org.example.model.menu.SelectDifficultyMenu;
import org.example.state.GameState;
import org.example.state.MenuState;
import org.example.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class SelectDifficultyMenuControllerTest {

    @Mock
    private SelectDifficultyMenu mockSelectDifficultyMenu;

    @Mock
    private Game mockGame;

    private SelectDifficultyMenuController selectDifficultyMenuController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        selectDifficultyMenuController = new SelectDifficultyMenuController(mockSelectDifficultyMenu);
    }

    @Test
    void testStepUp() throws IOException {
        when(mockSelectDifficultyMenu.isSelectedBack()).thenReturn(true);

        selectDifficultyMenuController.step(mockGame, GUI.ACTION.UP, 100);

        verify(mockSelectDifficultyMenu).previousInstruction();
    }

    @Test
    void testStepDown() throws IOException {
        when(mockSelectDifficultyMenu.isSelectedBack()).thenReturn(true);

        selectDifficultyMenuController.step(mockGame, GUI.ACTION.DOWN, 100);

        verify(mockSelectDifficultyMenu).nextInstruction();
    }

    @Test
    void testStepSelectBack() throws IOException {
        when(mockSelectDifficultyMenu.isSelectedBack()).thenReturn(true);

        selectDifficultyMenuController.step(mockGame, GUI.ACTION.SELECT, 100);

        verify(mockGame).setState(any(MenuState.class));
    }

    @Test
    void testStepSelectEasy() throws IOException {
        when(mockSelectDifficultyMenu.isSelectedEasy()).thenReturn(true);

        selectDifficultyMenuController.step(mockGame, GUI.ACTION.SELECT, 100);

        verify(mockGame).setState(any(GameState.class));
    }

    @Test
    void testStepSelectMedium() throws IOException {
        when(mockSelectDifficultyMenu.isSelectedMedium()).thenReturn(true);

        selectDifficultyMenuController.step(mockGame, GUI.ACTION.SELECT, 100);

        verify(mockGame).setState(any(GameState.class));
    }

    @Test
    void testStepSelectHard() throws IOException {
        when(mockSelectDifficultyMenu.isSelectedHard()).thenReturn(true);

        selectDifficultyMenuController.step(mockGame, GUI.ACTION.SELECT, 100);

        verify(mockGame).setState(any(GameState.class));
    }
}