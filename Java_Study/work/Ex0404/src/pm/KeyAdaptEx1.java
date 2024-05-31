package pm;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdaptEx1 extends KeyAdapter {
	FrameEx1 frame;
	
	public KeyAdaptEx1(FrameEx1 f) {
		frame=f;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int i = e.getKeyCode();
		frame.can.cmd=i;
		frame.can.repaint();
	}
}
