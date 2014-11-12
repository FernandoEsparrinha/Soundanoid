/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soundanoid;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class Board {
    private Soundanoid game;
    Graphics2D g2d_Board;
    
    ArrayList<Block> blocks ;
    
    
    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;
    
    public Board(Soundanoid game){
        this.game = game;
        blocks = new ArrayList();
        blocks.add(new Block(game, 0, 0));
        blocks.add(new Block(game, 3, 5));
        blocks.add(new Block(game, 5, 7));
        blocks.add(new Block(game, 9, 2));
    }
    
    public void paint(Graphics2D g){
        g2d_Board = (Graphics2D) g.create(0, 0, WIDTH, HEIGHT);
        
        for(int i = 0; i < blocks.size(); i++){
                blocks.get(i).paint(g);
        }
    }
    
    public Graphics2D getGraphics(){
        return g2d_Board;
    }
    
}
