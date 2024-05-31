package am;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class DoubleBuff extends JFrame {
	
	int x=50;	
	
		Canvas can = new Canvas() {
			@Override
			public void paint(Graphics g) {
			// TODO Auto-generated method stub
//			g.setColor(Color.green);
//			g.fillRect(x, 235, 80, 30);
				Image buf = createImage(this.getWidth(), this.getHeight());
				//준비된 이미지 객체에만 그림을 그릴 수 있는 붓을 얻어내다.
				Graphics buf_g = buf.getGraphics();
				
				buf_g.setColor(Color.GREEN);
				buf_g.fillRect(x, 235, 80, 30);
				
				//이미지 객체를 현재 캔버스의 x:0,y:0에 그린다.
				g.drawImage(buf, 0, 0, this);
			}
			
			@Override
			public void update(Graphics g) {
				paint(g);
			}
		};
		
		public DoubleBuff() {
			this.add(can);
			
			this.setBounds(300, 100, 500, 600);
			this.setVisible(true);
			
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			
			//현재 창에서 키를 누를때 이밴트 감지자 등록
			
			can.addKeyListener(new KeyAdapter() {
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
					if(x>can.getWidth()-80)
						x=can.getWidth()-80;
				}
				can.repaint();
			}
			});
		}
	public static void main(String[] args) {
		new DoubleBuff();
	}

}
