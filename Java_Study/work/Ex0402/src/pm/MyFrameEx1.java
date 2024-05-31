package pm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import am.MyWinEx1;

public class MyFrameEx1 extends JFrame implements ActionListener {

	JButton bt1,bt2,bt3;
	JPanel p1,p2;
	
	public MyFrameEx1() {
		p1 = new JPanel();
		p2 = new JPanel();
		
		bt1 = new JButton("Red");
		bt2 = new JButton("Green");
		bt3 = new JButton("Blue");
		
		p1.add(bt1);
		p1.add(bt2);
		p1.add(bt3);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p2);
		
		this.setBounds(300,200,500,600);
		this.setVisible(true);
		
		//이벤트 감지자 등록
		this.addWindowListener(new MyWinEx1());
		
		//bt1에게 이벤트감지자 등록
		bt1.addActionListener(this);
		//bt1을 클릭하면 this(현재객체)에서 무조건 actionPerformed를 호출
		
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		
	}
	
	 
	public static void main(String[] args) {
		//프로그램 시작
		new MyFrameEx1();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == bt1) 
			p2.setBackground(Color.RED);
		else if(obj == bt2)
			p2.setBackground(Color.GREEN);
		else if(obj == bt3)
			p2.setBackground(Color.BLUE);
		
	}

}
