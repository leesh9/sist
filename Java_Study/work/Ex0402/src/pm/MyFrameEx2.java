package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import am.MyWinEx1;

public class MyFrameEx2 extends JFrame implements ActionListener {
	
	JTextField tf;
	JButton bt;
	JTextArea ta;
	JPanel p;
	
	public MyFrameEx2() {
		p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tf = new JTextField(10);
		bt = new JButton("확인");
		p.add(tf);
		p.add(bt);
		
		
		
		//p1을 현재 객체의 North영역에 추가
		this.add(p,BorderLayout.NORTH);
		
		ta = new JTextArea();
		this.add(new JScrollPane(ta));
		
		this.setBounds(300,200,500,500);
		this.setVisible(true);
		this.addWindowListener(new MyWinEx1());
		
		bt.addActionListener(this);
		tf.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new MyFrameEx2();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = this.tf.getText();
		ta.append(msg);
		ta.append("\r\n");
	}

}
