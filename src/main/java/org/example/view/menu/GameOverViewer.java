package org.example.view.menu;

import org.example.view.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.GameOver;
import org.example.view.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver gameover) { super(gameover); }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5,5), "GAME OVER!","#FF0000");

        for(int i=0; i < getModel().getNumberOfChoices(); i++)
            gui.drawText(
                    new Position(5,7+i),
                    getModel().getChoice(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
