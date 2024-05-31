package pm;

import java.awt.Color;

import javax.swing.JPanel;

public class MyOval extends Thread {
	int x,y,wh;
	Color c;
	JPanel p;
	int speed;
	
	public MyOval(int x,int y,JPanel p) {
		wh = (int)(Math.random()*100+50);
		this.x=x-wh/2;
		this.y=y-wh/2;
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		
		c= new Color(r,g,b);
		this.p=p;
		speed = (int)(Math.random()*30+10);
	}
	
	@Override
	public void run() {
		while(y<p.getHeight()-wh) {
			y+=2;
			p.repaint();
			try {
				sleep(speed);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//스레드 소멸 직전에 Frame_Ex2에있는 list에서
		//현재 객체를 삭제한다.
		//f.list.remover(this);
	}
}
