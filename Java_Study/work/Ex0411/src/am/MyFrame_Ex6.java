package am;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrame_Ex6 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	File f; //선택된 파일객체
	JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame_Ex6 frame = new MyFrame_Ex6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame_Ex6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 539);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("파일");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("새파일");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("열기");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser("c:/my_study");
				
				int cmd = jfc.showOpenDialog(MyFrame_Ex6.this);
				
				//cmd가 0이면 Approve옵션과 같다면
				if(cmd == JFileChooser.APPROVE_OPTION) {
					//열기 버튼을 선택했을 때 이 [열기] 버튼을 파일을
					//선택하지 않고는 누를 수 없다
					//그래서 사용자가 선택한 파일을 얻어내야한다.
					f = jfc.getSelectedFile();

					
					//위의 파일과 스트림을  연결하여 생성하자!
					BufferedReader br = null;
					try {
						br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
						String str = null;
						while((str=br.readLine())!=null) {
							textArea.append(str);
							textArea.append("\r\n");
						}
						textArea.setCaretPosition(0);//화면이동
					} catch (Exception e2) {
						// TODO: handle exception
					}finally {
						try {
							if(br != null)
								br.close();
						} catch (Exception e3) {
							e3.printStackTrace();
						}
					}
				}
				
				//
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("저장");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 파일이 이미 열려있는 상태라면 그대로 저장한다.
				// 그렇지 않을 때만 파일 선택기를 생성하고 보여줘야 한다.
				BufferedWriter bw = null;
				if(f!=null) {
					//바로 저장하기
					try {
						bw = new BufferedWriter(new PrintWriter(f));
						
						//저장할 자원은 JTextArea에 있는 문자열들이다.
						String str = textArea.getText();
						
						//이제 준비된 스트림을 통해 저장하자!
						bw.write(str);
						bw.flush();
						
					}catch (Exception e2) {
						// TODO: handle exception
					}finally {
						if(bw!=null)
							try {
								bw.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
				}else {
					//파일선택기 생성
					JFileChooser jfc = new JFileChooser("c:/my_study");
					int cmd = jfc.showSaveDialog(MyFrame_Ex6.this);
					if(cmd==JFileChooser.APPROVE_OPTION) {
						f=jfc.getSelectedFile();
						saveData();
						
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("종료");
		mnNewMenu.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
	
	
	private void saveData() {
		//스트림 준비
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new PrintWriter(f));
			
			//저장할 자원들은 모두 textArea에 있다.
			String str = textArea.getText();
			bw.write(str);//저장하기
			bw.flush();
			//타이틀 변경
			this.setTitle(f.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
