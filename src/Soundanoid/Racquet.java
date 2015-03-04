/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soundanoid;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author fernando
 */
public class Racquet {

    int racquet_X_position = 150;
    int racquet_X_aceleration = 0;
    private Soundanoid game;

    private static final int RACQUET_Y_POSITION = 510;
    private static final int RACQUET_WIDTH = 60;
    private static final int RACQUET_HEIGHT = 10;

    public Racquet(Soundanoid game) {
        this.game = game;
    }

    public void move() {
        if (racquet_X_position + racquet_X_aceleration > 0 && racquet_X_position + racquet_X_aceleration < game.getWidth() - 60) {
            racquet_X_position = racquet_X_position + racquet_X_aceleration;
        }
    }

    public void paint(Graphics2D g) {
        g.fillRect(racquet_X_position, RACQUET_Y_POSITION, RACQUET_WIDTH, RACQUET_HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        racquet_X_aceleration = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            racquet_X_aceleration = -6;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            racquet_X_aceleration = 6;
        }
        
    }

    public Rectangle getBounds() {
        return new Rectangle(racquet_X_position, RACQUET_Y_POSITION, RACQUET_WIDTH, RACQUET_HEIGHT);
    }
    
    public Rectangle getBoundsCenter() {
        return new Rectangle(racquet_X_position+10, RACQUET_Y_POSITION, RACQUET_WIDTH-20, RACQUET_HEIGHT);
    }
    
    public Rectangle getBoundsLeft() {
        return new Rectangle(racquet_X_position, RACQUET_Y_POSITION, 10, RACQUET_HEIGHT);
    }
    
    public Rectangle getBoundsRight() {
        return new Rectangle(racquet_X_position+(RACQUET_WIDTH-10), RACQUET_Y_POSITION, 10, RACQUET_HEIGHT);
    }

    public int getTopY() {
        return RACQUET_Y_POSITION;
    }

}
