package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.model.menu.InstructionsMenu;
import org.example.model.menu.Menu;
import org.example.model.menu.SelectDifficultyMenu;
import org.example.state.GameState;
import org.example.state.MenuState;
import org.example.view.gui.GUI;

import java.io.IOException;

public class SelectDifficultyMenuController extends Controller<SelectDifficultyMenu> {
    public SelectDifficultyMenuController(SelectDifficultyMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousInstruction();
                break;
            case DOWN:
                getModel().nextInstruction();
                break;
            case SELECT:
                if(getModel().isSelectedBack()){
                    game.setState(new MenuState(new Menu()));
                } else if (getModel().isSelectedEasy()) {
                    game.setState(new GameState(new LoaderMapBuilder(1).createMap()));
                }
                else if (getModel().isSelectedMedium()) {
                    game.setState(new GameState(new LoaderMapBuilder(2).createMap()));
                }
                else if (getModel().isSelectedHard()) {
                    game.setState(new GameState(new LoaderMapBuilder(3).createMap()));
                }
                break;
        }
    }
}