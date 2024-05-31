package pm;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Meteor extends Thread{
	Rectangle rect = new Rectangle();
	Frame_Ex1 frame;
	int speed;
	
	public Meteor(Frame_Ex1 frame,int w,int h) {
		rect.x = (int)(Math.random()*frame.p.getWidth());
		rect.y = 0 - frame.meteor_img.getHeight(frame);
		rect.height=h;
		rect.width=w;
		this.frame=frame;
		speed = (int)(Math.random()*30+10);
	}
	
	@Override
	public void run() {
		while(rect.y<frame.p.getHeight()) {
			rect.y+=2;
			frame.p.repaint();
			
			// 주인공 객체와 충돌 여부 확인
			if(rect.intersects(frame.me.pos)) {
				
				break;// 현재 운석객체 소멸
			}
			try {
				sleep(speed);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//스레드 소멸 직전에 Frame_Ex2에있는 list에서
		//현재 객체를 삭제한다.
		frame.m_list.remove(this);
	}
}
