package am;

import java.awt.Color;

public class MyRect {
	Color c;
	int x, y, wh;
	
	public MyRect(int x,int y) {
		
		
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		c = new Color(r,g,b);
		wh = (int)(Math.random()*150+50);
		
		this.x = x-wh/2;
		this.y = y-wh/2;
	}
}
