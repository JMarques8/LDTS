package org.example.model.game.elements;

import org.example.model.Position;

public class Enemy extends Element {

    private int direction;

    public Enemy(int x, int y) {
        super(x, y);
        this.direction = 0;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Position getStartPosition() {
        // Supondo que a posição inicial é a mesma da criação do inimigo
        return super.getPosition();
    }
}
