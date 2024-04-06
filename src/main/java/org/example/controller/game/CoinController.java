package org.example.controller.game;

import org.example.Game;
import org.example.model.game.elements.Coin;
import org.example.model.game.elements.Miner;
import org.example.model.menu.GameOver;
import org.example.state.GameOverState;
import org.example.util.SoundPlayer;
import org.example.view.gui.GUI;
import org.example.model.Position;
import org.example.model.game.elements.Enemy;
import org.example.model.game.map.Map;

import java.util.Random;

public class CoinController {

    private final Map map;
    private final Game game;


    public CoinController(Map map, Game game) {
        this.map = map;
        this.game = game;
    }
    
    public void handleCollision(Miner miner) {

        for (Coin coin : map.getCoins()) {
            // verificar colisao com o miner
            if (coin.collidesWithMiner(miner)) {
                //remover a moeda do mapa
                map.removeCoin(coin);
                game.increaseCoinsCollected();
                SoundPlayer.play("src/main/resources/sounds/coinSound.wav");
                //contador de coins
                miner.increaseCoins();
                break;
            }
        }
    }
}
