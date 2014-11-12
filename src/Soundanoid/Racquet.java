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
    int x = 0;
	int xa = 0;
	private Soundanoid game;
        
        private static final int Y = 430;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;

	public Racquet(Soundanoid game) {
		this.game= game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth()-60)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, 60, 10);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -4;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 4;
	}
        
        public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}
        
        public int getTopY() {
		return Y;
	}


}
