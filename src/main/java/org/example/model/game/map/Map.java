package org.example.model.game.map;

import org.example.model.Position;
import org.example.model.game.elements.*;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

//public class Arena
public class Map {
    private final int width;
    private final int height;

    private Miner miner;

    private List<Enemy> enemies;

    private List<Coin> coins;

    private List<Final> finals;

    private List<Wall> walls;

    //public Arena
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public Miner getMiner() { return miner; }

    public List<Enemy> getEnemies() { return enemies; }
    public List<Coin> getCoins() { return coins; }
    public List<Wall> getWalls() { return walls; }
    public List<Final> getFinal() {return finals; }

    public void setMiner(Miner miner) { this.miner = miner; }

    public void setEnemies(List<Enemy> enemies) { this.enemies = enemies; }
    public void setCoins(List<Coin> coins) { this.coins = coins; }

    public void setFinal(List<Final> finals) { this.finals = finals; }
    public void setWalls(List<Wall> walls) { this.walls = walls; }

    public boolean isWall(Position position) {
        for (Wall wall : walls) {
            Position wallPosition2 = new Position(wall.getPosition().getX()+1, wall.getPosition().getY());
            if (wall.getPosition().equals(position) || wallPosition2.equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEnemy(Position position) {
        for (Enemy enemy : enemies) {
            if (enemy.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCoin(Position position) {
        for (Coin coin : coins) {
            if (coin.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFinal(Position position) {
        for (Final finale : finals) {
            if (finale.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public void removeCoin(Coin coin) {
        Iterator<Coin> iterator = coins.iterator();
        while (iterator.hasNext()) {
            Coin currentCoin = iterator.next();
            if (currentCoin.equals(coin)) {
                iterator.remove();
                break;
            }
        }
    }
}
