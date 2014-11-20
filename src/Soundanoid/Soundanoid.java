/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soundanoid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author fernando
 */
public class Soundanoid extends JPanel {

    int score = 0;
    int speed = 3;

    Ball ball = new Ball(this, 350, 300);
    Racquet racquet = new Racquet(this);
    Board board = new Board(this);

    private void move() throws InterruptedException {
        ball.move();
        racquet.move();

    }

    public Soundanoid() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

                }

                racquet.keyPressed(e);
            }

        });

        setFocusable(true);
    }

//    public BufferedImage background;
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
//        try {
//            this.background = ImageIO.read(Soundanoid.class.getResourceAsStream("background2.png"));
//        } catch (IOException ex) {
//            Logger.getLogger(Soundanoid.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        g2d.drawImage(background, 0, 0, null);
        g2d.setColor(Color.red);
        
        ball.paint(g2d);
        g2d.setColor(Color.LIGHT_GRAY);
        racquet.paint(g2d);
        board.paint(g2d);


        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 15));
//        g2d.drawString("Score " + score, 300, 20);

    }

    public static void main(String[] args) throws InterruptedException, IOException {

        //Initializes the window
        Window frame = new Window();

        //Initializes the game
        Soundanoid game = new Soundanoid();

        JPanel t = new JPanel();
        JLabel l = new JLabel("Score :"+ game.score);
        t.add(l);
        
        frame.add(t, BorderLayout.NORTH);
        frame.add(game, BorderLayout.CENTER);
        
        while (true) {
            game.move();
            game.repaint();
            l.setText("Score :"+ game.score);
            Thread.sleep(10);
        }

    }

    void gameOver() throws InterruptedException {
        Sound.stopSounds();

        Thread.sleep(2000);
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);

    }

}
