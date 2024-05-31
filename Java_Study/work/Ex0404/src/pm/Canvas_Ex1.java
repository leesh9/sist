package pm;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Canvas_Ex1 extends Canvas {
	int cmd;
	int x=10,y=10;
	public Canvas_Ex1() {
		
	}
	
	@Override
	public void paint(Graphics g) {
		switch (cmd) {
		case KeyEvent.VK_1: {
			g.drawOval(x, y, 100, 100);
			break;
			}
		case KeyEvent.VK_2:{
			g.fillOval(x, y, 100, 100);
			break;
		}
		case KeyEvent.VK_3:{
			g.drawRect(x, y, 100, 100);
			break;
		}
		case KeyEvent.VK_4:{
			g.fillRect(x, y, 100, 100);
			break;
		}
		case KeyEvent.VK_5:{
			g.drawString("쌍용교육센터", x, y);
		}
		}
	}
}