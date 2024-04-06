package org.example.view.game;

import org.example.view.gui.GUI;
import org.example.model.game.elements.Enemy;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void draw(Enemy enemy, GUI gui) {

        gui.drawGameElement(enemy.getPosition().getX(), enemy.getPosition().getY(), 'E', "#dc143c");
    }
}
