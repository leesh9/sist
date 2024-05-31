package am;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame_Ex5 extends JFrame {
	
	int x = 0;
	
	JPanel p =new JPanel() {
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			Image buf = createImage(this.getWidth(),this.getHeight());
			
			//준비된 이미지 객체에만 그림을 그릴 수 있는 붓과 같은 객체
			Graphics bufG = buf.getGraphics();
			bufG.setColor(Color.RED);
			bufG.fillOval(x, 245, 50, 50);
			g.drawImage(buf, 0, 0, this);
		}
		
		@Override
		public void update(Graphics g) {
			paint(g);
		
		}
	};
	
	public Frame_Ex5() {
		this.add(p);
		
		this.setBounds(300, 100, 500, 450);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		Thread_Ex5 t1 = new Thread_Ex5(this);
		
		t1.start();
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Frame_Ex5();
		

	}

}
