package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.model.menu.SelectDifficultyMenu;
import org.example.state.InstructionsState;
import org.example.state.SelectDifficultyMenuState;
import org.example.util.SoundPlayer;
import org.example.view.gui.GUI;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.state.GameState;
import org.example.model.menu.Menu;
import org.example.model.menu.InstructionsMenu;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

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
                if (getModel().isSelectedExit()) {
                    game.setState(null);
                } else if (getModel().isSelectedStart()) {
                    game.setState(new SelectDifficultyMenuState(new SelectDifficultyMenu()));
                } else if (getModel().isSelectedInstructions()) {
                    game.setState(new InstructionsState(new InstructionsMenu()));
                }
                break;
        }
    }
}
