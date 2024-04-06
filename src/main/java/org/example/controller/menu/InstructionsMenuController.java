package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.state.MenuState;
import org.example.model.menu.Menu;
import org.example.view.gui.GUI;
import org.example.model.menu.InstructionsMenu;

import java.io.IOException;

public class InstructionsMenuController extends Controller<InstructionsMenu> {
    public InstructionsMenuController(InstructionsMenu menu) {
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
                game.setState(new MenuState(new Menu()));
                break;
        }
    }
}
