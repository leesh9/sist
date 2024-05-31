package homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test1 extends JFrame {
	
	JButton left_bt,center_bt, right_bt;
	JPanel p1;
	
	public Test1() {
		//버튼들 생성
		left_bt = new JButton("Left");
		center_bt = new JButton("Center");
		right_bt = new JButton("Right");
		
		p1 = new JPanel();
		p1.add(left_bt);
		p1.add(center_bt);
		p1.add(right_bt);
		
		this.add(p1,BorderLayout.NORTH);//"North"
		
		
		this.setBounds(300, 100, 500, 400);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			// 현재 역역은 WindowAdapter를 상속받는 이름없는 내부 클래스다.
			// class ? extends WindowAdapter{}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		left_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// left_bt를 클릭했을 때만 수행하는 곳
				p1.setLayout(new FlowLayout(FlowLayout.LEFT));
				p1.revalidate();
			}
		});
		
		center_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// left_bt를 클릭했을 때만 수행하는 곳
				p1.setLayout(new FlowLayout(FlowLayout.CENTER));
				p1.revalidate();
			}
		});
		
		right_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// left_bt를 클릭했을 때만 수행하는 곳
				p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
				p1.revalidate();
			}
		});
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Test1();

	}

}
