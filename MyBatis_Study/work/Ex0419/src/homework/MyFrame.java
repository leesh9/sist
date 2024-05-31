package homework;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mysql.cj.Session;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MyFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id_tf;
	private JPasswordField pw_tf;
	CardLayout card;
	SqlSessionFactory factory;
	private JTextField search_tf;
	private JTable table;
	private JComboBox comboBox;
	List<EmpVO> list;
	private JTextField dept_search;
	private JTable table_1;
	private boolean islogin;
	
	List<DeptVO> d_list;
	private JTextField textField;
	private JTable table_2;
	
	List<LocVO> l_list;
	JComboBox comboBox_1;
	
	JComboBox comboBox_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
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
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 571);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Control");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("사원 정보");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(islogin) {
					totalEmp(null);
					card.show(contentPane, "card2");
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("부서 정보");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(islogin) {
				totalDept(null);
				card.show(contentPane, "card3");
				}else {
					JOptionPane.showMessageDialog(MyFrame.this, "로그인후 시도하세요");
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("도시정보");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(islogin) {
					totalLoc(null);
					card.show(contentPane, "card4");
				}else {
					JOptionPane.showMessageDialog(MyFrame.this, "로그인후 시도하세요");
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		card = new CardLayout();
		contentPane.setLayout(card);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "card1");
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MyFrame.class.getResource("/imagers/chat.png")));
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("ID: ");
		panel_2.add(lblNewLabel_1);
		
		id_tf = new JTextField();
		panel_2.add(id_tf);
		id_tf.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("PW: ");
		panel_3.add(lblNewLabel_2);
		
		pw_tf = new JPasswordField();
		panel_3.add(pw_tf);
		pw_tf.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_4);
		
		JButton login_bt = new JButton("LOGIN");
		login_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 사용자가 입력한 아이디와 비밀번호를 가져온다.
				String id = id_tf.getText().trim();
				String pw = new String(pw_tf.getPassword()).trim();
				
				// 아이디와 비밀번호가 입력되었는지 확인
				if(id.length()<1) {
					JOptionPane.showMessageDialog(MyFrame.this, "아이디를 입력하세요");
					id_tf.setText("");//입력란 지워주기
					id_tf.requestFocus();// 커서 가져다 놓기
					return;
				}
				
				if(pw.length()<1) {
					JOptionPane.showMessageDialog(MyFrame.this, "비밀번호를 입력하세요");
					pw_tf.setText("");//입력란 지워주기
					pw_tf.requestFocus();// 커서 가져다 놓기
					return;
				}
				
				MemberVO vo = login(id,pw);
				
				if(vo != null) {
					//emp 테이블에 있는 모든 자원들을 가져오는
					// 기능을 호출한다
					totalEmp(null);
					
					// 현재 창의 contentPane을 얻어내어
					// Layout을 얻어낸 후
					// 원하는 카드를 보여달라고 하면 된다.
					islogin = true;
					card.show(contentPane, "card2");
				}
			}
		});
		panel_4.add(login_bt);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, "card2");
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_6.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_6, BorderLayout.NORTH);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"사번", "이름", "직종", "부서"}));
		panel_6.add(comboBox);
		
		search_tf = new JTextField();
		search_tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchData();
			}
		});
		panel_6.add(search_tf);
		search_tf.setColumns(15);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchData();
			}
		});
		panel_6.add(btnNewButton);
		
		JButton add_bt = new JButton("추가");
		add_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyDialog(MyFrame.this);
			}
		});
		panel_6.add(add_bt);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 선택된 행의 번호를 얻어낸다.
				int row = table.getSelectedRow();
//				int col = table.getSelectedColumn();
//				
//				System.out.println(row+","+col);
				// 맴버 변수인 list에서 row 번째에 있는 EmpVO를
				// 얻어낸다
				EmpVO vo = list.get(row);
				
				new MyDialog(vo);
				
//				System.out.println(vo.getEname());
				
