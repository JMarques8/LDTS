package org.example.model.game.elements;

import org.example.model.Position;

public abstract class Element {
    private Position position;

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }
    public Position getPosition() {
        return this.position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public boolean collision(Element element) {
        return this.position.equals(element.getPosition());
    }

}
