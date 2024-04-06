package model;

import org.example.model.Position;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Property
    void moveLeftTest(@ForAll int x, @ForAll int y) {
        assertEquals(x - 1, new Position(x, y).goLeft().getX());
        assertEquals(y, new Position(x, y).goLeft().getY());
    }
    @Property
    void moveRightTest(@ForAll int x, @ForAll int y) {
        assertEquals(x + 1, new Position(x, y).goRight().getX());
        assertEquals(y, new Position(x, y).goRight().getY());
    }

    @Property
    void moveUpTest(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).goUp().getX());
        assertEquals(y - 1, new Position(x, y).goUp().getY());
    }

    @Property
    void moveDownTest(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).goDown().getX());
        assertEquals(y + 1, new Position(x, y).goDown().getY());
    }
}
