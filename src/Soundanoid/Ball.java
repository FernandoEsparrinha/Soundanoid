/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soundanoid;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 *
 * @author fernando
 */
public class Ball {

    private static final int DIAMETER = 30;

    int x = 0;
    int y = 0;
    int xa = 3;
    int ya = 3;
    
    private Soundanoid game;

    public Ball(Soundanoid game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
    }

    void move() throws InterruptedException {

        if (x + xa < 0) {
            xa = game.speed;
            Sound.WALL_LEFT.play();
        }
        if (x + xa > game.getWidth() - DIAMETER) {
            xa = -game.speed;
            Sound.WALL_RIGHT.play();
        }
        if (y + ya < 0) {
            ya = game.speed;
            Sound.WALL_TOP.play();
        }

        if (y + ya > game.getHeight() - DIAMETER) {
            Sound.GAMEOVER.play();
            game.gameOver();
        }
        if (collision()) {
            game.score++;
            Sound.RACQUET.play();
            ya = -3;
            y = game.racquet.getTopY() - DIAMETER;

            switch(game.score){
                case 5: game.speed = 4;
                        break;
                case 10: game.speed = 5;
                        break;
                case 15: game.speed = 8;
                        break;
            }
        }

        x += xa;
        y += ya;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }
}
