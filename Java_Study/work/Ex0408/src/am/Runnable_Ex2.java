package am;

import java.awt.Color;

public class Runnable_Ex2 implements Runnable {

	//스레드 동기화를 위한 동기화 관리객체
	Object synObject = new Object();
	
	Frame_Ex2 frame;
	
	public Runnable_Ex2(Frame_Ex2 frame) {
		this.frame= frame;
	}
	
	//빨강색 불을 켜는 동작
	public synchronized void redOn() {
		frame.bt_red.setBackground(Color.red);
		frame.bt_green.setBackground(Color.gray);
		frame.bt_yello.setBackground(Color.gray);
	}
	
	public synchronized void greenOn() {
		frame.bt_red.setBackground(Color.gray);
		frame.bt_green.setBackground(Color.green);
		frame.bt_yello.setBackground(Color.gray);
	}
	
	public synchronized void yellowOn() {
		frame.bt_red.setBackground(Color.gray);
		frame.bt_green.setBackground(Color.gray);
		frame.bt_yello.setBackground(Color.yellow);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		System.out.println(name);
		
		while(true) {
			//현재 스레드의 이름이 "R"이면 빨강색 불을 켠다
			if(name.equals("R")) {
				redOn();
			}else if(name.equals("G")) {
				greenOn();
			}else if (name.equals("Y")) {
				yellowOn();
			}
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
				
		}
	}

}
