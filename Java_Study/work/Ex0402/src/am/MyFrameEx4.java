package am;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyFrameEx4 extends JFrame{

	JPanel p;
	JCheckBox cb1,cb2,cb3,cb4;
	GridLayout gl;
	JTextArea ta;
	
	public MyFrameEx4() {
		gl = new GridLayout(5, 1);
		
		cb1 = new JCheckBox("항목1");
		cb2 = new JCheckBox("항목2");
		cb3 = new JCheckBox("항목3");
		cb4 = new JCheckBox("항목4");
		p = new JPanel(gl);
		
		p.add(cb1);
		p.add(cb2);
		p.add(cb3);
		p.add(cb4);
		
		//현재 창의 west영역에 p1을 추가한다
		this.add(p,BorderLayout.WEST);
		
		//현재 창의 가운데에 JTextArea를 추가한다
		this.add(ta=new JTextArea());
		
		this.setBounds(300, 200, 500, 600);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrameEx4();

	}

}
