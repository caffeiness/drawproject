package report2;

import java.awt.Graphics;

public class Rect extends Figure{
	Rect(){}
	@Override public void paint(Graphics g) {
		g.setColor(currentColor);
		if(w>0 && h>0) {
			g.drawRect(x, y, w, h);
		}else if(w<0 && h>0) {
			g.drawRect(x+w,y,-w,h);
		}else if(w>0 && h<0) {
			g.drawRect(x,y+h,w,-h);
		}else if(w<0 && h<0) {
			g.drawRect(x+w, y+h, -w, -h);
		}
	}
}