//				String n = (String)table.getValueAt(row, 1);
//				System.out.println(n);
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7, "card3");
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6_1 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6_1.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_7.add(panel_6_1, BorderLayout.NORTH);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"부서번호", "부서명", "도시번호"}));
		panel_6_1.add(comboBox_1);
		
		dept_search = new JTextField();
		dept_search.setColumns(15);
		panel_6_1.add(dept_search);
		
		JButton dept_search_bt = new JButton("검색");
		dept_search_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchDept();
				}
		});
		panel_6_1.add(dept_search_bt);
		
		JButton add_bt_1 = new JButton("추가");
		panel_6_1.add(add_bt_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_7.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_8 = new JPanel();
		contentPane.add(panel_8, "card4");
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6_2 = new JPanel();
		panel_8.add(panel_6_2, BorderLayout.NORTH);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"도시코드", "도시"}));
		panel_6_2.add(comboBox_2);
		
		textField = new JTextField();
		textField.setColumns(15);
		panel_6_2.add(textField);
		
		JButton btnNewButton_2 = new JButton("검색");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchLoc();
			}
		});
		panel_6_2.add(btnNewButton_2);
		
		JButton add_bt_2 = new JButton("추가");
		panel_6_2.add(add_bt_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_8.add(scrollPane_2, BorderLayout.CENTER);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		makeFactory();
	}
	
	private void makeFactory() {
		try {
			Reader r = Resources.getResourceAsReader("homework/config.xml");
			factory =new SqlSessionFactoryBuilder().build(r);
			r.close();
			this.setTitle("준비완료!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private MemberVO login(String id,String pw) {
		SqlSession ss = factory.openSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("key_id", id);
		map.put("key_pw", pw);
		
		MemberVO vo = ss.selectOne("member.login",map);
		if(ss!=null)
			ss.close();
		
		return vo;
	}
	
	public void totalEmp(Map map) {
		// MyBatis 환경의 SQL문을 호출하기 위해
		// SqlSession을 준비하자
		SqlSession ss = factory.openSession();
		list = ss.selectList("emp.search",map);
		
		//받은 list를 JTable로 표현해야 한다.
		viewEmpTable();
		ss.close();
	}
	
	private void viewEmpTable() {
		String[] c_name = {"사번","이름","직종","부서코드"};
		
		//인자로 받은 list를 2차원 배열로 만들어봐자!
		String[][] data =new String[list.size()][c_name.length];
		
		for(int i=0;i<data.length;i++) {
			//list로부터 EmpVO를 하나 얻어낸다.
			EmpVO vo = list.get(i);
			
			//얻어낸 사원 정보를 JTable에 하나의 행으로 표현하기
			// 위해 1차원 배열에 채워넣는다.
			data[i][0] = vo.getEmpno();// 사번
			data[i][1] = vo.getEname();//이름
			data[i][2] = vo.getJob();//직종
			data[i][3] = vo.getDeptno();//부서코드
		}
		table.setModel(new DefaultTableModel(data,c_name));
	}
	
	private void searchData() {
		// TODO Auto-generated method stub
		int k =comboBox.getSelectedIndex();
		String key = null;
		String value = search_tf.getText().trim();
		if(value.length()>0) {
			switch (k) {
			case 0: 
				key="empno";
				break;
			case 1:
				key="ename";
				break;
			case 2:
				key="job";
				break;
			case 3:
				key = "deptno";
				break;
			}
			search_tf.setText("");
			Map<String,String> map = new HashMap<>();
			map.put(key, value);
			totalEmp(map);
		}
	}
	
	//추가하는 기능 : MyDialog에서 저장버튼을 클릭했을 때 호출
	public int addEmp(EmpVO vo) {
		SqlSession ss = factory.openSession();
		//기본적으로 factory를 통해 openSession()을 호출하면
		//commit이 false이며 openSession(true)을 호출하면
		//자동 commit이 적용된다
		int cnt = ss.insert("emp.add",vo);
		
		if(cnt>0)
			ss.commit();
		else
			ss.rollback();
		
		//cnd가 0보다 크다면 저장성공
		if(ss != null)
			ss.close();
		return cnt;
	}
	
	public void totalDept(Map map) {
		SqlSession ss = factory.openSession();
		d_list = ss.selectList("dept.search",map);
		viewDeptTable();
	}
	
	private void viewDeptTable() {
		String[] c_name = {"부서코드","부서명","지역코드"};
		
		//인자로 받은 list를 2차원 배열로 만들어봐자!
		String[][] data =new String[d_list.size()][c_name.length];
		
		for(int i=0;i<d_list.size();i++) {
			//list로부터 EmpVO를 하나 얻어낸다.
			DeptVO vo = d_list.get(i);
			
			//얻어낸 사원 정보를 JTable에 하나의 행으로 표현하기
			// 위해 1차원 배열에 채워넣는다.
			data[i][0] = vo.getDeptno();// 부서코드
			data[i][1] = vo.getDname();//부서명
			data[i][2] = vo.getLoc_code();//지역코드
		}
		table_1.setModel(new DefaultTableModel(data,c_name));
	}
	
	public void totalLoc(Map map) {
		SqlSession ss = factory.openSession();
		l_list = ss.selectList("location.search", map);
		viewLocTable();
	}
	
	public void viewLocTable() {
		String[] c_name={"도시코드","도시"};
		
		String[][] data = new String [l_list.size()][c_name.length];
		
		for(int i=0;i<l_list.size();i++) {
			LocVO vo = l_list.get(i);
			
			data[i][0] = vo.getLoc_code();
			data[i][1] = vo.getCity();
		}
		table_2.setModel(new DefaultTableModel(data,c_name));
	}
	
	public void searchDept() {
		int idx = comboBox_1.getSelectedIndex();
		String value = dept_search.getText();
		String key=null;
		switch (idx) {
			case 0:
				key="deptno";
				break;
			case 1:
				key="dname";
			case 2:
				key="loc_code";
				
		}
		dept_search.setText("");
		Map<String, String> map = new HashMap<>();
		map.put(key, value);
		totalDept(map);
	}
	
	public void searchLoc() {
		int idx = comboBox.getSelectedIndex();
		String key = null;
		String value = textField.getText();
		switch (idx) {
			case 0:
				key = "loc_code";
				break;
			case 1:
				key = "city";
				break;
		}
		textField.setText("");
		Map<String, String> map = new HashMap<>();
		map.put(key, value);
		totalLoc(map);
	}
	
}
