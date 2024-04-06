package controller.game;

import org.example.Game;
import org.example.controller.game.MinerController;
import org.example.model.game.map.Map;
import org.example.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MinerControllerTest {

    @Mock
    private Map mockMap;

    @Mock
    private Game mockGame;

    private MinerController minerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        minerController = new MinerController(mockMap);
    }

    @Test
    void testMoveMinerUp() throws IOException {
        minerController.moveMinerUp(mockGame);

        // Verifications
        verify(mockMap, times(2)).getMiner(); // Called in moveMinerUp and step
        verify(mockMap).isWall(any()); // Adjust based on your actual implementation
        verify(mockMap).isEnemy(any()); // Adjust based on your actual implementation
        verify(mockMap).isFinal(any()); // Adjust based on your actual implementation

        verify(mockMap.getMiner()).increaseTime();
    }

    @Test
    void testStep() throws IOException {
        minerController.step(mockGame, GUI.ACTION.UP, 100);

        verify(mockMap, times(2)).getMiner(); // Called in step and moveMinerUp
        verify(mockMap).isWall(any()); // Adjust based on your actual implementation
        verify(mockMap).isEnemy(any()); // Adjust based on your actual implementation
        verify(mockMap).isFinal(any()); // Adjust based on your actual implementation

        verify(mockMap.getMiner()).increaseTime();
    }

}
