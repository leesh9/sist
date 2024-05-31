package am;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame_Ex6 extends JFrame {
int x = 200;
int y = 200;
Thread_Ex6 t1;
	
	JPanel p =new JPanel() {
		@Override
		public void paint(Graphics g) {
			//임시 이미지 객체
			Image buf = createImage(this.getWidth(),this.getHeight());
			
			//준비된 이미지 객체에만 그림을 그릴 수 있는 붓과 같은 객체
			Graphics bufG = buf.getGraphics();
			// 임시 이미지 객체에 도형 그리기
			bufG.setColor(Color.RED);
			bufG.fillOval(x, y, 50, 50);
			
			//도형이 그려진 이미지 객체를 현재 JPanel에 그리자
			g.drawImage(buf, 0, 0, this);
			
		}
		
		@Override
		public void update(Graphics g) {
			paint(g);
		
		}
	};
	
	public Frame_Ex6() {
		this.add(p);
		
		this.setBounds(300, 100, 500, 450);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override  
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);//프로그램 종료
			}
		});
		
		t1 = new Thread_Ex6(this);
		t1.start();
		
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int cmd = e.getKeyCode();
				System.out.println(cmd);
				if(cmd == KeyEvent.VK_SPACE) {
					t1.go();
				}else if(cmd>=37 && cmd <=40) {
					System.out.println("1");
					t1.cmd =cmd;
				}
			}
		
		});
	}
	
	public static void main(String[] args) {
		new Frame_Ex6();
	}
	
}
