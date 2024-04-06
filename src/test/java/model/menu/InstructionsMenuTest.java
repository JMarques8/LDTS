package model.menu;

import org.example.model.menu.InstructionsMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsMenuTest {
    InstructionsMenu instructionsMenu;

    @BeforeEach
    void setUp() { instructionsMenu = new InstructionsMenu(); }

    @Test
    void nextInstruction() {
        instructionsMenu.nextInstruction();
        assertEquals(0, instructionsMenu.getCurrentInstruction());
    }

    @Test
    void previousInstruction() {
        instructionsMenu.previousInstruction();
        assertEquals(0, instructionsMenu.getCurrentInstruction());
    }

    @Test
    void GetCurrentInstruction() { assertEquals(0, instructionsMenu.getCurrentInstruction()); }

    @Test
    void GetInstruction() {
        assertEquals("Back", instructionsMenu.getInstruction(0));
    }

    @Test
    void IsSelected() { Assertions.assertTrue(instructionsMenu.isSelected(0)); }

    @Test
    void GetNumberOfInstructions() { assertEquals(1, instructionsMenu.getNumberOfInstructions()); }
}
