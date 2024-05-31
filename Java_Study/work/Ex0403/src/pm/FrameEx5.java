package pm;

import javax.swing.JFrame;

public class FrameEx5 extends JFrame {
	
	//캔버스를 상속받은 객체 선언
	Canvers_Ex5 can;
	public FrameEx5(){
		
		this.setTitle("나만의 그림판");
		
		this.add(can=new Canvers_Ex5());
		
		this.setBounds(300,150,600,600);
		this.setVisible(true);
		
		//바로 종료
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new FrameEx5();

	}

}
