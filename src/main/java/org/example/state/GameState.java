package org.example.state;


import org.example.controller.Controller;
import org.example.controller.game.MapController;
import org.example.model.game.map.Map;
import org.example.view.Viewer;
import org.example.view.game.GameViewer;

public class GameState extends State<Map> {
    public GameState(Map map) {
        super(map);
    }

    @Override
    protected Viewer<Map> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new MapController(getModel());
    }

}
