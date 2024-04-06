package model.game.map;

import org.example.model.game.map.LoaderMapBuilder;
import org.example.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LoaderMapBuilderTest {

    private LoaderMapBuilder loaderMapBuilder;

    @BeforeEach
    public void setUp() throws IOException {
        loaderMapBuilder = new LoaderMapBuilder(1);
    }

    @Test
    public void testCreateMap() {
        Map actualCreateMapResult = loaderMapBuilder.createMap();
        assertEquals(25, actualCreateMapResult.getHeight());
        assertEquals(28, actualCreateMapResult.getWidth());
        assertEquals(0, actualCreateMapResult.getCoins().size());
        assertEquals(0, actualCreateMapResult.getEnemies().size());
        assertEquals(0, actualCreateMapResult.getWalls().size());
        assertNull(actualCreateMapResult.getMiner());
        assertEquals(0, actualCreateMapResult.getFinal().size());
    }
}
