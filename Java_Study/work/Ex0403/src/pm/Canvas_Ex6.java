package pm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Canvas_Ex6 extends Canvas {
	
	int x,y; //마우스 이벤트로 값을 넣어준다.
	
	@Override
	public void paint(Graphics g) {
		// 클릭한 x,y 좌표값을 문자열로 그린다.
		StringBuffer sb =new StringBuffer("x:");
		sb.append(x);
		sb.append(", y:");
		sb.append(y);
		
		g.setColor(Color.blue);
		g.drawString(sb.toString(), x, y);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	
}
