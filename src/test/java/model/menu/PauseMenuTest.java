package model.menu;

import org.example.model.menu.PauseMenu;
import org.example.state.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PauseMenuTest {
    PauseMenu pausemenu;
    State state;

    @BeforeEach
    void setUp() { pausemenu = new PauseMenu(state); }

    @Test
    void NextChoice() {
        pausemenu.nextChoice();;
        assertEquals(2, pausemenu.getCurrentChoice());
        pausemenu.nextChoice();
        assertEquals(1, pausemenu.getCurrentChoice());
        pausemenu.nextChoice();
        assertEquals(0, pausemenu.getCurrentChoice());
    }

    @Test
    void PreviousChoice() {
        pausemenu.previousChoice();
        assertEquals(2, pausemenu.getCurrentChoice());
        pausemenu.previousChoice();
        assertEquals(1, pausemenu.getCurrentChoice());
        pausemenu.previousChoice();
        assertEquals(0, pausemenu.getCurrentChoice());
    }

    @Test
    void GetCurrentChoice() { assertEquals(0, pausemenu.getCurrentChoice()); }

    @Test
    void GetChoice() {
        assertEquals("Resume", pausemenu.getChoice(0));
        assertEquals("Restart", pausemenu.getChoice(1));
        assertEquals("Main Menu", pausemenu.getChoice(2));
        assertEquals("Exit", pausemenu.getChoice(3));
    }

    @Test
    void IsSelected() {
        Assertions.assertTrue(pausemenu.isSelected(0));
        Assertions.assertFalse(pausemenu.isSelected(1));
        Assertions.assertFalse(pausemenu.isSelected(2));
        Assertions.assertFalse(pausemenu.isSelected(3));
    }

    @Test
    void IsSelectedResume() { Assertions.assertTrue(pausemenu.isSelected(0)); }

    @Test
    void IsSelectedRestart() { Assertions.assertFalse(pausemenu.isSelected(1)); }

    @Test
    void IsSelectedMenu() { Assertions.assertFalse(pausemenu.isSelected(2)); }

    @Test
    void IsSelectedExit() { Assertions.assertFalse(pausemenu.isSelected(3)); }

    @Test
    void GetNumberOfChoices() { assertEquals(4, pausemenu.getNumberOfChoices()); }


}
