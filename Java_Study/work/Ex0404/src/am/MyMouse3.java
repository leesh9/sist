package am;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouse3 extends MouseAdapter {
	MyFrameEx3 ff;
	
	public MyMouse3(MyFrameEx3 f) {
		ff= f;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		MyImage mi = new MyImage(x, y);
		ff.can.list.add(mi);
		
		ff.can.repaint();
		
	}
}
