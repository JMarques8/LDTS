package org.example.model;

import java.util.Objects;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Position goLeft() {
        return new Position(x-1,y);
    }

    public Position goRight() {
        return new Position(x+1,y);
    }

    public Position goUp() {
        return new Position(x,y-1);
    }

    public Position goDown() {
        return new Position(x,y+1);
    }

    public int getX() { return x; }
    public int getY() { return y; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position p)) return false;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {

        //return Objects.hash(getX(), getY());
        return Objects.hash(x,y);
    }

}


