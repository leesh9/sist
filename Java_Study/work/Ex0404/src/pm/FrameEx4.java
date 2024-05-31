package pm;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameEx4 extends JFrame implements ActionListener {
	JButton bt1,bt2,bt3;
	JPanel p1;
	public FrameEx4() {
		
		bt1=new JButton("L");
		bt2=new JButton("c");
		bt3=new JButton("r");
		
		p1 =new JPanel();
		
		p1.add(bt1);
		p1.add(bt2);
		p1.add(bt3);
		
		this.add(p1);
		
		this.setBounds(300, 100, 500, 500);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new FrameEx4();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==bt1) {
			p1.setLayout(new FlowLayout(FlowLayout.LEFT));
			p1.revalidate();
		}else if(obj==bt2) {
			p1.setLayout(new FlowLayout(FlowLayout.CENTER));
			p1.revalidate();
		}else if(obj==bt3) {
			p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
			p1.revalidate();
		}
		
	}

}
