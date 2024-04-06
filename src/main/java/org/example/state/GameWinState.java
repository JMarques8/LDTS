package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.GameWinController;
import org.example.model.menu.GameWin;
import org.example.view.Viewer;
import org.example.view.menu.GameWinViewer;

public class GameWinState extends State<GameWin> {
    public GameWinState(GameWin gamewin) {
        super(gamewin);
    }

    @Override
    protected Viewer<GameWin> getViewer() { return new GameWinViewer(getModel()); }

    @Override
    protected Controller<GameWin> getController() { return new GameWinController(getModel()); }
}
