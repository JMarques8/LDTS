package model.game.elements;

import org.example.model.Position;
import org.example.model.game.elements.Element;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    @Test
    void testGetPosition() {
        ElementUnderTest element = new ElementUnderTest(3, 5);
        assertEquals(new Position(3, 5), element.getPosition());
    }

    @Test
    void testSetPosition() {
        ElementUnderTest element = new ElementUnderTest(1, 2);
        element.setPosition(new Position(4, 6));
        assertEquals(new Position(4, 6), element.getPosition());
    }

    @Test
    void testCollision() {
        ElementUnderTest element1 = new ElementUnderTest(2, 3);
        ElementUnderTest element2 = new ElementUnderTest(2, 3);
        ElementUnderTest element3 = new ElementUnderTest(4, 6);

        assertTrue(element1.collision(element2));
        assertFalse(element1.collision(element3));
    }

    private static class ElementUnderTest extends Element {
        public ElementUnderTest(int x, int y) {
            super(x, y);
        }
    }
}
