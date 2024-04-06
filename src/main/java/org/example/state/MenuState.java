package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.MenuController;
import org.example.model.menu.Menu;
import org.example.util.SoundPlayer;
import org.example.view.Viewer;
import org.example.view.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
        SoundPlayer.playBackground("src/main/resources/sounds/startmenu.wav");
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }

}
