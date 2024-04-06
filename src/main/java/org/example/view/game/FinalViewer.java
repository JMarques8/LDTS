package org.example.view.game;

import org.example.model.game.elements.Final;
import org.example.view.gui.GUI;

public class FinalViewer implements ElementViewer<Final> {
    @Override
    public void draw(Final enemy, GUI gui) {

        gui.drawGameElement(enemy.getPosition().getX(), enemy.getPosition().getY(), 'F', "#0546fa");
    }
}