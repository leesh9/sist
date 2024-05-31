package pm;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import am.MyWinEx1;

public class MyFrameEx4 extends JFrame {

	JLabel lb1,lb2,lb3,lb4;
	JPanel p;
	
	public MyFrameEx4() {
		p = new JPanel();
		
		ImageIcon icon1 = new ImageIcon("src/images/mail.png");
		
		//생성된 이미지 아이콘을lb1생성할 때 넣어준다.
		lb1 = new JLabel(icon1);
		p.add(lb1);
		
		ImageIcon icon2 = new ImageIcon("src/images/blog.png");
		
		lb2 = new JLabel(icon2);
		p.add(lb2);
		
		ImageIcon icon3 = new ImageIcon("src/images/cafe.png");
		
		lb3 = new JLabel(icon3);
		p.add(lb3);
		
		ImageIcon icon4 = new ImageIcon("src/images/blog.png");
		
		lb4 = new JLabel(icon4);
		p. add(lb4);
		
		this.add(p);
		
		this.setBounds(300,200,350,250);
		this.setVisible(true);
		this.addWindowListener(new MyWinEx1());
	}
	
	public static void main(String[] args) {
		new MyFrameEx4();

	}

}
