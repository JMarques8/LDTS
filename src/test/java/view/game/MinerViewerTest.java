package view.game;

import org.example.view.gui.GUI;
import org.example.model.game.elements.Miner;
import org.example.view.game.MinerViewer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MinerViewerTest {

    @Test
    public void testDrawMiner() {
        Miner miner = new Miner(2, 3);
        miner.setScore(5);

        GUI mockGui = mock(GUI.class);

        MinerViewer minerViewer = new MinerViewer();
        minerViewer.draw(miner, mockGui);

        verify(mockGui, times(1)).drawGameElement(2, 3, 'M', "#228b22"); //verificar parametros certos

        verifyNoMoreInteractions(mockGui);
    }
}
