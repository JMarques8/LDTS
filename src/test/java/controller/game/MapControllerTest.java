package controller.game;

import org.example.Game;
import org.example.controller.game.MapController;
import org.example.controller.game.MinerController;
import org.example.model.game.map.Map;
import org.example.state.PauseMenuState;
import org.example.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MapControllerTest {

    @Mock
    private Map mockMap;

    @Mock
    private Game mockGame;

    @Mock
    private GUI mockGUI;

    @Mock
    private MinerController mockMinerController;

    private MapController mapController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mapController = new MapController(mockMap);
    }

    @Test
    void testStepQuitAction() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.QUIT);

        mapController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGame).setState(null);
    }

    @Test
    void testStepPauseAction() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.PAUSE);

        mapController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGame).setState(any(PauseMenuState.class));
    }

    @Test
    void testStepOtherAction() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.LEFT);

        mapController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGame, never()).setState(null);
        verify(mockGame, never()).setState(any(PauseMenuState.class));
        verify(mockMap).getMiner(); // Adjust based on your actual implementation
        verify(mockMap).getEnemies(); // Adjust based on your actual implementation
    }

    @Test
    void testStepMoveLeftAction() throws IOException {
        when(mockGUI.getNextAction()).thenReturn(GUI.ACTION.LEFT);

        mapController.step(mockGame, mockGUI.getNextAction(), 100);

        verify(mockGame, never()).setState(null);
        verify(mockGame, never()).setState(any(PauseMenuState.class));
        verify(mockMinerController).step(eq(mockGame), eq(GUI.ACTION.LEFT), eq(100));
    }

}
