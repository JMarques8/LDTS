package org.example.view.game;


import org.example.view.gui.GUI;
import org.example.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
