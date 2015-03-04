/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soundanoid;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author fernando
 */
public class Block {
    private Soundanoid game;
    
    private static final int BLOCK_WIDTH = 30;
    private static final int BLOCK_HEIGHT = 20;
    
    int x = 0;
    int y = 0;
    
    public Block(Soundanoid game, int x, int y){
        this.x = x * BLOCK_WIDTH;
        this.y = y * BLOCK_HEIGHT;
        this.game = game;
    }
    
    public void paint(Graphics2D g){
        g.fillRect(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
    }
    
    
    public int getWidth(){
        return BLOCK_WIDTH;
    }
    
    public int getHeight(){
        return BLOCK_HEIGHT;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,BLOCK_WIDTH,BLOCK_HEIGHT);
    }
    
    public Rectangle getBoundsCenter(){
        return new Rectangle(x+1, y, BLOCK_WIDTH-1, BLOCK_HEIGHT);
    }
    
    public Rectangle getBoundsLeft(){
        return new Rectangle(x, y+5, 1, BLOCK_HEIGHT-10);
    }
    
    public Rectangle getBoundsRight(){
        return new Rectangle(x+29, y+5, 1, BLOCK_HEIGHT-10);
    }
    
}
