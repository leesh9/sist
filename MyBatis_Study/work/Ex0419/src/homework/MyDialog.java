package homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField empno_tf;
	private JTextField ename_tf;
	private JTextField job_tf;
	private JTextField mgr_tf;
	private JTextField sal_tf;
	private JTextField hiredate_tf;
	private JTextField comm_tf;
	private JTextField deptno_tf;
	JButton okButton;
	JButton cancelButton;
	MyFrame frame;

	/**
	 * Create the dialog.
	 */
	public MyDialog(EmpVO vo) {
		init();
		empno_tf.setText(vo.getEmpno());
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public MyDialog(MyFrame frame) {
		init();
		empno_tf.setEditable(true);
		okButton.setText("저장");
		cancelButton.setText("취소");
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 사용자가 입력한 사원의 정보들을 받아낸다.
				String empno = empno_tf.getText().trim();
				String ename = ename_tf.getText().trim();
				String job = job_tf.getText().trim();
				String mgr = mgr_tf.getText().trim();
				String sal = sal_tf.getText().trim();
				String hiredate = hiredate_tf.getText().trim();
				String comm = comm_tf.getText().trim();
				String deptno = deptno_tf.getText().trim();
				if(comm.length()==0)
					comm = null;
				EmpVO vo = new EmpVO(empno, ename, job, mgr, sal, hiredate, comm, deptno);
				int cnt = frame.addEmp(vo);// DB에 저장하는 기능!
				if(cnt>0) {
					frame.totalEmp(null);
					JOptionPane.showMessageDialog(MyDialog.this, "저장완료!");
				}
			}
			
		});
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 취소는 대화창을 닫는다.
				 dispose();
			}
		});
	}
	
	private void init() {
		setBounds(100, 100, 191, 360);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(8, 1, 0, 0));
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("사번");
				panel.add(lblNewLabel);
			}
			{
				empno_tf = new JTextField();
				empno_tf.setEditable(false);
				panel.add(empno_tf);
				empno_tf.setColumns(6);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblDlfma = new JLabel("이름");
				panel.add(lblDlfma);
			}
			{
				ename_tf = new JTextField();
				ename_tf.setColumns(6);
				panel.add(ename_tf);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblDlfma = new JLabel("직종");
				panel.add(lblDlfma);
			}
			{
				job_tf = new JTextField();
				job_tf.setColumns(6);
				panel.add(job_tf);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblDlfma = new JLabel("부서장");
				panel.add(lblDlfma);
			}
			{
				mgr_tf = new JTextField();
				mgr_tf.setColumns(6);
				panel.add(mgr_tf);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblDlfma = new JLabel("급여");
				panel.add(lblDlfma);
			}
			{
				sal_tf = new JTextField();
				sal_tf.setColumns(6);
				panel.add(sal_tf);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblDlfma = new JLabel("입사일");
				panel.add(lblDlfma);
			}
			{
				hiredate_tf = new JTextField();
				hiredate_tf.setColumns(6);
				panel.add(hiredate_tf);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblDlfma = new JLabel("보너스");
				panel.add(lblDlfma);
			}
			{
				comm_tf = new JTextField();
				comm_tf.setColumns(6);
				panel.add(comm_tf);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			contentPanel.add(panel);
			{
				JLabel lblDlfma = new JLabel("부서코드");
				panel.add(lblDlfma);
			}
			{
				deptno_tf = new JTextField();
				deptno_tf.setColumns(6);
				panel.add(deptno_tf);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}
}
