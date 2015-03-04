/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soundanoid;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author fernando
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        //Initializes the window
        Window frame = new Window();

        //Initializes the game
        Soundanoid game = new Soundanoid();

        JPanel scorePanel = new JPanel();
        JLabel scoreLabel = new JLabel("Score :"+ game.gameScore);
        scorePanel.add(scoreLabel);
        
        frame.add(scorePanel, BorderLayout.NORTH);
        frame.add(game, BorderLayout.CENTER);
        
        while (true) {
            game.move();
            game.repaint();
            scoreLabel.setText("Score :"+ game.gameScore);
            Thread.sleep(10);
        }
    }
    
}
