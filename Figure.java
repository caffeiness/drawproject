package report2;

import java.awt.Color;
import java.awt.Graphics;

public class Figure extends Coord{
	Color currentColor=new Color(0,0,0);
	int color;
	int w,h;
	
	Figure(){
		color=0;
		w=h=0;
	}
	public void setPenColor(Color newColor) {
		currentColor=newColor;
	}
	public void paint(Graphics g) {}
	public void setWH(int w, int h) {
		this.w=w;
		this.h=h;
	}
}