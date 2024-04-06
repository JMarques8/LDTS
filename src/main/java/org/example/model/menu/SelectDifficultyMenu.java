package org.example.model.menu;

import java.util.Arrays;
import java.util.List;


public class SelectDifficultyMenu {

    private final List<String> selectDifficulty;

    private int currentSelectDifficulty = 0;

    public SelectDifficultyMenu() {
        this.selectDifficulty = Arrays.asList(
                "Back",
                "Easy",
                "Medium",
                "Hard"
        );
    }

    public void nextInstruction() {
        currentSelectDifficulty++;

        if (currentSelectDifficulty > this.selectDifficulty.size() - 1) {
            currentSelectDifficulty = 0;
        }
    }

    public void previousInstruction() {
        currentSelectDifficulty--;
        if (currentSelectDifficulty < 0) {
            currentSelectDifficulty = this.selectDifficulty.size() - 1;
        }
    }

    public int getCurrentSelectDifficulty() {
        return currentSelectDifficulty;
    }

    public String getSelectDifficulty(int i) {
        return selectDifficulty.get(i);
    }

    public boolean isSelected(int i) {
        return currentSelectDifficulty == i;
    }

    public boolean isSelectedBack() {
        return isSelected(0);
    }

    public boolean isSelectedEasy() {
        return isSelected(1);
    }

    public boolean isSelectedMedium() {
        return isSelected(2);
    }

    public boolean isSelectedHard() {
        return isSelected(3);
    }



    public int getNumberOfChoices() {
        return this.selectDifficulty.size();
    }

}