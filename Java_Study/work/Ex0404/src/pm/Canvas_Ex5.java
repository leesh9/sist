package pm;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Canvas_Ex5 extends Canvas {
	int x = 250;
	int y = 250;
	
	@Override
	public void paint(Graphics g) {
		g.fillOval(x, y, 50, 50);
	}
}
