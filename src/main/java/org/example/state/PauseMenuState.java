package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.PauseMenuController;
import org.example.model.menu.PauseMenu;
import org.example.view.Viewer;
import org.example.view.menu.PauseMenuViewer;

public class PauseMenuState extends State<PauseMenu> {
    public PauseMenuState(PauseMenu pausemenu) { super(pausemenu); }

    @Override
    protected Viewer<PauseMenu> getViewer() { return new PauseMenuViewer(getModel()); }

    @Override
    protected Controller<PauseMenu> getController() { return new PauseMenuController(getModel()); }
}
