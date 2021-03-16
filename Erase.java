package report2;

import java.awt.Color;
import java.awt.Graphics;

public class Erase extends Figure{
	int size;
	Erase(){
		size=50;
	}
	@Override public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x-size/2, y-size/2, size, size);
	}
}