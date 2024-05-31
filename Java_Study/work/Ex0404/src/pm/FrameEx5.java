package pm;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class FrameEx5 extends JFrame {
	Canvas_Ex5 can;
	
	public FrameEx5() {
		
		can=new Canvas_Ex5();
		this.add(can);
		
		this.setBounds(200,100,500,500);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		can.addKeyListener(new KeyAdapt_Ex5(this));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FrameEx5();
	}

}
