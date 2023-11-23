import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Screen screen;

    //private int x = 10;
    //private int y = 10;

    Hero hero = new Hero(10, 10);

    public Game(){
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void draw() throws IOException {
        screen.clear();
        //screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X') [0]);
        hero.draw(screen);
        screen.refresh();
    }

    private void processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp:
                System.out.println("Arrow Up");
                hero.moveUp();
                break;
            case ArrowDown:
                System.out.println("Arrow Down");
                hero.moveDown();
                break;
            case ArrowLeft:
                System.out.println("Arrow Left");
                hero.moveLeft();
                break;
            case ArrowRight:
                System.out.println("Arrow Right");
                hero.moveRight();
                break;
        }
    }

    public void run() throws IOException {
        try {
            while(true){
                draw();
                KeyStroke key = screen.readInput();
                processKey(key);
                if (key.getKeyType().equals(KeyType.Character) && key.getCharacter() == 'q') {
                    screen.close();
                }
                if (key.getKeyType() == KeyType.EOF)
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
