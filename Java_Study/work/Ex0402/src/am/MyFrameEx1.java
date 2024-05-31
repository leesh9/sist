package am;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrameEx1 extends JFrame {
	
	//맴버변수 선언
	JButton bt1,bt2;
	
	public MyFrameEx1() {
		//생성자의 목적 맴버 변수의 초기화
		
		//원하는 버튼 객체 생성
		bt1 = new JButton("버튼1");
		bt2 = new JButton("버튼2");
		
		
		//현재 창에 버튼 객체를 배치(추가)한다.
		this.add(bt1,BorderLayout.NORTH);
		this.add(bt2);
		
		this.setSize(500,600);
		this.setLocation(350,300);
		this.setVisible(true);
		
		//종료이벤트 감지자 등록
		this.addWindowListener(new MyWinEx1());
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		MyFrameEx1 f = new MyFrameEx1();

	}

}
