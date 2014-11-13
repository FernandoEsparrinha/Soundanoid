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
    
    private static final int WIDTH = 30;
    private static final int HEIGHT = 20;
    
    int x = 0;
    int y = 0;
    
    public Block(Soundanoid game, int x, int y){
        this.x = x * WIDTH;
        this.y = y * HEIGHT;
        this.game = game;
    }
    
    public void paint(Graphics2D g){
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
    
    
    public int getWidth(){
        return WIDTH;
    }
    
    public int getHeight(){
        return HEIGHT;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
    
    public int getTopY(){
        return this.y;
    }
    
    public int getBotY(){
        return (y+HEIGHT);
    }
}
