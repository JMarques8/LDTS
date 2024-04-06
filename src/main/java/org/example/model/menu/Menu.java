package org.example.model.menu;

import java.util.List;
import java.util.Arrays;

public class Menu {

    private final List<String> choices;

    private int currentChoice = 0;

    public Menu() {
        this.choices = Arrays.asList("Start", "Instructions", "Exit");
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

    public int getCurrentChoice() {
        return currentChoice;
    }

    public String getChoice(int i) {
        return choices.get(i);
    }

    public boolean isSelected(int i) {
        return currentChoice == i;
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedInstructions() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }

    public int getNumberOfChoices() {
        return this.choices.size();
    }

}
