package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import am.MyWinEx1;

public class MyFrameEx3 extends JFrame implements ActionListener{
	
	JTextField tf;
	JButton bt;
	JTextArea ta;
	JPanel p;
	
	public MyFrameEx3() {
		p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tf = new JTextField(5);
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
		new MyFrameEx3();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String str = this.tf.getText().trim();
		// 사용자가 입력한 문자열 str에 문자가 있는지? 판단하는 반복문!11
		boolean chk = false;
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);//문자 추출
			if(ch<'0'||ch>'9') {
				//문자인 경우
				chk = true;
				break;//가장 가까운 반복문 탈출
			}
		}//문자체크 반복문의 끝
		
		if(chk) {
			JOptionPane.showMessageDialog(this, "문자가 있어 숫자로 변경하지 못했습니다");
			return;
		}
		
		int dan = Integer.parseInt(str);
		
		StringBuffer sb = new StringBuffer(dan+"단");
		sb.append("\r\n");
		
		for(int i=1;i<=9;i++) {
			sb.append(dan);
			sb.append("*");
			sb.append(i);
			sb.append("=");
			sb.append(dan*i);
			sb.append("\r\n");
		
		}
		ta.setText(sb.toString());
		
	}

}
