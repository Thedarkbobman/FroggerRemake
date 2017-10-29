package com.ananth;

public class Frog {
private int xLoc,yLoc,frogWidth,xMov,yMov,w,h;

public Frog(int width, int height){
	frogWidth = 50;
	xLoc = width/2-frogWidth/2;
	yLoc = height-50;
	xMov = 50;
	yMov = 50;
	w=width;
	h=height;
	
}

public int locX(){
	return xLoc;
}
public int locY(){
	return yLoc;
}
public void moveLeft(Boolean a){
	if(xLoc>0){
		if(!a){
			xLoc-=xMov;
		}
		else{
			xLoc-=xMov*2;
		}
	}
}
public void moveRight(Boolean a){
	if(xLoc < w){

		if(!a){
			xLoc+=xMov;
		}
		else{
			xLoc+=xMov*2;
		}
	}
	}

public void moveUp(Boolean a){
	if(yLoc > 0){
		if(!a){
			yLoc-=yMov;
		}
		else{
			yLoc-=yMov*2;
		}
	}
}
public void moveDown(Boolean a){
	if(yLoc < h){
		if(!a){
			yLoc+=yMov;
		}
		else{
			yLoc+=yMov*2;
		}
	}
}
public void reset(){
	xLoc = w/2-frogWidth/2;
	yLoc = h-50;
}
}
