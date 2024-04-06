package org.example.view.menu;

import org.example.view.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.InstructionsMenu;
import org.example.view.Viewer;

import java.io.IOException;

public class InstructionsMenuViewer extends Viewer<InstructionsMenu> {

    public InstructionsMenuViewer(InstructionsMenu instructionsMenu) {
        super(instructionsMenu);
    }

    @Override
    protected void drawElements(GUI gui) {

        gui.drawText(new Position(5, 10), "Use the arrows to move around the maze. The goal of the ", "#d3d3d3");
        gui.drawText(new Position(5, 12), "game is to leave the mine as fast as possible and", "#d3d3d3");
        gui.drawText(new Position(5, 14), "with as much gold as you can! Choose your path wisely ", "#d3d3d3");
        gui.drawText(new Position(5, 16), "and avoid the moving explosives, since you only have", "#d3d3d3");
        gui.drawText(new Position(5, 18), "3 lives, and you lose lives each time you hit an explosive.", "#d3d3d3");
        gui.drawText(new Position(5, 20), "Score is based on how much time it takes to finish the maze.", "#d3d3d3");


        for (int i = 0; i < getModel().getNumberOfInstructions(); i++) {
            gui.drawText(
                    new Position(2, 3 + i),
                    getModel().getInstruction(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF"
            );
        }
    }
}
