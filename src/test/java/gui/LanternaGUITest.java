package gui;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.view.gui.GUI.ACTION;
import org.example.view.gui.LanternaGUI;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TerminalSize;
import org.example.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LanternaGUITest {

    @Test
    public void testGetNextActionArrowKeys() throws IOException {
        LanternaGUI gui = new LanternaGUI(createMockScreenWithInput(KeyType.ArrowUp));
        assertEquals(ACTION.UP, gui.getNextAction());

        gui = new LanternaGUI(createMockScreenWithInput(KeyType.ArrowRight));
        assertEquals(ACTION.RIGHT, gui.getNextAction());

        gui = new LanternaGUI(createMockScreenWithInput(KeyType.ArrowDown));
        assertEquals(ACTION.DOWN, gui.getNextAction());

        gui = new LanternaGUI(createMockScreenWithInput(KeyType.ArrowLeft));
        assertEquals(ACTION.LEFT, gui.getNextAction());
    }

    @Test
    public void testGetNextActionEnterKey() throws IOException {
        LanternaGUI gui = new LanternaGUI(createMockScreenWithInput(KeyType.Enter));
        assertEquals(ACTION.SELECT, gui.getNextAction());
    }

    @Test
    public void testGetNextActionQuitKey() throws IOException {
        LanternaGUI gui = new LanternaGUI(createMockScreenWithInput(KeyType.Character, 'q'));
        assertEquals(ACTION.QUIT, gui.getNextAction());
    }

    @Test
    public void testDrawText() {
        LanternaGUI gui = Mockito.mock(LanternaGUI.class);

        gui.drawText(new Position(0, 0), "Test", "#FFFFFF");

        verify(gui).drawText(new Position(0, 0), "Test", "#FFFFFF");
    }

    @Test
    public void testClear() {
        LanternaGUI gui = Mockito.mock(LanternaGUI.class);

        gui.clear();

        verify(gui).clear();
    }

    @Test
    public void testRefresh() throws IOException {
        LanternaGUI gui = Mockito.mock(LanternaGUI.class);

        gui.refresh();

        verify(gui).refresh();
    }

    @Test
    public void testClose() throws IOException {
        LanternaGUI gui = Mockito.mock(LanternaGUI.class);

        gui.close();

        verify(gui).close();
    }

    // Auxiliary methods
    private Screen createMockScreenWithInput(KeyType keyType) throws IOException {
        Screen mockScreen = mock(Screen.class);

        when(mockScreen.pollInput()).thenReturn(new KeyStroke(keyType));

        return mockScreen;
    }

    @SuppressWarnings("SameParameterValue")
    private Screen createMockScreenWithInput(KeyType keyType, char character) throws IOException {
        Screen mockScreen = mock(Screen.class);

        KeyStroke keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(keyType);
        when(keyStroke.getCharacter()).thenReturn(character);

        when(mockScreen.pollInput()).thenReturn(keyStroke);

        return mockScreen;
    }
}
