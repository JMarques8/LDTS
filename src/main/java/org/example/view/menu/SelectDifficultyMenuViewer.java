package org.example.view.menu;

import org.example.view.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.SelectDifficultyMenu;
import org.example.view.Viewer;

public class SelectDifficultyMenuViewer extends Viewer<SelectDifficultyMenu> {
    public SelectDifficultyMenuViewer(SelectDifficultyMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "GOLD MINER JOEL MENU", "#0000FF");
        gui.drawText(new Position(5, 7), "SELECT DIFFICULTY", "#0000FF");

        // Back option
        gui.drawText(
                new Position(2, 3),
                getModel().getSelectDifficulty(0),  // Assuming 'Back' is at index 0
                getModel().isSelected(0) ? "#FFD700" : "#FFFFFF");

        // Options
        for (int i = 1; i < getModel().getNumberOfChoices(); i++)
            gui.drawText(
                    new Position(5, 9 + i),
                    getModel().getSelectDifficulty(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}

