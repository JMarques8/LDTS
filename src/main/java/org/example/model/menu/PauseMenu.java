package org.example.model.menu;

import java.util.List;
import java.util.Arrays;
import org.example.state.State;

public class PauseMenu{
    private final List<String> choices;
    private State state;

    private int currentChoice = 0;
    public PauseMenu(State state) {
        this.choices = Arrays.asList("Resume", "Restart", "Main Menu", "Exit");
        this.state = state;
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

    public boolean isSelectedResume() { return isSelected(0); }

    public boolean isSelectedRestart() { return isSelected(1); }

    public boolean isSelectedMenu() { return isSelected(2); }

    public boolean isSelectedExit() { return isSelected(3); }

    public int getNumberOfChoices() { return this.choices.size(); }

    public State getState() { return this.state; }

}
