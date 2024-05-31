package pm;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWin implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("열림");

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 창의 x버튼을 클릭할 때마다 수행(호출) 하는곳
		System.exit(0);//지금 바로 프로그램 종료!!

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
