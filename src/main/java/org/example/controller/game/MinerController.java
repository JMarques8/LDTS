package org.example.controller.game;

import org.example.Game;
import org.example.model.menu.GameOver;
import org.example.state.GameOverState;
import org.example.model.menu.GameWin;
import org.example.state.GameWinState;
import org.example.state.GameState;
import org.example.state.MenuState;
import org.example.util.SoundPlayer;
import org.example.view.gui.GUI;
import org.example.model.Position;
import org.example.model.game.map.Map;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.Game;

import java.io.IOException;

public class MinerController extends GameController{
    private long helper;
    public MinerController(Map map) {
        super(map);
        this.helper = 0;
    }

    public static int level = 1;

    public static int getlevel(){
        return level;
    }

    public void moveMiner(Position position, Game game){
        if(!getModel().isWall(position)) {
            getModel().getMiner().setPosition(position);
        }
        if(getModel().isEnemy(position)) {
            //game over quando miner ficar sem vidas
            if (getModel().getMiner().getLives() <= 0) {
                //getModel().getMiner().setWin(0);
                game.setState(new GameOverState(new GameOver()));
            }
        }
        if(getModel().isFinal(position)) {
            SoundPlayer.stopBackground();
            if(level<4){
                level++;
            }
            SoundPlayer.play("src/main/resources/sounds/winner.wav");
            game.setState(new GameWinState(new GameWin(game)));
        }
    }
    public void moveMinerUp(Game game) {
        moveMiner(getModel().getMiner().getPosition().goUp(), game);
    }
    public void moveMinerDown(Game game) {
        moveMiner(getModel().getMiner().getPosition().goDown(), game);
    }
    public void moveMinerLeft(Game game) {
        moveMiner(getModel().getMiner().getPosition().goLeft(), game);
    }
    public void moveMinerRight(Game game) {
       moveMiner(getModel().getMiner().getPosition().goRight(), game);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.UP) moveMinerUp(game);
        if (action == GUI.ACTION.RIGHT) moveMinerRight(game);
        if (action == GUI.ACTION.DOWN) moveMinerDown(game);
        if (action == GUI.ACTION.LEFT) moveMinerLeft(game);
        if (time - helper >= 1000) {
            getModel().getMiner().increaseTime();
            game.increaseTime();
            this.helper = time;
        }

        CoinController coinController = new CoinController(getModel(),game);
        coinController.handleCollision(getModel().getMiner());
    }
}
