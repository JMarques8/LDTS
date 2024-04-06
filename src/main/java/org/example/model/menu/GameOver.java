package org.example.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOver {

    private final List<String> choices;

    private int currentChoice = 0;

    public GameOver() { this.choices = Arrays.asList("Restart Game", "Return to Main Menu", "Quit"); }

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

    public int getCurrentChoice() {
        return currentChoice;
    }

    public String getChoice(int i) {
        return choices.get(i);
    }

    public boolean isSelected(int i) {
        return currentChoice == i;
    }

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public boolean isSelectedMenu() {
        return isSelected(1);
    }

    public boolean isSelectedExit() { return isSelected(2); }

    public int getNumberOfChoices() {
        return this.choices.size();
    }
}


