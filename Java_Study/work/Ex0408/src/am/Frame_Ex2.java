package am;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame_Ex2 extends JFrame {

	JButton bt_red, bt_green,bt_yello;
	
	//스레드들이 수행 할 일을 가진 객체(Runnable)
	Runnable_Ex2 rx ;
	
	public Frame_Ex2(){
		this.setTitle("신호등 동기화");
		
		//레이아웃을 1행 3열로 지정 
		this.setLayout(new GridLayout(1,3));
		bt_red = new JButton();
		bt_red.setBackground(Color.red);
		
		bt_green = new JButton();
		bt_green.setBackground(Color.green);
		
		bt_yello = new JButton();
		bt_yello.setBackground(Color.yellow);
		
		this.add(bt_red);
		this.add(bt_green);
		this.add(bt_yello);
		
		this.setBounds(200,200,300,150);
		this.setResizable(false);
		this.setVisible(true);
		
		rx = new Runnable_Ex2(this);
		Thread t1 = new Thread(rx,"R");
		t1.start();
		
		Thread t2 = new Thread(rx,"G");
		t2.start();
		
		Thread t3 = new Thread(rx,"Y");
		t3.start();
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Frame_Ex2();

	}

}
