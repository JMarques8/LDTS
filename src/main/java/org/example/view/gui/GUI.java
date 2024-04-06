package org.example.view.gui;

import org.example.model.Position;

import java.io.IOException;

//ALL GOOD
public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawText(Position position, String text, String color);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

    void gameFrame();

    void drawGameElement(int x, int y, char c, String color);

    void drawGameElementWall(int x, int y, char c, String color);
    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, PAUSE}
}
