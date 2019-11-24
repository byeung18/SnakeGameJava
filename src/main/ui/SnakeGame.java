package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JFrame {
    private int size = 11;
    public int thewidth;
    public int theheight;
    private static final Color BACKGROUND_COLOUR = new Color(100, 100, 100);
    private static final Color GAME_OVER_COLOUR = new Color(80, 40, 80);
    private static final int INTERVAL = 400;
    private Game game;
    private static final int PIXELS = 30;


    // modified code from class lab 6
    SnakeGame(int sizeshape) {
        super("SnakeGame");
        thewidth = sizeshape * 30;
        theheight = sizeshape * 30;
        setSize(thewidth, theheight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        game = new Game(sizeshape);
        addKeyListener(new KeyHandler());
        centreOnScreen();
        addTimer();
        setVisible(true);
    }

    // modified code from class lab 6
    @Override
    // MODIFIES: graphics
    // EFFECTS:  clears screen and paints game onto graphics
    public void paint(Graphics graphics) {
        graphics.setColor(game.isOver() ? GAME_OVER_COLOUR : BACKGROUND_COLOUR);
        graphics.fillRect(0, 0, thewidth, theheight);
        draw(graphics);
    }



    void draw(Graphics graphics) {
        drawSnake(graphics);
        drawApple(graphics);
    }

    void drawSnake(Graphics graphics) {
        graphics.setColor(new Color(25, 240, 50));
        for (int i = 0; i < game.snake.bodyX.size(); i++) {
            graphics.fillRect(game.snake.bodyX.get(i) * PIXELS,
                    game.snake.bodyY.get(i) * PIXELS,
                    PIXELS, PIXELS);
        }
    }

    void drawApple(Graphics graphics) {
        graphics.setColor(new Color(200, 25, 50));
        graphics.fillRect(game.apple.getXloc() * PIXELS,
                game.apple.getYloc() * PIXELS,
                PIXELS, PIXELS);
    }

    // taken from class lab 6
    // EFFECTS: initializes a timer that updates game each
    //          INTERVAL milliseconds
    private void addTimer() {
        final Timer t = new Timer(INTERVAL, null);
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (game.isOver()) {
                    t.stop();
                } else {
                    game.update();
                    repaint();
                }
            }
        });

        t.start();
    }

    // taken from class lab 6
    // MODIFIES: this
    // EFFECTS:  frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    // modified code from class lab 6
    // Represents a key handler that responds to keyboard events
    private class KeyHandler extends KeyAdapter {
        @Override
        // MODIFIES: this
        // EFFECTS:  updates game in response to a keyboard event
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    game.rotateSnake("LEFT");
                    break;
                case KeyEvent.VK_RIGHT:
                    game.rotateSnake("RIGHT");
                    break;
                case KeyEvent.VK_UP:
                    game.rotateSnake("UP");
                    break;
                case KeyEvent.VK_DOWN:
                    game.rotateSnake("DOWN");
                    break;
                default:
                    break;
            }
        }
    }


    public static void main(String[] args) {
        new SnakeGame(11);
    }

}
