package view.game;

import org.example.view.game.CoinViewer;
import org.example.model.Position;
import org.example.model.game.elements.Coin;
import org.example.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CoinViewerTest {

    private GUI mockGui;
    private Coin mockCoin;
    private CoinViewer coinViewer;

    @BeforeEach
    void setUp() {
        mockGui = mock(GUI.class);
        mockCoin = mock(Coin.class);
        coinViewer = new CoinViewer();
    }

    @Test
    void testDraw() {
        // Stubbing the behavior of the Coin object
        when(mockCoin.getPosition()).thenReturn(new Position(2, 3));

        // Performing the method to be tested
        coinViewer.draw(mockCoin, mockGui);

        // Verifying the interactions with the GUI
        verify(mockGui).drawGameElement(2, 3, 'o', "#FFFF00");
    }
}
