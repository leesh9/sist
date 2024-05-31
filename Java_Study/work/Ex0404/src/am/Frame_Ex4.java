package am;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Frame_Ex4 extends JFrame implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 키보드의 키를 누를 때마다 수행하는곳
		int code = e.getKeyCode();
		char ch = e.getKeyChar();
		
		this.setTitle(code+":"+ch);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public Frame_Ex4() {
		
		
		this.setBounds(300, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addKeyListener(this);
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Frame_Ex4();

	}

}
