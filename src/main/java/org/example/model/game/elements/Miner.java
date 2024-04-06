package org.example.model.game.elements;

public class Miner extends Element {

    private int score;
    private int time;
    private int lives;
    private int coinsCollected;

    //private int isWin;

    public Miner(int x, int y) {
        super(x, y);
        this.score = 0;
        this.time = -1;
        this.lives = 3;
        this.coinsCollected =0;
    }

    public void increaseScore() {
        this.score++;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public void setTime(int time) { this.time = time; }
    public void increaseTime() { this.time += 1; }
    public int getTime() { return time; }

    public void decreaseLives() {
        this.lives--;
    }
    public int getLives() {
        return lives;
    }


    public void increaseCoins() {
        this.coinsCollected++;
    }

    public int getCoinsCollected() {
        return coinsCollected;
    }

    //public void setWin(int isWin) { this.isWin = isWin; }
    //public int checkWin(int isWin) { return isWin; }
}
