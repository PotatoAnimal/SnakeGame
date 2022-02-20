package main;

import java.awt.*;

public class Food {
    private int x;
    private int y;

    public Food(Snake snake) {
        this.spawnFood(snake);
    }

    public void spawnFood(Snake snake) {
        boolean onSnake = true;
        while (onSnake) {
            onSnake = false;

            x = (int) (Math.random() * Game.h - 1);
            y = (int) (Math.random() * Game.w - 1);
            for (Rectangle rectangle : snake.getBody()) {
                if (rectangle.x == x && rectangle.y == y) {
                    onSnake = true;
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
