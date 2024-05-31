package pm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Canvers_Ex5 extends Canvas {

	@Override
	public void paint(Graphics g) {
		g.drawRect(10, 10, 100, 100);
		
		g.setColor(Color.red);
		g.fillRect(20, 20, 60, 60);
		
		g.setColor(Color.blue);
		g.fillOval(140, 10,100 , 100);
		
		g.drawString("쌍용교육센터", 250, 70);
	}
	
	
}
