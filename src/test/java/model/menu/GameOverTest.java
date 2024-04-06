package model.menu;

import org.example.model.menu.GameOver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverTest {
    GameOver gameOver;

    @BeforeEach
    void setUp() { gameOver = new GameOver(); }

    @Test
    void NextChoice() {
        gameOver.nextChoice();;
        assertEquals(2, gameOver.getCurrentChoice());
        gameOver.nextChoice();
        assertEquals(1, gameOver.getCurrentChoice());
        gameOver.nextChoice();
        assertEquals(0, gameOver.getCurrentChoice());
    }

    @Test
    void PreviousChoice() {
        gameOver.previousChoice();
        assertEquals(2, gameOver.getCurrentChoice());
        gameOver.previousChoice();
        assertEquals(1, gameOver.getCurrentChoice());
        gameOver.previousChoice();
        assertEquals(0, gameOver.getCurrentChoice());
    }

    @Test
    void GetCurrentChoice() { assertEquals(0, gameOver.getCurrentChoice()); }

    @Test
    void GetChoice() {
        assertEquals("Restart Game", gameOver.getChoice(0));
        assertEquals("Return to Main Menu", gameOver.getChoice(1));
        assertEquals("Quit", gameOver.getChoice(2));
    }

    @Test
    void IsSelected() {
        Assertions.assertTrue(gameOver.isSelected(0));
        Assertions.assertFalse(gameOver.isSelected(1));
        Assertions.assertFalse(gameOver.isSelected(2));
    }

    @Test
    void IsSelectedRestart() {
        Assertions.assertTrue(gameOver.isSelected(0));
    }

    @Test
    void IsSelectedMenu() {
        Assertions.assertFalse(gameOver.isSelected(1));
    }

    @Test
    void IsSelectedExit() {
        Assertions.assertFalse(gameOver.isSelected(2));
    }

    @Test
    void GetNumberOfChoices() { assertEquals(3, gameOver.getNumberOfChoices()); }

}
