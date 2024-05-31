package pm;

import java.awt.Rectangle;

public class Bullet_Ex3  extends Thread{

	Rectangle rect = new Rectangle();
	Frame_Ex3 frame ;
	
	// 현재객체가 총알을 의미하며, 현재객체를 
	// 스페이스바가 눌려질 때마다 생성되어 JFrame의 맴버변수인
	// ArrayList에 저장 되어야 한다. 즉, ArrayList를 접근 할 때가 생긴다.
	// 그래서 ArrayList를 가지는 JFrame의 주소가 필요하다.
	
	public Bullet_Ex3(int x, int y,Frame_Ex3 frame) {
		rect.x = x;
		rect.y = y;
		rect.width= frame.bullet_img.getWidth(frame);
		rect.height= frame.bullet_img.getHeight(frame);
		this.frame = frame;
	}
	
	@Override
	public void run() {
		// 일정 시간동안 쉬면서 y좌표를 감소시킨다,
		p:while(true) {
			rect.y-=3;
			frame.p.repaint();
			
			for(int i=0;i<frame.m_list.size();i++) {
				if(rect.intersects(frame.m_list.get(i).rect)) {
					frame.m_list.remove(i);
					frame.score++;
					
					Explotion_Ex3 exp = new Explotion_Ex3();
					
					//충돌한 위치값(x,y)을 폭발 객체에 저장해야 한다.
					exp.pt.x = (int)rect.getCenterX()-exp.size/2;
					exp.pt.y = (int)rect.getCenterY()-exp.size/2;
					
					//Frame창의 맴버변수인 ex_list에
					//폭발객체 저장!!
					frame.ex_list.add(exp);
					
					break p;
				}
			}
			
			try {
				sleep(20);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			//좌표값이 변경되었으므로 다시 그려야한다.
			
			//현재 무한반복을 탈출하기 위한 비교문
			//현재 총알객체가 화면위로 사라진후
			if(rect.y<0) {
				break;//무한반복 탈출과 함께 현재 객체를 
						// 소멸 시켜야 한다.(ArrayList에서 삭제)
			}
		}
		//삭제
		frame.b_list.remove(this);
		
	}
}
