package org.example.controller.game;

import org.example.Game;
import org.example.model.menu.GameOver;
import org.example.state.GameOverState;
import org.example.view.gui.GUI;
import org.example.model.Position;
import org.example.model.game.elements.Enemy;
import org.example.model.game.map.Map;

import java.util.Random;

public class EnemyController extends GameController {

    private static final Random RANDOM = new Random();

    public EnemyController(Map map) {
        super(map);
    }

    public void moveEnemy(Enemy enemy, Game game) {
        Position currentPosition = enemy.getPosition();
        Position newPosition;

        switch (enemy.getDirection()) {
            case 0:
                newPosition = currentPosition.goUp();
                break;
            case 1:
                newPosition = currentPosition.goRight();
                break;
            case 2:
                newPosition = currentPosition.goDown();
                break;
            case 3:
                newPosition = currentPosition.goLeft();
                break;
            default:
                newPosition = currentPosition;
        }

        boolean hitWall = getModel().isWall(newPosition);

        if (hitWall) {
            int newDirection = RANDOM.nextInt(4); // 0: UP, 1: RIGHT, 2: DOWN, 3: LEFT
            enemy.setDirection(newDirection);

            // Tenta mover na nova direção
            switch (newDirection) {
                case 0:
                    newPosition = currentPosition.goUp();
                    break;
                case 1:
                    newPosition = currentPosition.goRight();
                    break;
                case 2:
                    newPosition = currentPosition.goDown();
                    break;
                case 3:
                    newPosition = currentPosition.goLeft();
                    break;
                default:
                    newPosition = currentPosition;
            }
        }

        if (!getModel().isWall(newPosition)) {
            enemy.setPosition(newPosition);
        }

        if (getModel().getMiner().getPosition().equals(enemy.getPosition())) {

            getModel().getMiner().decreaseLives();
            if (getModel().getMiner().getLives() <= 0) {
                game.setState(new GameOverState(new GameOver()));
            }
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        for (Enemy enemy : getModel().getEnemies()) {
            moveEnemy(enemy, game);
        }
    }
}
