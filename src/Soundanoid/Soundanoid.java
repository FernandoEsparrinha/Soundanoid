/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soundanoid;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author fernando
 */
public class Soundanoid extends JPanel {

    Ball ball = new Ball(this, 125, 0);
    Racquet racquet = new Racquet(this);
    
    int score = 0;
    int speed = 3;
    
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
                racquet.keyPressed(e);
            }

        });

        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.red);
        ball.paint(g2d);
        g2d.setColor(Color.LIGHT_GRAY);
        racquet.paint(g2d);
        
        
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Helvetica", Font.BOLD, 15));
        g2d.drawString("Score " + score, 10, 30);

    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("GameTest");
        Soundanoid game = new Soundanoid();
        frame.add(game);
        frame.setResizable(false);
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }

    void gameOver() throws InterruptedException {
        Thread.sleep(2000);
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);

    }

}
