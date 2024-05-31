package am;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Frame_Ex1 extends JFrame {
	
	JProgressBar redBar,greenBar,blueBar;
	//수행상태
	boolean bRed=true,bGreen=true, bBlue=true;
	
	//스레드 내부클래스들 준비
	Thread t_red = new Thread() {
		public void run() {
			while(true) {
				//redBar의 값을 먼저 얻어 낸다.
				int val = redBar.getValue();
				val++;//값증가
				if(val > 100)
					break;
				
				redBar.setValue(val);//다시 값 지정!
				try {
					sleep(100);
				} catch (Exception e) {
					// 오류나면, 오류내용을 순차적으로 출력하자
					e.printStackTrace();
				}
				
			}//무한반복
		}
	};
	
	Thread t_green = new Thread() {
		public void run() {
			while(true) {
				//redBar의 값을 먼저 얻어 낸다.
				int val = greenBar.getValue();
				val++;//값증가
				if(val > 100)
					break;
				
				greenBar.setValue(val);//다시 값 지정!
				try {
					sleep(50);
				} catch (Exception e) {
					// 오류나면, 오류내용을 순차적으로 출력하자
					e.printStackTrace();
				}
				
			}//무한반복
		}
	};
	
	Thread t_blue = new Thread() {
		public void run() {
			while(true) {
				//redBar의 값을 먼저 얻어 낸다.
				int val = blueBar.getValue();
				val++;//값증가
				if(val > 100)
					break;
				
				blueBar.setValue(val);//다시 값 지정!
				try {
					sleep(100);
				} catch (Exception e) {
					// 오류나면, 오류내용을 순차적으로 출력하자
					e.printStackTrace();
				}
				
			}//무한반복
		}
	};
	
	public Frame_Ex1() {
		//현재 창의 레이아웃을 3행1열의 그리드 레이아웃으로 설정 
		this.setLayout(new GridLayout(3,1));
		this.add(redBar = new JProgressBar(0, 100));
		this.add(greenBar = new JProgressBar(0, 100));
		this.add(blueBar = new JProgressBar(0, 100));
		
		redBar.setForeground(Color.RED); //전경색 지정
		redBar.setValue(40);//값 설정
		
		greenBar.setForeground(Color.GREEN);
		greenBar.setValue(20);
		
		blueBar.setForeground(Color.BLUE);
		blueBar.setValue(50);
		
		this.setBounds(300,100,500,300);
		this.setVisible(true);
		
		//준비된 스레드들 구동시작
		t_red.start();
		t_green.start();
		t_blue.start();
		
		this.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		});
		
		//키보드 이벤트 감지자 등록
		KeyAdapter adapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int code = e.getKeyCode();
				
				// r 키를 눌렀을때 redBar를 멈추고 다시 구동시킨다.
				switch (code) {
				case KeyEvent.VK_R: {
					//토글방식: true<-->false
					bRed = !bRed;
					if(bRed)//bRed가 true일 때 재시작
						t_red.resume();
					else
						t_red.suspend();//대기 (일시정지)
					break;
					
				}
			}
		
		}
	};
	}	
	public static void main(String[] args) {
		// 프로그램 시작
		new Frame_Ex1();

	}

}
