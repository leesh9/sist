package homework;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Test2 extends JFrame {
	
	int x=100;
	int y=100;
	
	Canvas can=new Canvas() {
		//Canvas를 상속받는 이름없는 내부클래스다.
		@Override
		public void paint(Graphics g) {
			g.setColor(Color.orange);
			g.fillOval(x, y, 50, 50);
			
		}
	};
	public Test2() {
		
		this.add(can);
		//현재 창의 가운데에 켄버스를 추가한다.
		this.setBounds(200,100,500,500);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		can.addKeyListener(new KeyAdapter() {
		// 사용자가 누르는 키의 코드값을 입력한다
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int code=e.getKeyCode();
				switch (code) {
				case KeyEvent.VK_UP: {
					y-=5;
					break;
				}
				case KeyEvent.VK_DOWN: {
					y+=5;
					break;
				}
				case KeyEvent.VK_LEFT: {
					x-=5;
					break;
				}
				case KeyEvent.VK_RIGHT: {
					x+=5;
					int w = can.getWidth();
					if(x>w-50)
						x=w-50;
					break;
				}
			}
				can.repaint();
			}
		});
		
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Test2();

	}

}
