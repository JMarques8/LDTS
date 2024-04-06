package view.menu;

import org.example.view.menu.MenuViewer;
import org.example.model.Position;
import org.example.model.menu.Menu;
import org.example.view.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MenuViewerTest {

    private GUI mockGui;
    private Menu mockMenu;
    private MenuViewer menuViewer;

    @BeforeEach
    void setUp() {
        mockGui = mock(GUI.class);
        mockMenu = mock(Menu.class);
        menuViewer = new MenuViewer(mockMenu);
    }

    @Test
    void testDrawElements() {
        // Stubbing the behavior of the Menu object
        when(mockMenu.getNumberOfChoices()).thenReturn(3);
        when(mockMenu.getChoice(0)).thenReturn("Option 1");
        when(mockMenu.getChoice(1)).thenReturn("Option 2");
        when(mockMenu.getChoice(2)).thenReturn("Option 3");
        when(mockMenu.isSelected(0)).thenReturn(true);
        when(mockMenu.isSelected(1)).thenReturn(false);
        when(mockMenu.isSelected(2)).thenReturn(false);

        // Performing the method to be tested
        menuViewer.drawElements(mockGui);

        // Verifying the interactions with the GUI
        verify(mockGui).drawText(new Position(5, 5), "Gold Miner Joel Menu", "#0000FF");
        verify(mockGui).drawText(new Position(5, 7), "Option 1", "#FFD700");
        verify(mockGui).drawText(new Position(5, 8), "Option 2", "#FFFFFF");
        verify(mockGui).drawText(new Position(5, 9), "Option 3", "#FFFFFF");
    }
}
