package com.ananth;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class HitBox extends Rectangle2D{
	int x,y,x2,y2;

	public boolean collision(int a, int b, int c, int d){
		x=a;
		y=b;
		x2=c;
		y2=d;
		Rectangle frog = new Rectangle(x,y,50,50);
		Rectangle car = new Rectangle(x2,y2,60,30);
		
		return frog.intersects(car);
	}
	public boolean win(int a, int b, int c){
		x=a;
		y=b;
		Rectangle frog = new Rectangle(x,y,50,50);
		Rectangle end = new Rectangle (0,0,c,50);
		return frog.intersects(end);
	}

	@Override
	public Rectangle2D createIntersection(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D createUnion(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outcode(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRect(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
