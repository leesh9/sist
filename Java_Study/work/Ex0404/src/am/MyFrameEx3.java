package am;

import javax.swing.JFrame;

public class MyFrameEx3 extends JFrame {
	Canvas_Ex3 can;
	
	public MyFrameEx3() {
		
		can = new Canvas_Ex3();
		this.add(can);
		
		
		this.setBounds(300,200,600,600);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트 감지자 등록
		// 마우스 버튼을 누를 때의 이벤트를 캔버스에게 이벤트 감자자 등록한다.
		// 여기서 이벤트 감지자는 MyMouse가 된다. 그리고 MyMouse를 생성할 때
		// 반드시 MyFrame의 주소를 인자로 줘야 한다.
		// 고로 MyFrame은 현재 객체이므로 this로 칭할 수 있다.
		can.addMouseListener(new MyMouse3(this));
	}
	
	public static void main(String[] args) {
		new MyFrameEx3();

	}

}