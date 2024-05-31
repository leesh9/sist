package homework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LottoEx1 extends JFrame implements ActionListener{
	
	JPanel north_p, center_p;
	JButton bt;
	int[] ar = new int[6];
	
	public LottoEx1() {
		
		//화면구성
		north_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		north_p.add(bt = new JButton("생성"));
		
		//버튼을 오른쪽 정렬로 배치한 north_p를
		//현재 창의 North영역에 추가한다.
		this.add(north_p,BorderLayout.NORTH);
		
		center_p = new JPanel() ;
		//현재 창의 가운데에 center_p를 생성하여 추가한다.
		this.add(center_p);
		
		this.setBounds(200,100,800,200);
		this.setVisible(true);
		this.addWindowListener(new Mywin());
		
		bt.addActionListener(this);
	}
	
	public static void main(String[] args) {
		//프로그램 시작
		new LottoEx1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 생성 버튼을 클릭 할 때 마다 수행하는 곳!!
		
		// 배열을 생성하여 난수를 저장한다. 물론 중복 체크까지 수행한다.
		setAr();
		setLabel();// 난수가 모두 만들어진 배열을 가지고 
		//            ImageIcon생성 후 JLable생성하여
		//            center_p에 추가하는 동작
		
	}
	
	private void setLabel() {
		center_p.removeAll();
		for(int i=0; i<ar.length;i++) {
//			String path ="src/images/"+ar[i]+".gif";
			StringBuffer sb = new StringBuffer("src/images/");
			sb.append(ar[i]);
			sb.append(".gif");
			
			//위의 경로를 가지고 ImageIcon을 생성하자
			ImageIcon icon = new ImageIcon(sb.toString());
			
			//위의 ImageIcon을 가지고 JLabel을 생성하자
			JLabel lb = new JLabel(icon);
			
			//위의 JLabel을 center_p에 추가
			center_p.add(lb);
		}
		center_p.revalidate();
	}
	
	private void setAr() {
		//배열은 생성자에서 생성되었으므로 생항할 필요는 없다.
		int i = 0;
		p:while(i<ar.length) {
			ar[i]=(int)(Math.random()*45+1);
			for(int j=0;j<i;j++) {
				if(ar[i]==ar[j]) {
					continue p;
				}
			}
			i++;
		}
	}
}
