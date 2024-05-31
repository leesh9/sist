package pm;

import javax.swing.JFrame;

public class MyFrameEx5 extends JFrame{
	
	MywinAdap mw = new MywinAdap();
	
	public MyFrameEx5() {
		
		this.setSize(500,600);//창의 크기설정
		this.setLocation(700, 250);
		this.setVisible(true);
		
		this.addWindowListener(mw);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrameEx5();
	}

}
