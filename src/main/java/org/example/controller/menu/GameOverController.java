package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.view.gui.GUI;
import org.example.model.menu.Menu;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.state.MenuState;
import org.example.state.GameState;
import org.example.model.menu.GameOver;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameover) { super(gameover); }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousChoice();
                break;
            case DOWN:
                getModel().nextChoice();
                break;
            case SELECT:
                if (getModel().isSelectedRestart()) game.setState(new GameState(new LoaderMapBuilder(1).createMap()));
                if (getModel().isSelectedMenu()) game.setState(new MenuState(new Menu()));
                if (getModel().isSelectedExit()) game.setState(null);
        }
    }

}
