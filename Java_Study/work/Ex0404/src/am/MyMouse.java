package am;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouse extends MouseAdapter {
	MyFrameEx ff;
	
	public MyMouse(MyFrameEx f) {
		ff= f;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		MyRect mr = new MyRect(x, y);
		
		ff.can.list.add(mr);// 생성된 사각형 객체를 MyFrame안에 있는
		// MyCanvas안에 있는 list에 추가한다.
		
		ff.can.repaint();//사각형 객체가 추가되었으므로 그림을 다시 그린다.
	}
	
	


}