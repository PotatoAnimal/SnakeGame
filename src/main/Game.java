package main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class Game implements KeyListener {
    private JFrame window;
    private Food food;
    private Snake player;
    private Grafic grafic;

    public static final int w = 30;
    public static final int h = 30;
    public static final int d = 20;

    public Game() {
        window = new JFrame();
        window.setSize(w * d + 2, h * d + d + 4);

        player = new Snake();
        food = new Food(player);

        grafic = new Grafic(this);
        window.add(grafic);

        window.setTitle("SNAKEEEEEEE");
        window.setVisible(true);
//        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private boolean checkFoodCollision() {
        if (player.getX() == food.getX() * d && player.getY() == food.getY() * d) {
            return true;
        }
        return false;
    }

    private boolean checkWallCollision() {
        if (player.getX() < 0 || player.getX() >= w * d || player.getY() < 0 || player.getY() >= h * d) {
            return true;
        }
        return false;
    }

    private boolean checkSelfCollision() {
        for (int i = 1; i < player.getBody().size(); i++) {
            if (player.getX() == player.getBody().get(i).x && player.getY() == player.getBody().get(i).y) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        grafic.state = "RUNING";
    }

    public void update() {
        if (grafic.state == "RUNING") {
            if (checkFoodCollision()) {
                player.grow();
                food.spawnFood(player);
            } else if (checkSelfCollision() || checkWallCollision()) {
                grafic.state = "END";
            } else {
                player.move();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (grafic.state == "RUNING") {
            if (key == KeyEvent.VK_W && player.getMove() != "DOWN") {
                player.up();
            }
            if (key == KeyEvent.VK_D && player.getMove() != "LEFT") {
                player.right();
            }
            if (key == KeyEvent.VK_A && player.getMove() != "RIGHT") {
                player.left();
            }
            if (key == KeyEvent.VK_S && player.getMove() != "UP") {
                player.down();
            }
        } else {
            this.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Food getFood() {
        return food;
    }

    public Snake getPlayer() {
        return player;
    }
}
