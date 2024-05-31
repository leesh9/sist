import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JSeparator;

import java.io.*;
import javax.swing.JPopupMenu;

public class as extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea ta;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_1;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					as frame = new as();
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
	public as() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		ta = new JTextArea();
		scrollPane.setViewportView(ta);
		
		mnNewMenu = new JMenu("파일");
		contentPane.add(mnNewMenu, BorderLayout.NORTH);
		
		mntmNewMenuItem = new JMenuItem("새파일");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_2 = new JMenuItem("열기");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 파일 선택기 생성
				JFileChooser jfc =
						new JFileChooser("c:/my_study");
				int cmd = jfc.showOpenDialog(as.this);
				if(cmd==JFileChooser.APPROVE_OPTION) {
					File f = jfc.getSelectedFile();
					
					BufferedInputStream bis = null;
					try {
						bis = new BufferedInputStream(new FileInputStream(f));
						byte[] buf = new byte[2048];
						int size = -1;
						while((size = bis.read(buf))!=-1) {
							//읽은 자원을 문자열로 만든다.
							String str = new String(buf,0,size);
							ta.append(str);
						}
					}catch(Exception ex) {
						ex.printStackTrace();
					}finally {
						try {
							if(bis != null)
								bis.close();
						}catch(Exception e2) {}
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		separator = new JSeparator();
		mnNewMenu.add(separator);
		
		mntmNewMenuItem_1 = new JMenuItem("종료");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
	}

}
