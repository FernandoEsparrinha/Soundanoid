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
    ArrayList<Block> listOfBlocks ;
    
    
    private static final int BOARD_WIDTH = 400;
    private static final int BOARD_HEIGHT = 200;
    
    public Board(Soundanoid game){
        this.game = game;
        
        listOfBlocks = new ArrayList();
       
        for(int i = 0; i<13; i++){
            for(int j = 0; j<10; j++){
                listOfBlocks.add(new Block(game, i, j));
            }
        }
        
//        blocks.add(new Block(game, 3, 5));
//        blocks.add(new Block(game, 5, 7));
//        blocks.add(new Block(game, 9, 2));
        
    }
    
    public void paint(Graphics2D g){
        g.create(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
        
        for(int i = 0; i < listOfBlocks.size(); i++){
                listOfBlocks.get(i).paint(g);
        }
    }
    
    
    
}
