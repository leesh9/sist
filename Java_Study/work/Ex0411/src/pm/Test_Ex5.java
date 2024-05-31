package pm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Test_Ex5 extends JFrame {
	
	JTextArea textArea;
	ArrayList<DataVO_Ex5> list = new ArrayList<DataVO_Ex5>();
	
	String path ="c:/my_Study/test.txt";
	File f =new File(path);

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test_Ex5 frame = new Test_Ex5();
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
	public Test_Ex5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel p1 = new JPanel();
		contentPane.add(p1, BorderLayout.WEST);
		p1.setLayout(new GridLayout(0,1));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		p1.add(panel);
		
		JLabel lblNewLabel = new JLabel("사번");
		panel.add(lblNewLabel);
		
		t1 = new JTextField();
		panel.add(t1);
		t1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		p1.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		panel_1.add(lblNewLabel_1);
		
		t2 = new JTextField();
		panel_1.add(t2);
		t2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		p1.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("부서");
		panel_2.add(lblNewLabel_2);
		
		t3 = new JTextField();
		panel_2.add(t3);
		t3.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		p1.add(panel_3);
		
		JLabel lb1 = new JLabel("직책");
		panel_3.add(lb1);
		
		t4 = new JTextField();
		panel_3.add(t4);
		t4.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		p1.add(panel_4);
		
		JLabel lb3 = new JLabel("입사일");
		panel_4.add(lb3);
		
		t5 = new JTextField();
		panel_4.add(t5);
		t5.setColumns(10);
		
		JPanel p2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(p2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("전체");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.append(" 사번 | 이름  |  부서  | 직책 |  입사일");
				textArea.append("\r\n");
				textArea.append("------------------------------------------------------");
				textArea.append("\r\n");
				ObjectInputStream ois = null;
				try {
					ois = new ObjectInputStream(new FileInputStream(f));
					Object obj = ois.readObject();
					if(obj instanceof ArrayList) {
						list =(ArrayList<DataVO_Ex5>)obj;
						
						for(int i=0;i<list.size();i++) {
							DataVO_Ex5 vo = list.get(i);
							textArea.append(" ");
							textArea.append(vo.getNum());
							textArea.append(" ");
							textArea.append(vo.getName());
							textArea.append(" ");
							textArea.append(vo.getTeam());
							textArea.append(" ");
							textArea.append(vo.getPos());
							textArea.append(" ");
							textArea.append(vo.date);
							textArea.append("\r\n");
						}
						
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		p2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("추가");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = t1.getText().trim();
				String name = t2.getText().trim();
				String team = t3.getText().trim();
				String pos = t4.getText().trim();
				String date = t5.getText().trim();
				if(num.isEmpty()) {
					JOptionPane.showMessageDialog(Test_Ex5.this, "사번을 입력하세요!");
				}else if(name.isEmpty()) {
					JOptionPane.showMessageDialog(Test_Ex5.this, "이름을 입력하세요!");
				}else if(team.isEmpty()) {
					JOptionPane.showMessageDialog(Test_Ex5.this, "부서를 입력하세요!");
				}else if(pos.isEmpty()) {
					JOptionPane.showMessageDialog(Test_Ex5.this, "직책을 입력하세요!");
				}else if(date.isEmpty()) {
					JOptionPane.showMessageDialog(Test_Ex5.this, "입사일을 입력하세요!");
				}else {
					DataVO_Ex5 d = new DataVO_Ex5(num, name, team, pos, date);
					list.add(d);
					ObjectOutputStream oos=null;
					try {
						oos=new ObjectOutputStream(new FileOutputStream(f));
						oos.writeObject(list);
						oos.flush();
						System.out.println("저장완료!");
					} catch (Exception e2) {
						e2.printStackTrace();
					}finally {
						try {
							if(oos!=null)
								oos.close();
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
				}
				
			}
		});
		p2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("삭제");
		p2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("검색");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		p2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("종료");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjectOutputStream oos=null;
				try {
					oos=new ObjectOutputStream(new FileOutputStream(f));
					oos.writeObject(list);
					oos.flush();
					System.out.println("종료!");
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally {
					try {
						if(oos!=null)
							oos.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				System.exit(0);
			}
		});
		p2.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

}
