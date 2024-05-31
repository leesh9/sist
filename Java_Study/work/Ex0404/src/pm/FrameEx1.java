package pm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class FrameEx1 extends JFrame implements KeyListener{
	
	Canvas_Ex1 can;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int i = e.getKeyCode();
		can.cmd=i;
		can.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public FrameEx1(){
		
		can=new Canvas_Ex1();
		this.add(can);
		
		this.setBounds(200,300,600,550);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addKeyListener(new KeyAdaptEx1(this));
	}
	
	public static void main(String[] args) {
		new FrameEx1();

	}

}
