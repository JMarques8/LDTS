package controller.menu;

import org.example.Game;
import org.example.controller.menu.InstructionsMenuController;
import org.example.model.menu.InstructionsMenu;
import org.example.model.menu.Menu;
import org.example.state.MenuState;
import org.example.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class InstructionsMenuControllerTest {

    @Mock
    private InstructionsMenu mockInstructionsMenu;

    @Mock
    private Game mockGame;

    @Mock
    private GUI mockGUI;

    private InstructionsMenuController instructionsMenuController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        instructionsMenuController = new InstructionsMenuController(mockInstructionsMenu);
    }

    @Test
    void testStepUp() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.UP);

        instructionsMenuController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockInstructionsMenu).previousInstruction();
    }

    @Test
    void testStepDown() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.DOWN);

        instructionsMenuController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockInstructionsMenu).nextInstruction();
    }

    @Test
    void testStepSelect() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.SELECT);

        MenuState expectedMenuState = new MenuState(new Menu());
        instructionsMenuController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGame).setState(ArgumentMatchers.isA(MenuState.class));
    }
}
