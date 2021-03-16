package report2;

import java.awt.Graphics;

public class Line extends Figure{
	Line(){}
	@Override public void paint(Graphics g) {
		g.setColor(currentColor);
		g.drawLine(x, y, x + w , y + h);
	}
}