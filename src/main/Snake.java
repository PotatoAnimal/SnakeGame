package main;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Rectangle> body;
    private int w = Game.w;
    private int h = Game.h;
    private int d = Game.d;

    private String move;

    public Snake() {
        body = new ArrayList<>();

        Rectangle temp = new Rectangle(Game.d, Game.d);
        temp.setLocation(Game.w / 2 * Game.d, Game.h / 2 * Game.d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 1) * d, (h / 2 - 1) * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 2) * d, (h / 2 - 2) * d);
        body.add(temp);

        move = "RIGHT";
    }

    public void move() {
        if (move != "NOTHING") {
            Rectangle first = body.get(0);

            Rectangle temp = new Rectangle(d, d);
            if (move == "UP") {
                temp.setLocation(first.x, first.y - d);
            } else if (move == "DOWN") {
                temp.setLocation(first.x, first.y + d);
            } else if (move == "LEFT") {
                temp.setLocation(first.x - d, first.y);
            } else {
                temp.setLocation(first.x + d, first.y);
            }
            body.add(0, temp);
            body.remove(body.size() - 1);
        }
    }

    public void grow() {
        Rectangle first = body.get(0);

        Rectangle temp = new Rectangle(Game.d, Game.d);

        if (move == "UP") {
            temp.setLocation(first.x, first.y - d);
        } else if (move == "DOWN") {
            temp.setLocation(first.x, first.y + d);
        } else if (move == "LEFT") {
            temp.setLocation(first.x - d, first.y);
        } else {
            temp.setLocation(first.x + d, first.y);
        }
        body.add(0, temp);
    }

    public void up() {
        move = "UP";
    }

    public void down() {
        move = "DOWN";
    }

    public void left() {
        move = "LEFT";
    }

    public void right() {
        move = "RIGHT";
    }

    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public int getX() {
        return body.get(0).x;
    }

    public String getMove() {
        return move;
    }

    public int getY() {
        return body.get(0).y;
    }
}
