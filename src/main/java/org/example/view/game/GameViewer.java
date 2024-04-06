package org.example.view.game;

import org.example.Game;
import org.example.model.Position;
import org.example.view.gui.GUI;
import org.example.model.game.map.Map;
import org.example.model.game.elements.Element;
import org.example.view.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Map> {
    public GameViewer(Map map) {
        super(map);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.gameFrame();

        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getEnemies(), new EnemyViewer());
        drawElement(gui, getModel().getMiner(), new MinerViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElements(gui, getModel().getFinal(), new FinalViewer());

        gui.drawText(new Position(1,30), "Time: " + getModel().getMiner().getTime(), "#ffffff");
        gui.drawText(new Position(20,30), "Lives: "  + getModel().getMiner().getLives(), "#ffffff");
        gui.drawText(new Position(40,30), "Coins: " + getModel().getMiner().getCoinsCollected(), "#ffffff");


    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)

            drawElement(gui, element, viewer);
    }


    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
