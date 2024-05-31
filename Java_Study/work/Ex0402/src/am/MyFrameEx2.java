package am;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrameEx2 extends JFrame {
	
	//맴버변수 선언
	JButton bt1,bt2,bt3;
	JPanel p1;
	
	public MyFrameEx2() {
		//버튼객체들 생성
		bt1 = new JButton("RED");
		bt2 = new JButton("GREEN");
		bt3 = new JButton("BLUE");
		
		p1 = new JPanel();//기본으로 FlowLayout이다.
		//p1에 버튼들을 추가한다.
		p1.add(bt1);
		p1.add(bt2);
		p1.add(bt3);
		
		//North영역에 버튼3개를 가지는 p1을 추가한다.
		this.add(p1,BorderLayout.NORTH);
		
		//this.setSize(500,600);//창의 크기설정
		//this.setLocation(400,200);//창의 위치설정
		this.setBounds(400, 300 , 500, 600);//위치와 크기설정
		this.setVisible(true);
		
		this.addWindowListener(new MyWinEx1());
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new MyFrameEx2();

	}

}
