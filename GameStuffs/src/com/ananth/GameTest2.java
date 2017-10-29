package com.ananth;

import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class GameTest2 extends JPanel {
	private Frog bob;
	static keyControl keyControl;
	JFrame frame;
	private Car cars[], cars2[], cars3[], cars4[], cars5[], cars6[];
	private int deaths, wins, carNum, carNum2, carNum3, carNum4, carNum5,
			carNum6, speeds[], carNums[], guyX, guyY,count;
	// private boolean deathWindow;
	HitBox HitBox;

	
	
	
	long lastTime;

	public GameTest2(JFrame jf) {
		frame = jf;
	}

	public void init(int x, int y) throws IOException {
	
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bob = new Frog(x, y);
		keyControl = new keyControl(frame.getWidth(), frame.getHeight(), bob);
		HitBox = new HitBox();
		deaths = 0;
		wins = 0;
		speeds = new int[6];
		carNums = new int[6];
		
		
		count = 0;
		// deathWindow = false;
	

		guyX = 500;
		guyY = 700;

		for (int i = 0; i < 6; i++) {
			speeds[i] = (int) (Math.random() * 9) + 1;
		}
		for (int i = 0; i < 6; i++) {
			if (speeds[i] < 2 && speeds[i] > 1) {
				carNums[i] = (int) (Math.random() * 5) + 14;
			}
			if (speeds[i] < 4 && speeds[i] > 2) {
				carNums[i] = (int) (Math.random() * 5) + 10;
			}
			if (speeds[i] > 4) {
				carNums[i] = (int) (Math.random() * 5) + 6;
			}
			if (carNums[i] == 0) {
				carNums[i] = 18;
			}

		}
		carNum = carNums[0];
		carNum2 = carNums[1];
		carNum3 = carNums[2];
		carNum4 = carNums[3];
		carNum5 = carNums[4];
		carNum6 = carNums[5];
		cars = new Car[carNum];
		cars2 = new Car[carNum2];
		cars3 = new Car[carNum3];
		cars4 = new Car[carNum4];
		cars5 = new Car[carNum5];
		cars6 = new Car[carNum6];
		for (int i = 0; i < 6; i++) {
			System.out.println(carNums[i]);
			System.out.println(" ");
			System.out.println(speeds[i]);
		}
		int xVal = 0;
		for (int i = 0; i < carNum; i++) {
			cars[i] = new Car(xVal, 650, speeds[0]);
			xVal += 250;
		}
		xVal = 0;
		for (int i = 0; i < carNum2; i++) {
			cars2[i] = new Car(xVal, 550, speeds[1]);
			xVal += 250;
		}
		xVal = 0;
		for (int i = 0; i < carNum3; i++) {
			cars3[i] = new Car(xVal, 450, speeds[2]);
			xVal += 250;
		}
		xVal = 0;
		for (int i = 0; i < carNum4; i++) {
			cars4[i] = new Car(xVal, 350, speeds[3]);
			xVal += 250;
		}
		xVal = 0;
		for (int i = 0; i < carNum5; i++) {
			cars5[i] = new Car(xVal, 250, speeds[4]);
			xVal += 250;
		}
		xVal = 0;
		for (int i = 0; i < carNum6; i++) {
			cars6[i] = new Car(xVal, 150, speeds[5]);
			xVal += 250;
		}
		xVal = 0;

	}

	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
			g.setColor(Color.green);
		
	
		g.fillRect(0, 700, getWidth(), 100);
		g.fillRect(0, 0, getWidth(), 50);
		g.fillRect(0, 400, getWidth(), 50);
		setBackground(Color.gray);
		
	
		g.setColor(Color.blue);
		


		
		
			for (int i = 0; i < carNum; i++) {
				g.fillRect(cars[i].getXLoc(), cars[i].getYLoc(),
						cars[i].getWidth(), cars[i].getHeight());
				cars[i].move(getWidth());
			}
			for (int i = 0; i < carNum2; i++) {
				g.fillRect(cars2[i].getXLoc(), cars2[i].getYLoc(),
						cars2[i].getWidth(), cars2[i].getHeight());
				cars2[i].move(getWidth());
			}
			for (int i = 0; i < carNum3; i++) {
				g.fillRect(cars3[i].getXLoc(), cars3[i].getYLoc(),
						cars3[i].getWidth(), cars3[i].getHeight());
				cars3[i].move(getWidth());
			}
			for (int i = 0; i < carNum4; i++) {
				g.fillRect(cars4[i].getXLoc(), cars4[i].getYLoc(),
						cars4[i].getWidth(), cars4[i].getHeight());
				cars4[i].move(getWidth());
			}
			for (int i = 0; i < carNum5; i++) {
				g.fillRect(cars5[i].getXLoc(), cars5[i].getYLoc(),
						cars5[i].getWidth(), cars5[i].getHeight());
				cars5[i].move(getWidth());
			}
			for (int i = 0; i < carNum6; i++) {
				g.fillRect(cars6[i].getXLoc(), cars6[i].getYLoc(),
						cars6[i].getWidth(), cars6[i].getHeight());
				cars6[i].move(getWidth());
			}
		
		

		g.setColor(Color.red);

		int x = keyControl.xLoc();
		int y = keyControl.yLoc();

		g.setColor(Color.black);
		g.drawString("Deaths: " + deaths, 25, 25);
		g.drawString("Wins: " + wins, 900, 25);
		for (int i = 0; i < carNum; i++) {
			if (HitBox.collision(x, y, cars[i].getXLoc(), cars[i].getYLoc())) {
				deaths++;
				bob.reset();
				this.repaint();
				// deathWindow = true;

			}
		}
		for (int i = 0; i < carNum2; i++) {
			if (HitBox.collision(x, y, cars2[i].getXLoc(), cars2[i].getYLoc())) {
				deaths++;
				bob.reset();
				this.repaint();
				// deathWindow = true;

			}
		}
		for (int i = 0; i < carNum3; i++) {
			if (HitBox.collision(x, y, cars3[i].getXLoc(), cars3[i].getYLoc())) {
				deaths++;
				bob.reset();
				this.repaint();
				// deathWindow = true;

			}
		}
		for (int i = 0; i < carNum4; i++) {
			if (HitBox.collision(x, y, cars4[i].getXLoc(), cars4[i].getYLoc())) {
				deaths++;
				bob.reset();
				this.repaint();
				// deathWindow = true;

			}
		}
		for (int i = 0; i < carNum5; i++) {
			if (HitBox.collision(x, y, cars5[i].getXLoc(), cars5[i].getYLoc())) {
				deaths++;
				bob.reset();
				this.repaint();
				// deathWindow = true;

			}
		}
		for (int i = 0; i < carNum6; i++) {
			if (HitBox.collision(x, y, cars6[i].getXLoc(), cars6[i].getYLoc())) {
				deaths++;
				bob.reset();
				this.repaint();
				// deathWindow = true;

			}
		}
		if (HitBox.win(x, y, getWidth())) {
			wins++;
			bob.reset();
			reset();

		}

		 
			g.setColor(Color.red);
			g.fillRect(x, y, 30, 30);
		
		if(System.currentTimeMillis()-lastTime>150){
			lastTime = System.currentTimeMillis();
			count++;
			}
	}

	public static void main(String[] args) throws InterruptedException,
			IOException {
		JFrame frame = new JFrame("Frogger");
		final GameTest2 game = new GameTest2(frame);
		game.init(1200, 800);

		keyControl.addKeyListener(keyControl);
		keyControl.setFocusable(true);
		frame.add(keyControl);
		frame.add(game);
		frame.setSize(1200, 800);
		frame.setResizable(false);
		frame.setVisible(true);

		frame.setBackground(Color.gray);
		while (true) {
			game.repaint();
			Thread.sleep(10);
		}
		
		
		

	}

	public void reset() {
		for (int i = 0; i < 6; i++) {
			speeds[i] = (int) (Math.random() * 9) + 1;
		}
		for (int i = 0; i < 6; i++) {
			if (speeds[i] < 2 && speeds[i] > 1) {
				carNums[i] = (int) (Math.random() * 5) + 14;
			}
			if (speeds[i] < 4 && speeds[i] > 2) {
				carNums[i] = (int) (Math.random() * 5) + 10;
			}
			if (speeds[i] > 4) {
				carNums[i] = (int) (Math.random() * 5) + 6;
			}
			if (carNums[i] == 0) {
				carNums[i] = 18;
			}

		}
		carNum = carNums[0];
		carNum2 = carNums[1];
		carNum3 = carNums[2];
		carNum4 = carNums[3];
		carNum5 = carNums[4];
		carNum6 = carNums[5];
		cars = new Car[carNum];
		cars2 = new Car[carNum2];
		cars3 = new Car[carNum3];
		cars4 = new Car[carNum4];
		cars5 = new Car[carNum5];
		cars6 = new Car[carNum6];
		for (int i = 0; i < 6; i++) {
			System.out.println(carNums[i]);
			System.out.println(" ");
			System.out.println(speeds[i]);
		}
		int xVal = 0;
		for (int i = 0; i < carNum; i++) {
			cars[i] = new Car(xVal, 650, speeds[0]);
			xVal += 250;
		}
		xVal = 0;
		for (int i = 0; i < carNum2; i++) {
			cars2[i] = new Car(xVal, 550, speeds[1]);
			xVal += 250;
		}
		xVal = 0;
		for (int i = 0; i < carNum3; i++) {
			cars3[i] = new Car(xVal, 450, speeds[2]);
			xVal += 250;
		}
		xVal = 0;
		for (int i = 0; i < carNum4; i++) {
			cars4[i] = new Car(xVal, 350, speeds[3]);
			xVal += 250;
		}
		xVal = 0;
		for (int i = 0; i < carNum5; i++) {
			cars5[i] = new Car(xVal, 250, speeds[4]);
			xVal += 250;
		}
		xVal = 0;
		for (int i = 0; i < carNum6; i++) {
			cars6[i] = new Car(xVal, 150, speeds[5]);
			xVal += 250;
		}
		xVal = 0;
	}

	public void guySize() {
		guyX += 50;
		guyY += 100;
	}

}
