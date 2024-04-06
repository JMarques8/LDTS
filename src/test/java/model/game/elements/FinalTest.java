package model.game.elements;

import org.example.model.game.elements.Final;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FinalTest {

    @Test
    public void testFinalCreation() {
        Final fin = new Final(3, 5);
        assertEquals(3, fin.getPosition().getX());
        assertEquals(5, fin.getPosition().getY());
    }
}
