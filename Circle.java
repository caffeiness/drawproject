package report2 ;

import java.awt.Graphics;

public class Circle extends Figure{
	Circle(){}
	@Override public void paint(Graphics g) {
		g.setColor(currentColor);
		int r = (int)Math.sqrt((double)(w * w + h * h));
		g.drawOval(x - r, y - r, r * 2 , r * 2);
	}
}