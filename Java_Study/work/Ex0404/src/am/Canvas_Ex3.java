package am;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Canvas_Ex3 extends Canvas {
	ArrayList<MyImage> list = new ArrayList<MyImage>();
	
	@Override
	public void paint(Graphics g) {
		for(int i =0; i<list.size();i++) {
			MyImage mi = list.get(i);
			g.drawImage(mi.img, mi.x, mi.y,this);
		}
	}
	
	

}
