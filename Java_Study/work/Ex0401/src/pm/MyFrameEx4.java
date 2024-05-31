package pm;

import javax.swing.JFrame;

public class MyFrameEx4 extends JFrame {
	MyWin mw = new MyWin();
	
	public MyFrameEx4() {
		
		this.setSize(500,600);
		this.setVisible(true);
		
		//창 닫기 이벤트 감지자 등록
		//MyWin mw = new MyWin();
		this.addWindowListener(mw);
	}
	
	
	public static void main(String[] args) {
		// 프로그램 시작
		new MyFrameEx4();
		
		System.out.println("1");

	}

}
