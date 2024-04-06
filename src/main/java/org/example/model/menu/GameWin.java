package org.example.model.menu;

import java.util.Arrays;
import java.util.List;

import org.example.Game;
import org.example.model.game.elements.Miner;
import org.example.controller.game.MinerController;

public class GameWin {

    private final List<String> choices;
    private Game game;

    private int currentChoice = 0;

    public GameWin(Game game) {
        this.choices = Arrays.asList("Next Level", "Restart Game", "Return to Main Menu", "Quit");
        this.game = game;
    }

    public void nextChoice() {
        currentChoice++;

        if(currentChoice > this.choices.size() - 1) {
            currentChoice = 0;
        }
    }

    public void previousChoice() {
        currentChoice--;
        if(currentChoice < 0) {
            currentChoice = this.choices.size() - 1;
        }
    }

    public int getCurrentChoice() { return currentChoice; }

    public String getChoice(int i) { return choices.get(i); }

    public boolean isSelected(int i) { return currentChoice == i; }

    public boolean isSelectedNextLevel() { return isSelected(0); }

    public boolean isSelectedRestart() { return isSelected(1); }

    public boolean isSelectedMenu() { return isSelected(2); }

    public boolean isSelectedExit() { return isSelected(3); }

    public int getNumberOfChoices() { return this.choices.size(); }

    public int getCoinsCollected() { return game.getCoinsCollected(); }

    public int getTime() { return game.getTime(); }
}
