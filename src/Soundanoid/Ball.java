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
        xa = game.ballSpeed;
        ya = game.ballSpeed;
    }

    void move() throws InterruptedException {

        //Ball hits left wall
        if (x + xa < 0) {
            xa = game.ballSpeed;
            Sound.WALL_LEFT.play();
        }

        //Ball hits right wall
        if (x + xa > game.getWidth() - DIAMETER) {
            xa = -game.ballSpeed;
            Sound.WALL_RIGHT.play();
        }

        //Ball hits ceiling
        if (y + ya < 0) {
            ya = game.ballSpeed;
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
            game.gameScore++;
            Sound.RACQUET.play();
            

            //Ball hits left side of the Racquet
            if(collisionRacquetLeft()){
                xa-= 4;
            }
            
            //Ball hits right side of the Racquet
            if(collisionRacquetRight()){
                xa+= 4;
            }
            
            //The ball gains negative speed, going up
            ya = -game.ballSpeed;

            //Brings the ball to the top of the Racquet (Unnecessary)
            //y = game.racquet.getTopY() - DIAMETER;
            switch (game.gameScore) {
                case 5:
                    Sound.BACKGROUND1.loop();
                    game.ballSpeed = 4;
                    break;
                case 10:
                    game.ballSpeed = 5;
                    break;
                case 15:
                    game.ballSpeed = 6;
                    break;
            }
        }

        //Ball hits the center of a Block
        if (collisionBlock()) {
            Sound.BLOCK1.play();
            game.board.listOfBlocks.remove(blockHit());
            //inverts Y component of the movement
            if (ya == -game.ballSpeed) {
                ya = game.ballSpeed;
            } else if (ya == game.ballSpeed) {
                ya = -game.ballSpeed;
            }
            //Checks if the board is empty
            if (game.board.listOfBlocks.isEmpty()) {
                System.out.println("winner");
            }
        }
        
        //Ball hits left side of a Block
        if(collisionBlockLeft() || collisionBlockRight()) {
            Sound.BLOCK1.play();
            game.board.listOfBlocks.remove(blockHit());
            //inverts X component of the movement
            xa = -xa;
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

    private boolean collisionRacquetCenter(){
        return game.racquet.getBoundsCenter().intersects(getBounds());
    }
    
    private boolean collisionRacquetLeft(){
        return game.racquet.getBoundsLeft().intersects(getBounds());
    }
    
    private boolean collisionRacquetRight(){
        return game.racquet.getBoundsRight().intersects(getBounds());
    }
    
    //When the ball hits a Block
    private boolean collisionBlock() {
        for (int i = 0; i < game.board.listOfBlocks.size(); i++) {
            if (game.board.listOfBlocks.get(i).getBoundsCenter().intersects(getBounds())) {
                return true;
            }
        }
        return false;

    }
    
    private boolean collisionBlockLeft() {
        for (int i = 0; i < game.board.listOfBlocks.size(); i++) {
            if (game.board.listOfBlocks.get(i).getBoundsLeft().intersects(getBounds())) {
                return true;
            }
        }
        return false;

    }
    
    private boolean collisionBlockRight() {
        for (int i = 0; i < game.board.listOfBlocks.size(); i++) {
            if (game.board.listOfBlocks.get(i).getBoundsRight().intersects(getBounds())) {
                return true;
            }
        }
        return false;

    }

    //Returns the number of the block that was hit
    private int blockHit() {
        for (Block temp : game.board.listOfBlocks) {
            if (temp.getBounds().intersects(getBounds())) {
                return game.board.listOfBlocks.indexOf(temp);
            }
        }
        return -1;
    }

}
