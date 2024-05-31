package am;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrameEx3 extends JFrame {
	
	JButton bt;
	JTextField tf;
	JLabel label;
	JTextArea ta;
	JPanel p;
	
	 public MyFrameEx3() {
		 label = new JLabel("URL:");
		 tf = new JTextField(20);
		 bt = new JButton("확인");
		 ta = new JTextArea();
		 p = new JPanel();
		 
		 
		 
		 p.add(label);
		 p.add(tf);
		 p.add(bt);
		 
		 this.add(p,BorderLayout.NORTH);
		 this.add(ta);	
		 this.setBounds(300, 200, 500, 600);
		 this.setVisible(true);
		 this.addWindowListener(new MyWinEx1());
		 
	 }//생성자의 끝
	
	
	public static void main(String[] args) {
		new MyFrameEx3();

	}

}
