package com.ananth;

public class Car {
private int width,height,locX,locY,speed;
public Car(int x,int y,int z){
	width = 60;
	height = 30;
	locX = x;
	locY = y;
	speed = z;
}



public int getWidth(){
	return width;
}
public int getHeight(){
	return height;
}
public int getXLoc(){
	return locX;
}
public int getYLoc(){
	return locY;
}
public void move(int w){
	locX +=speed;
	if(locX>w){
		locX=0;
	}

}


}
