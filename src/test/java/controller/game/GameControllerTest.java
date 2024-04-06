package controller.game;

import org.example.Game;
import org.example.controller.Controller;
import org.example.controller.game.GameController;
import org.example.model.game.map.Map;
import org.example.view.gui.GUI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {

    @Test
    void constructorShouldSetModel() {
        // Arrange
        Map map = new Map(10,10);

        // Act
        GameController gameController = new TestGameController(map);

        // Assert
        assertEquals(map, gameController.getModel());
    }

    @Test
    void shouldExtendController() {

        GameController gameController = new TestGameController(new Map(10,10));


        assertInstanceOf(Controller.class, gameController);
    }

    private static class TestGameController extends GameController {
        public TestGameController(Map model) {
            super(model);
        }

        @Override
        public void step(Game game, GUI.ACTION action, long time) {
        }
    }
}
