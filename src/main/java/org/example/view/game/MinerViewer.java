package org.example.view.game;

import org.example.view.gui.GUI;
import org.example.model.game.elements.Miner;

public class MinerViewer implements ElementViewer<Miner> {
    @Override
    public void draw(Miner miner, GUI gui) {

        gui.drawGameElement(miner.getPosition().getX(), miner.getPosition().getY(), 'M', "#228b22");
    }
}
