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

    int x = 0;
    int y = 0;
    int xa = 3;
    int ya = 3;
    int score = 0;
    private Soundanoid game;

    public Ball(Soundanoid game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
    }

    void move() throws InterruptedException {

        if (x + xa < 0) {
            xa = 3;
        }
        if (x + xa > game.getWidth() - 30) {
            xa = -3;
        }
        if (y + ya < 0) {
            ya = 3;
        }

        if (y + ya > game.getHeight() - 30) {
            Sound.GAMEOVER.play();
            
            game.gameOver();
        }
        if (collision()) {
            score++;
            Sound.RACQUET.play();
            ya = -3;
            y = game.racquet.getTopY() - 30;
        }

        x += xa;
        y += ya;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, 30, 30);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 30, 30);
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }
}
