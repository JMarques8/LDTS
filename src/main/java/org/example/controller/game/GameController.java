package org.example.controller.game;

import org.example.controller.Controller;
import org.example.model.game.map.Map;

public abstract class GameController extends Controller<Map> {
    public GameController(Map model) {
        super(model);
    }
}
