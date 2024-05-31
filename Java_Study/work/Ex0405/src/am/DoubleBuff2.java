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

public class DoubleBuff2 extends JFrame {

	int x =210;
	
	JPanel p =new JPanel() {
		
		@Override
		public void paint(Graphics g) {
			Image buf = createImage(this.getWidth(), this.getHeight());
			//준비된 이미지 객체에만 그림을 그릴 수 있는 붓을 얻어내다.
			Graphics buf_g = buf.getGraphics();
			
			buf_g.setColor(Color.GREEN);
			buf_g.fillRect(x, 235, 80, 30);
			
			//이미지 객체를 현재 캔버스의 x:0,y:0에 그린다.
			g.drawImage(buf, 0, 0, this); 
		}
	};
	
	public DoubleBuff2() {
		
		this.add(p);
		
		this.setBounds(300,100,500,500);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);// 프로그램 종료
		}
		});
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				
				switch(code) {
				case KeyEvent.VK_LEFT:
					x -=5;
					if(x<0)
						x=0;
					break;
				case KeyEvent.VK_RIGHT:
					x+=5;
					if(x>p.getWidth()-80)
						x=p.getWidth()-80;
				}
				p.repaint();
			}
			});
	}
	
	
	public static void main(String[] args) {
		new DoubleBuff2();
	}

}
