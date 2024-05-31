package homework;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class MyFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id_tf;
	private JPasswordField pw_tf;
	CardLayout card;
	SqlSessionFactory factory;
	private JTable table;
	private JTextField textField;
	
	
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
					// 현재 창의 contentPane을 얻어내어
					// Layout을 얻어낸 후
					// 원하는 카드를 보여달라고 하면 된다.
					card.show(contentPane, "card2");
				}
			}
		});
		panel_4.add(login_bt);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, "card2");
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"사번", "이름", "직종", "부서"}));
		panel_6.add(comboBox);
		
		textField = new JTextField();
		panel_6.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_6.add(btnNewButton);
		
		table = new JTable();
		panel_5.add(table, BorderLayout.CENTER);
		
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
}
