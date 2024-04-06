package org.example.model.game.map;

import org.example.model.game.elements.Enemy;
import org.example.model.game.elements.Wall;
import org.example.model.game.elements.Miner;
import org.example.model.game.elements.Coin;
import org.example.model.game.elements.Final;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;


public class LoaderMapBuilder {

    //private final int level;
    private final List<String> lines;

    public LoaderMapBuilder(int level) throws IOException {
        //this.level = level;
        URL resource = LoaderMapBuilder.class.getResource("/levels/level" + level + ".lvl");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readlines(br);
    }

    public Map createMap() {
        Map map = new Map(25, 28);

        List<Wall> walls = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>();
        List<Coin> coins = new ArrayList<>();
        List<Final> finals = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (x + 1 < line.length() && line.charAt(x) == '[' && line.charAt(x + 1) == ']') {
                    walls.add(new Wall(x, y));
                    x++;
                }
                if (line.charAt(x) == 'M') map.setMiner(new Miner(x, y));
                if (line.charAt(x) == 'E') enemies.add(new Enemy(x, y));
                if (line.charAt(x) == 'o') coins.add(new Coin(x, y));
                if (line.charAt(x) == 'F') finals.add(new Final(x, y));
            }
        }

        map.setWalls(walls);
        map.setEnemies(enemies);
        map.setCoins(coins);
        map.setFinal(finals);

        return map;
    }

    private List<String> readlines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    protected int getWidth() {
        int width = 0;
        for(String line : lines) {
            width = Math.max(width, line.length());
        }
        return width;
    }

    protected int getHeight() {
        return lines.size();
    }



}
