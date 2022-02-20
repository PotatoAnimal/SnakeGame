package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grafic extends JPanel implements ActionListener {
    private Timer timer = new Timer(141, this);
    public String state;

    private Snake snake;
    private Food food;
    private Game game;

    public Grafic(Game g) {
        timer.start();

        state = "START";

        game = g;
        snake = g.getPlayer();
        food = g.getFood();

        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(Color.black);
        graphics2D.fillRect(0 , 0, Game.w * Game.d +5, Game.h * Game.d + 5);

        if (state == "START"){
            graphics2D.setColor(Color.white);
            graphics2D.drawString("Press on me :3", Game.w/2*Game.d - 40, Game.h/2*Game.d - 20);
        } else if (state == "RUNING"){
            graphics2D.setColor(Color.red);
            graphics2D.fillRect(food.getX() * Game.d, food.getY() * Game.d, Game.d, Game.d);

            graphics2D.setColor(Color.green);
            for(Rectangle rectangle: snake.getBody()){
                graphics2D.fill(rectangle);
            }
        } else {
            graphics2D.setColor(Color.white);
            graphics2D.drawString("Your life line = " + (snake.getBody().size() - 3), Game.w/2*Game.d - 40, Game.h/2*Game.d - 20);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        game.update();
    }
}
