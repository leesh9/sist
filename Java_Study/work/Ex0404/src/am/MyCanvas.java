package am;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

public class MyCanvas extends Canvas {
	//사각형 객체들이 저장되는 곳
	ArrayList<MyRect> list = new ArrayList<MyRect>();

	@Override
	public void paint(Graphics g) {
		// list에 있는 모든 사각형 객체들을 반복문을 통해 그린다.
		for(int i = 0;i<list.size();i++) {
			MyRect mr = list.get(i);
			
			g.setColor(mr.c);
			g.fillRect(mr.x, mr.y, mr.wh, mr.wh);
		}
	}
	
	
}
