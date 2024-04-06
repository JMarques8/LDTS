package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.GameOverController;
import org.example.model.menu.GameOver;
import org.example.util.SoundPlayer;
import org.example.view.Viewer;
import org.example.view.menu.GameOverViewer;

public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver gameover) {
        super(gameover);
        SoundPlayer.stopBackground();
        SoundPlayer.play("src/main/resources/sounds/gameOver.wav");
    }

    @Override
    protected Viewer<GameOver> getViewer() { return new GameOverViewer(getModel()); }

    @Override
    protected Controller<GameOver> getController() { return new GameOverController(getModel()); }
}
