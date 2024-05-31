package pm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameEx1 extends JFrame {
	ArrayList<MyOval> list = new ArrayList<MyOval>();
	JPanel p = new JPanel() {
		@Override
		public void paint(Graphics g) {
			Image buf = createImage(this.getWidth(), this.getHeight());
			Graphics buf_g = buf.getGraphics();
			for(int i=0;i<list.size();i++) {
				MyOval ov=list.get(i);
				buf_g.setColor(ov.c);
				buf_g.fillOval(ov.x,ov.y, ov.wh, ov.wh);
			}
			g.drawImage(buf, 0, 0, this);
		}
		
		@Override
		public void update(Graphics g) {
			paint(g);
		}
	};
	
	public FrameEx1() {
		this.add(p);
		
		this.setBounds(300, 100, 700, 500);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		Thread t1= new Thread() {
			int num = p.getWidth();
			@Override
			public void run() {
				while(true) {
					int x=(int)(Math.random()*num);
					int y=-100;
					MyOval mo = new  MyOval(x, y,p);
					mo.start();
					list.add(mo);
					try {
						sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};
		t1.start();
	}
	
	public static void main(String[] args) {
		new FrameEx1();

	}

}
