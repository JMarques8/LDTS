package org.example.controller.game;

import org.example.Game;
import org.example.model.menu.PauseMenu;
import org.example.state.PauseMenuState;
import org.example.view.gui.GUI;
import org.example.model.menu.PauseMenu;
import org.example.model.game.map.Map;

import java.io.IOException;

public class MapController extends GameController {

    private final MinerController minerController;
    private final EnemyController enemyController;


    public MapController(Map map) {
        super(map);
        this.minerController = new MinerController(map);
        this.enemyController = new EnemyController(map);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            game.setState(null);
        } else if (action == GUI.ACTION.PAUSE) {
            game.setState(new PauseMenuState(new PauseMenu(game.getState())));
        } else {
            minerController.step(game, action, time);
            enemyController.step(game, action, time);
        }
    }
}
