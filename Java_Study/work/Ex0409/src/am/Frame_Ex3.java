package am;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Frame_Ex3 extends JFrame {

	//화면에 필요한 객체들을 모두 맴버로 선언
	JTextField url_tf;
	JButton bt;
	JPanel north_p;
	
	JList<String> center_list;
	
	public Frame_Ex3() {
		
		//화면 구성
		north_p = new JPanel(new BorderLayout());
		//JPanel이 원래는 FlowLayout이었지만 BordeLayout으로 변경함
		north_p.add(new JLabel("URL:"),BorderLayout.WEST);
		north_p.add(url_tf=new JTextField());
		north_p.add(bt=new JButton("확인"),BorderLayout.EAST);
		
		// north_p를 현재 창의 north 영역에 추가
		this.add(north_p,BorderLayout.NORTH);
		
		this.add(new JScrollPane(center_list=new JList<String>()));
		
		
		this.setBounds(300,100,500,600);
		this.setVisible(true);
		
		//이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//확인버튼을 클릭 할 때마다 수행할 것들을 이벤트로 걸어준다.
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 사용자가 입력한 경로를 가져온다.
				action1();
			}
		});
		
		center_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스를 클릭한 카운트를 얻어낸다.
				int cnt = e.getClickCount();
				
				if(cnt==2) {
					//더블클릭할 때만 수행하는 곳
					//선택된 항목을 얻어낸다.
					String v  = center_list.getSelectedValue();
					String p_str = url_tf.getText();
					
					char ch = p_str.charAt(p_str.length()-1);
					if(ch=='/') {
						url_tf.setText(p_str+v);
					}else {
						url_tf.setText(p_str+"/"+v);
					}
						
					action1();
				}
				
			}
		});
		
	}
	
	private void action1() {
		String path = url_tf.getText().trim();
		
		// path가 비어 있으면 안된다.
		if(path.length()==0) {
			// 경고창 (메세지 창) 보여주기
			JOptionPane.showMessageDialog(Frame_Ex3.this,"입력된 값이 없습니다.");
		}else {
			//잘 입력한 경우는 사용자가 입력한 값을 얻어낸 값을 가지고
			//File객체를 생성하자!
			viewList(path);
		}
	}
	
	private void viewList(String path) {
		File f = new File(path);
		
		//생성된 f가 디랙토리 인지? 판단하자!
		if(f.exists()) {
			if(f.isDirectory()) {
				// 하위목록을 얻어낸다.
				String[] sub = f.list();
				
				//얻어낸 배열을 가지고 JList 를 생성한다.
				center_list.setListData(sub);
			}else {
				JOptionPane.showMessageDialog(Frame_Ex3.this,"폴더를 입력하세요.");
			}
		}else {
			JOptionPane.showMessageDialog(Frame_Ex3.this,"존재하지 않습니다.");
			
		}
	}
	
	public static void main(String[] args) {
		new Frame_Ex3();

	}

}
