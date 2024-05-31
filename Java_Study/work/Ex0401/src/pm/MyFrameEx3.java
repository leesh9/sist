package pm;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class MyFrameEx3 extends JFrame implements WindowListener{
	//is a 관계
	
	
	public MyFrameEx3() {
		// 기본 생성자
		// 생성자의 목적 : 맴버변수들에 대한 초기화
		
		this.setSize(500,600);
		this.setVisible(true);
		
		//창의 x버튼을 클릭하는 것을 이벤트 감지자 등록
		this.addWindowListener(this);
		
	}
	public static void main(String[] args) {
		
		MyFrameEx3 f = new MyFrameEx3();
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// x버튼을 클릭할 때마다 수행 하는 곳
		System.exit(0);//프로그램 종료!
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
