package report2;

import java.awt.Graphics;

public class Ellipse extends Figure{
	Ellipse(){}
	@Override public void paint(Graphics g) {
		g.setColor(currentColor);
		int r=(int)Math.sqrt(2);
		if(w>0 && h>0) {
			g.drawOval(x - r*w, y - r*h, w , h);
		}else if(w<0 && h>0) {
			w=-w;
			g.drawOval(x - r*w, y - r*h, w , h);
		}else if(w>0 && h<0) {
			h=-h;
			g.drawOval(x - r*w, y - r*h, w , h);
		}else if(w<0 && h<0) {
			w=-w;
			h=-h;
			g.drawOval(x - r*w, y - r*h, w , h);
		}
	}
}