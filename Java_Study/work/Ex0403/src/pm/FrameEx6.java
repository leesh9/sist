package pm;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class FrameEx6 extends JFrame implements MouseListener{

	Canvas_Ex6 can;
	public FrameEx6(){
		
		this.setTitle("나만의 그림판");
		
		this.add(can=new Canvas_Ex6());
		
		this.setBounds(300,150,600,600 );
		this.setVisible(true);
		
		//바로 종료
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		can.addMouseListener(this);
		
	}
	
	public static void main(String[] args) {
		new FrameEx6();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//마우스를 누를 때 마다 수행하는 곳
		can.x = e.getX();
		can.y = e.getY();
		
		//캔버스를 다시 그린다.
		can.repaint(); // --> update() --> paint()
		//					   지우는 역활      그리는 역활
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
