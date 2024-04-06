package org.example.view.menu;

import org.example.view.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.Menu;
import org.example.view.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {

        //remove this
        gui.drawText(new Position(5, 5), "GOLD MINER JOEL MENU", "#0000FF");


        for (int i = 0; i < getModel().getNumberOfChoices(); i++)
            gui.drawText(
                    //add this new Position(16, 18 + i)
                    new Position(5, 7 + i),
                    getModel().getChoice(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
