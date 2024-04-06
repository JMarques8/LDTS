package controller.menu;

import org.example.Game;
import org.example.controller.menu.MenuController;
import org.example.state.InstructionsState;
import org.example.state.SelectDifficultyMenuState;
import org.example.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuControllerTest {

    @Mock
    private Game mockGame;

    @Mock
    private GUI mockGUI;

    @InjectMocks
    private MenuController menuController;

    @BeforeEach
    void setUp() {
        mockGUI = mock(GUI.class);
    }

    @Test
    void testStepSelectExit() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(menuController.getModel().isSelectedExit()).thenReturn(true);

        menuController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGame).setState(ArgumentMatchers.isNull());
    }

    @Test
    void testStepSelectStart() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(menuController.getModel().isSelectedStart()).thenReturn(true);

        menuController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGame).setState(ArgumentMatchers.isA(SelectDifficultyMenuState.class));
    }

    @Test
    void testStepSelectInstructions() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        when(menuController.getModel().isSelectedInstructions()).thenReturn(true);

        menuController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGame).setState(ArgumentMatchers.isA(InstructionsState.class));
    }

}