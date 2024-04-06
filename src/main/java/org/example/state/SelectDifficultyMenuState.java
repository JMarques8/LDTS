package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.SelectDifficultyMenuController;
import org.example.model.menu.Menu;
import org.example.model.menu.SelectDifficultyMenu;
import org.example.view.Viewer;
import org.example.view.menu.MenuViewer;
import org.example.view.menu.SelectDifficultyMenuViewer;

public class SelectDifficultyMenuState extends State<SelectDifficultyMenu> {
    public SelectDifficultyMenuState(SelectDifficultyMenu model) {
        super(model);
    }

    @Override
    protected Viewer<SelectDifficultyMenu> getViewer() {
        return new SelectDifficultyMenuViewer(getModel());
    }

    @Override
    protected Controller<SelectDifficultyMenu> getController() {
        return new SelectDifficultyMenuController(getModel());
    }
}