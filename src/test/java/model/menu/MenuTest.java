package model.menu;

import org.example.model.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {
    Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void NextChoice() {
        menu.nextChoice();;
        assertEquals(2, menu.getCurrentChoice());
        menu.nextChoice();
        assertEquals(1, menu.getCurrentChoice());
        menu.nextChoice();
        assertEquals(0, menu.getCurrentChoice());
    }

    @Test
    void PreviousChoice() {
        menu.previousChoice();
        assertEquals(2, menu.getCurrentChoice());
        menu.previousChoice();
        assertEquals(1, menu.getCurrentChoice());
        menu.previousChoice();
        assertEquals(0, menu.getCurrentChoice());
    }

    @Test
    void GetCurrentChoice() { assertEquals(0, menu.getCurrentChoice()); }

    @Test
    void GetChoice() {
        assertEquals("Start", menu.getChoice(0));
        assertEquals("Instructions", menu.getChoice(1));
        assertEquals("Exit", menu.getChoice(2));
    }

    @Test
    void IsSelected() {
        Assertions.assertTrue(menu.isSelected(0));
        Assertions.assertFalse(menu.isSelected(1));
        Assertions.assertFalse(menu.isSelected(2));
    }

    @Test
    void IsSelectedStart() {
        Assertions.assertTrue(menu.isSelected(0));
    }

    @Test
    void IsSelectedInstructions() { Assertions.assertFalse(menu.isSelected(1)); }

    @Test
    void isSelectedExit() {
        Assertions.assertFalse(menu.isSelected(2));
    }

    @Test
    void getNumberOfChoices() { assertEquals(3, menu.getNumberOfChoices()); }
}
