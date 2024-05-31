package pm;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapt_Ex5 extends KeyAdapter {
	
	FrameEx5 frame;
	
	KeyAdapt_Ex5(FrameEx5 f){
		this.frame=f;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			frame.can.y-=5;
			frame.can.repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			frame.can.y+=5;
			frame.can.repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			frame.can.x-=5;
			frame.can.repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			frame.can.x+=5;
			frame.can.repaint();
		}
		
		
	}
}
