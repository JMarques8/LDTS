package model.game.elements;

import org.example.model.game.elements.Wall;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WallTest {

    @Test
    public void testWallCreation() {
        Wall wall = new Wall(3, 5);
        assertEquals(3, wall.getPosition().getX());
        assertEquals(5, wall.getPosition().getY());
    }
}
