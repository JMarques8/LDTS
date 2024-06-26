package org.example.model.game.elements;

public class Coin extends Element {
    public Coin(int x, int y) {
        super(x, y);
    }

    public boolean collidesWithMiner(Miner miner) {
        return getPosition().equals(miner.getPosition());
    }
}
