package org.example.view.menu;

import org.example.view.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.GameWin;
import org.example.view.Viewer;


public class GameWinViewer extends Viewer<GameWin> {
    public GameWinViewer(GameWin gamewin) { super(gamewin); }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5,5), "YOU HAVE WON THE GAME!","#0000FF");
        gui.drawText(new Position(7,9), "Score: " + getModel().getTime() ,"#FFFFFF");
        gui.drawText(new Position(7,11), "Coins: " + getModel().getCoinsCollected() ,"#FFFFFF");

        for(int i=0; i < getModel().getNumberOfChoices(); i++)
            gui.drawText(
                    new Position(5,15+i),
                    getModel().getChoice(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
