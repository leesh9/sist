package pm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Frame_Ex2 extends JFrame {
	
	Canvas can;
	
//	Canvas can = new Canvas() {
//		int cmd;
//		int x,y;
//		@Override
//		public void paint(Graphics g) {
//			g.setColor(Color.blue);
//			g.fillOval(50, 50, 100, 100);
//		}
//	};
	
	public Frame_Ex2() {
		this.add(can = new Canvas() {
			@Override
			public void paint(Graphics g) {
				g.setColor(Color.blue);
				g.fillOval(50, 50, 100, 100);
			}
		});
		this.setBounds(300, 100, 400, 400);
		this.setVisible(true);
		
		//이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//프로그램 종료
			}
		});
		
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		 new Frame_Ex2();

	}

}
