package model.menu;

import org.example.model.menu.SelectDifficultyMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SelectDifficultyMenuTest {
    SelectDifficultyMenu selectDifficultyMenu;

    @BeforeEach
    void setUp() { selectDifficultyMenu = new SelectDifficultyMenu(); }

    @Test
    void nextInstruction() {
        selectDifficultyMenu.nextInstruction();
        assertEquals(3, selectDifficultyMenu.getCurrentSelectDifficulty());
        selectDifficultyMenu.nextInstruction();
        assertEquals(2, selectDifficultyMenu.getCurrentSelectDifficulty());
        selectDifficultyMenu.nextInstruction();
        assertEquals(1, selectDifficultyMenu.getCurrentSelectDifficulty());
        selectDifficultyMenu.nextInstruction();
        assertEquals(0, selectDifficultyMenu.getCurrentSelectDifficulty());
    }

    @Test
    void previousInstruction() {
        selectDifficultyMenu.previousInstruction();
        assertEquals(3, selectDifficultyMenu.getCurrentSelectDifficulty());
        selectDifficultyMenu.previousInstruction();
        assertEquals(2, selectDifficultyMenu.getCurrentSelectDifficulty());
        selectDifficultyMenu.previousInstruction();
        assertEquals(1, selectDifficultyMenu.getCurrentSelectDifficulty());
        selectDifficultyMenu.previousInstruction();
        assertEquals(0, selectDifficultyMenu.getCurrentSelectDifficulty());
    }

    @Test
    void GetCurrentInstruction() { assertEquals(0, selectDifficultyMenu.getCurrentSelectDifficulty()); }

    @Test
    void GetInstruction() {
        assertEquals("Easy", selectDifficultyMenu.getSelectDifficulty(0));
        assertEquals("Medium", selectDifficultyMenu.getSelectDifficulty(1));
        assertEquals("Hard", selectDifficultyMenu.getSelectDifficulty(2));
        assertEquals("Back", selectDifficultyMenu.getSelectDifficulty(3));
    }

    @Test
    void IsSelected() {
        Assertions.assertTrue(selectDifficultyMenu.isSelected(0));
        Assertions.assertFalse(selectDifficultyMenu.isSelected(1));
        Assertions.assertFalse(selectDifficultyMenu.isSelected(2));
        Assertions.assertFalse(selectDifficultyMenu.isSelected(3));
    }

    @Test
    void IsSelectedEasy() { Assertions.assertTrue(selectDifficultyMenu.isSelected(0)); }

    @Test
    void IsSelectedMedium() { Assertions.assertFalse(selectDifficultyMenu.isSelected(1)); }

    @Test
    void IsSelectedHard() { Assertions.assertFalse(selectDifficultyMenu.isSelected(2)); }

    @Test
    void IsSelectedBack() { Assertions.assertFalse(selectDifficultyMenu.isSelected(3)); }

    @Test
    void GetNumberOfChoices() { assertEquals(4, selectDifficultyMenu.getNumberOfChoices()); }

}
