package org.example.view.game;

import org.example.view.gui.GUI;
import org.example.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin> {

    @Override
    public void draw(Coin coin, GUI gui) {

        gui.drawGameElement(coin.getPosition().getX(), coin.getPosition().getY(), 'o', "#FFFF00");
    }
}
