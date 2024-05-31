package pm;

import java.awt.Graphics;
import java.util.ArrayList;

public class Canvas_Ex7 extends java.awt.Canvas {
	
	ArrayList<MyOval> list;
	
	int x,y;
	
	public Canvas_Ex7() {
		list = new ArrayList<MyOval>();
	}
	
	@Override
	public void paint(Graphics g) {
		for(int i=0; i<list.size();i++) {
			//리스트구조로 부터 요소를 하나씩 가져온다.
			MyOval m = list.get(i);
			//색상 변경
			g.setColor(m.c);
			g.fillOval(m.x, m.y, m.r, m.r);
		}
	}
	
}
