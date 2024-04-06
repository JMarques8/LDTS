package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.InstructionsMenuController;
import org.example.model.menu.InstructionsMenu;
import org.example.view.Viewer;
import org.example.view.menu.InstructionsMenuViewer;

public class InstructionsState extends State<InstructionsMenu> {
    public InstructionsState(InstructionsMenu model) {
        super(model);
    }

    @Override
    protected Viewer<InstructionsMenu> getViewer() {
        return new InstructionsMenuViewer(getModel());
    }

    @Override
    protected Controller<InstructionsMenu> getController() {
        return new InstructionsMenuController(getModel());
    }
}
