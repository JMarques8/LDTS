package org.example.view.menu;

import org.example.view.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.PauseMenu;
import org.example.view.Viewer;

public class PauseMenuViewer extends Viewer<PauseMenu>{
    public PauseMenuViewer(PauseMenu pausemenu) { super(pausemenu); }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5,5), "GAME PAUSED","#FF0000");

        for(int i=0; i < getModel().getNumberOfChoices(); i++)
            gui.drawText(
                    new Position(5,7+i),
                    getModel().getChoice(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
