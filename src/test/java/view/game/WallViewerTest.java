package view.game;

import org.example.view.game.WallViewer;
import org.example.model.Position;
import org.example.model.game.elements.Wall;
import org.example.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class WallViewerTest {

    private GUI mockGui;
    private Wall mockWall;
    private WallViewer wallViewer;

    @BeforeEach
    void setUp() {
        mockGui = mock(GUI.class);
        mockWall = mock(Wall.class);
        wallViewer = new WallViewer();
    }

    @Test
    void testDraw() {
        // Stubbing the behavior of the Wall object
        when(mockWall.getPosition()).thenReturn(new Position(2, 3));

        // Performing the method to be tested
        wallViewer.draw(mockWall, mockGui);

        // Verifying the interactions with the GUI
        verify(mockGui).drawGameElement(2, 3, '[', "#808080");
        verify(mockGui).drawGameElement(3, 3, ']', "#808080");
    }
}
