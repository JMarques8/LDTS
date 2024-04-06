package org.example.view.game;

import org.example.view.gui.GUI;
import org.example.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall>{
    @Override
    public void draw(Wall wall, GUI gui) {

        gui.drawGameElementWall(wall.getPosition().getX(), wall.getPosition().getY(), '[', "#808080");
        gui.drawGameElementWall(wall.getPosition().getX() + 1, wall.getPosition().getY(), ']', "#808080");
    }
}
