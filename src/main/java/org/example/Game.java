package org.example;

import org.example.model.menu.Menu;
import org.example.state.MenuState;
import org.example.state.State;
import org.example.view.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private int CoinsCollected;

    private int time = -1;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(75,32);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCoinsCollected() { return CoinsCollected; }

    public void increaseCoinsCollected() { CoinsCollected++; }

    public int getTime() { return time; }

    public void setTime(int time) { this.time = time; }

    public void increaseTime() { this.time += 1; }
    
    private void start() throws IOException {
        int FPS = 10;

        int frameTime = 1000 / FPS;

        while (this.state != null) {

            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;

            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}

