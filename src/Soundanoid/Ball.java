/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soundanoid;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando
 */
public class Ball {

    private static final int DIAMETER = 30;

    int x = 0;
    int y = 0;
    double xa;
    double ya;

    private Soundanoid game;

    public Ball(Soundanoid game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
        xa = game.speed;
        ya = game.speed;
    }

    void move() throws InterruptedException {

        //Ball hits left wall
        if (x + xa < 0) {
            xa = game.speed;
            Sound.WALL_LEFT.play();
        }

        //Ball hits right wall
        if (x + xa > game.getWidth() - DIAMETER) {
            xa = -game.speed;
            Sound.WALL_RIGHT.play();
        }

        //Ball hits ceiling
        if (y + ya < 0) {
            ya = game.speed;
            xa = xa + ((Math.random() * 5) - 2.5);
            Sound.WALL_TOP.play();
        }

        //Ball hits floor
        if (y + ya > game.getHeight() - DIAMETER) {
            Sound.GAMEOVER.play();
            game.gameOver();
        }

        //Ball hits the Racquet
        if (collisionRacquet()) {
            game.score++;
            Sound.RACQUET.play();

            //The ball gains negative speed, going up
            ya = -game.speed;
            xa = xa + ((Math.random() * 5) - 2.5);

            //Brings the ball to the top of the Racquet (Unnecessary)
            //y = game.racquet.getTopY() - DIAMETER;
            switch (game.score) {
                case 5:
                    Sound.BACKGROUND1.loop();
                    game.speed = 4;
                    break;
                case 10:
                    game.speed = 5;
                    break;
                case 15:
                    game.speed = 6;
                    break;
            }
        }

        //Ball hits a Block
        if (collisionBlock()) {
            Sound.BLOCK1.play();
            game.board.blocks.remove(blockHit());
            
            //y = game.board.blocks.get(blockHit()).getBotY() + DIAMETER;

            if (ya == -game.speed) {
                ya = game.speed;
            } else if (ya == game.speed) {
                ya = -game.speed;
            }
            
            
            
            //Checks if the board is empty
            if (game.board.blocks.isEmpty()) {
                System.out.println("winner");
            }
        }

        //Acelerating
        x += xa;
        y += ya;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

    private boolean collisionRacquet() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    //When the ball hits a Block
    private boolean collisionBlock() {
        for (int i = 0; i < game.board.blocks.size(); i++) {
            if (game.board.blocks.get(i).getBounds().intersects(getBounds())) {
                return true;
            }
        }
        return false;

    }

    //Returns the number of the block that was hit
    private int blockHit() {
        for (Block temp : game.board.blocks) {
            if (temp.getBounds().intersects(getBounds())) {
                return game.board.blocks.indexOf(temp);
            }
        }
        return -1;
    }

}
