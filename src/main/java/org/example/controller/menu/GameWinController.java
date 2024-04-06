package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.view.gui.GUI;
import org.example.model.menu.Menu;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.state.MenuState;
import org.example.state.GameState;
import org.example.model.menu.GameWin;
import org.example.controller.game.MinerController;

import java.io.IOException;

public class GameWinController extends Controller<GameWin> {
    public GameWinController(GameWin gamewin) { super(gamewin); }

    int lvl = MinerController.getlevel();

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
                if (getModel().isSelectedNextLevel()){
                    if(lvl < 4){
                        game.setState(new GameState(new LoaderMapBuilder(lvl).createMap()));
                     }
                     else{
                        game.setState(new MenuState(new Menu()));
                     }
                }
                if (getModel().isSelectedRestart()) game.setState(new GameState(new LoaderMapBuilder(lvl).createMap()));
                if (getModel().isSelectedMenu()) game.setState(new MenuState(new Menu()));
                if (getModel().isSelectedExit()) game.setState(null);
        }
    }
}
