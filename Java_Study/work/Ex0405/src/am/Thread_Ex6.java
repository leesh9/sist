package am;

import java.awt.event.KeyEvent;

public class Thread_Ex6 extends Thread{
	Frame_Ex6 f;
	int cmd = 1;
	boolean gs=false;
	public Thread_Ex6(Frame_Ex6 frame) {
		f=frame;
	}
	public void go() {
		if(gs) {
			gs=false;
		}else {
			gs=true;
		}
	}
	
	@Override
	public void run() {
		while(true) {
			if(gs) {
					switch (cmd) {
					case KeyEvent.VK_UP:
						if(f.y>0)
							f.y-=2;
						break;
					case KeyEvent.VK_DOWN:
						if(f.y<f.p.getHeight()-50)
							f.y+=2;
						break;
					case KeyEvent.VK_LEFT:
						if(f.x>0)
							f.x-=2;
						break;
					case KeyEvent.VK_RIGHT:
						if(f.x<f.p.getWidth()-50)
							f.x+=2;
						
					}
				}
			f.p.repaint();
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}
}
