package com.ananth;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class keyControl extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	private int width, height;
	private Frog bob;
	private GameTest2 hi;
	private boolean a, b;


	public keyControl(int w, int h, Frog frog) {
		width = w;
		height = h;
		bob = frog;

	
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
			bob.moveUp(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_A
				|| e.getKeyCode() == KeyEvent.VK_LEFT) {
			bob.moveLeft(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_S
				|| e.getKeyCode() == KeyEvent.VK_DOWN) {
			bob.moveDown(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_D
				|| e.getKeyCode() == KeyEvent.VK_RIGHT) {
			bob.moveRight(false);
			
		}

		
		}
	

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	public int xLoc() {
		return bob.locX();
	}

	public int yLoc() {
		return bob.locY();
	}



}
