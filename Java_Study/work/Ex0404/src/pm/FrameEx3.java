package pm;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FrameEx3 extends JFrame {
	
	ArrayList<Oval_Ex3> list = new ArrayList<Oval_Ex3>();
	
	Canvas can = new Canvas() {
		@Override
		public void paint(Graphics g) {
			for(int i =0;i<list.size();i++) {
				Oval_Ex3 ov = list.get(i);
				g.setColor(ov.c);
				g.fillOval(ov.x, ov.y, ov.wh, ov.wh);
			}
		}
	};
	
	public FrameEx3() {
		
		this.add(can);
		
		this.setBounds(200,100,500,500);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//마우스를 클릭할 때 즉, 마우스 이벤트 감지자를 등록
		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//클릭한 x,y좌표 값을 얻어낸다.
				int x=e.getX();
				int y=e.getY();
				
				//얻어낸 좌표값을 가지고 타원객체를 생성
				Oval_Ex3 ov =new Oval_Ex3(x, y);
				
				//생성된 타원객체를 ArrayList에 저장하자
				list.add(ov);
				
				// 캔버스를 다시 그린다.
				can.repaint();
			
			}
		});
	}
	
	public static void main(String[] args) {
		new FrameEx3();

	}

}
