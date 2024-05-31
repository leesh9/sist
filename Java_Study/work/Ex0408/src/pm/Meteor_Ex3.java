package pm;

import java.awt.Rectangle;

public class Meteor_Ex3 extends Thread{
	Rectangle rect = new Rectangle();
	Frame_Ex3 frame;
	int speed;
	
	public Meteor_Ex3(Frame_Ex3 frame,int w,int h) {
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
				Explotion_Ex3 exp = new Explotion_Ex3();
				
				//충돌한 위치값(x,y)을 폭발 객체에 저장해야 한다.
				exp.pt.x = (int)rect.getCenterX()-exp.size/2;
				exp.pt.y = (int)rect.getCenterY()-exp.size/2;
				
				//Frame창의 맴버변수인 ex_list에
				//폭발객체 저장!!
				frame.ex_list.add(exp);
				
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
