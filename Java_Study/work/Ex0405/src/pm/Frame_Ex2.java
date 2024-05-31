package pm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame_Ex2 extends JFrame {
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
				//도형이 그려진 이미지 객체를 현재 JPanel에 그리자
			}
			g.drawImage(buf, 0, 0, this);
		}
		
		@Override
		public void update(Graphics g) {
			paint(g);
		}
		
		
	};
	
	public Frame_Ex2() {
		this.add(p);
		
		this.setBounds(300, 100, 500, 500);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		p.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
				//내부클래스에서 바깥쪽클래스를 지칭할 때는
				//반드시 바깥쪽클래스명.this라고한다.
				//MyOval mo = new  MyOval(x, y,Frame_Ex2.this);
				MyOval mo = new  MyOval(x, y,p);
				mo.start();
				list.add(mo);
			}
		});
	}
	
	public static void main(String[] args) {
		new Frame_Ex2();

	}

}
