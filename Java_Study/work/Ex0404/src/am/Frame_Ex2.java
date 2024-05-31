package am;

import javax.swing.JFrame;

public class Frame_Ex2 extends JFrame {
	
	Canvas_Ex2 can;
	
	public Frame_Ex2() {
		//현재 창에 캔버스를 생성하여 가운데에 추가한다.
		can=new Canvas_Ex2();
		this.add(can);
		
		this.setBounds(300,100,600,500);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Frame_Ex2();

	}

}
