package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import am.MyWinEx1;

public class Lotto extends JFrame implements ActionListener {
	
	int[] lotto = new int[6];
	JButton bt;
	JPanel p1,p2;
	JLabel[] lb = new JLabel[6];
	
	
	
	public Lotto() {
		p1= new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bt = new JButton("생성");
		p1.add(bt);
		this.add(p1,BorderLayout.NORTH);
		
		p2 =  new JPanel();
		for(int i = 0;i<lb.length;i++) {
			lb[i] = new JLabel();
			p2.add(lb[i]);
		}
		setLabel();
		this.add(p2);
		
		
		
		this.setBounds(300,200,500,500);
		this.setVisible(true);
		this.addWindowListener(new MyWinEx1());
		bt.addActionListener(this);
	}
	
	public static void main(String[] args) {
		Lotto lot = new Lotto();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setLabel();
	}
	
	private void setLabel() {
		setLotto();
		for(int j=0;j<lotto.length;j++) {
			StringBuffer sb = new StringBuffer("src/lotto/"); 
			sb.append(lotto[j]);
			sb.append(".gif");
			ImageIcon icon = new ImageIcon(sb.toString());
			lb[j].setIcon(icon);
		}
		
	}
	
	private void setLotto() {
	//1~45까지의 수들 중 난수를 발생하여 lotto라는 배열에
		//저장시킨다.단, 중복이 되어서는 안된다.
		System.out.println("로또번호 추첨");	
			
		int i =0;
		
		p:while(i<lotto.length) {
			lotto[i]=(int)(Math.random()*45+1);
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					continue p;
				}
			}
			System.out.printf("%3d",lotto[i]);
			i++;
		}
		System.out.println("\r\n");
	}

}
