package pm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame_Ex1 extends JFrame {
	boolean flag=true;
	
	int score=0;
	
	JTextField tf;
	
	//크기객체 Dimension
	Dimension d = new Dimension(390,590);
	
	// 필요한 각 이미지들
	Image back_img, me_img,meteor_img,bullet_img;
	Me me = new Me();
	
	ArrayList<Meteor> m_list = new ArrayList<Meteor>();
	
	ArrayList<Bullet> b_list = new ArrayList<Bullet>();
	
	ArrayList<Exp> e_list = new ArrayList<Exp>();
	
	
	JPanel p = new JPanel() {
		@Override
		public void paint(Graphics g) {
			// 배경 그리기
			g.drawImage(back_img, 0, 0, this);
			
			//주인공 그리기
			g.drawImage(me_img, me.pos.x, me.pos.y, this);
			StringBuffer sb = new StringBuffer("점수: ");
			sb.append(score);
			g.drawString(sb.toString(),340, 20);
			for(int i=0;i<m_list.size();i++) {
				Meteor m= m_list.get(i); 
				g.drawImage(meteor_img, m.rect.x,m.rect.y,this);
			}
			
			for(int i=0;i<b_list.size();i++) {
				Bullet b = b_list.get(i);
				g.drawImage(bullet_img, b.rect.x, b.rect.y, this);
			}
			
		}
	};
	
	JPanel p1;
	
	public Frame_Ex1() {
		//이미지 객체들 초기화
		back_img = new ImageIcon("src/images/back.jpg").getImage();
		me_img = new ImageIcon("src/images/me.png").getImage();
		meteor_img = new ImageIcon("src/images/meteor.png").getImage();
		bullet_img = new ImageIcon("src/images/bullet.png").getImage();
		
		init_game();//게임 초기화
		init_me_pos();
		
		
		
		this.setLocation(300,100);//창의 위치
		this.pack(); // 컴포넌트들의 크기에 맞게 사이즈 설정
				// 이 경우 패널을 넣었으니 패널의 사이즈에 맞춘다.
		this.setResizable(false);
		this.setVisible(true);
		
		//종료이벤트
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			});
		Thread makeMeteor = new Thread() {
			public void run() {
				while(flag) {
					int height=meteor_img.getHeight(Frame_Ex1.this);
					int width=meteor_img.getWidth(Frame_Ex1.this);
					Meteor m = new Meteor(Frame_Ex1.this,height,width);
					m.start();
					m_list.add(m);
					try {
						sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		makeMeteor.start();
		
		KeyListener k = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				
				switch (code) {
				case KeyEvent.VK_LEFT:
					me.pos.x-=3;
					if(me.pos.x<0) {
						me.pos.x=0;
					}
					p.repaint();
					break;
				case KeyEvent.VK_RIGHT:
					me.pos.x+=3;
					if(me.pos.x> d.width-me.pos.width) {
						me.pos.x=d.width-me.pos.width;
					}
					p.repaint();
					break;
				case KeyEvent.VK_SPACE:
					System.out.println("1");
					int x = me.pos.x;
					int y = me.pos.y;
					Bullet b = new Bullet(x, y, Frame_Ex1.this);
					b.start();
					b_list.add(b);
				}
			}
		};
		
		this.addKeyListener(k);
	}
	
	private void init_game() {
		// 크기객체(Dimension)을 가지고 JPanel의크기를 예약하자!
		p.setPreferredSize(d);
		
		//크기가 예약된 JPanel을 현재 창 가운데에 추가
		this.add(p);
	}
	
	private void init_me_pos() {
		int imgWidth = me_img.getWidth(this);//주인공 이미지의 너비
		int imgHeight = me_img.getHeight(this);//주인공 이미지의 높이
		
		//me객체 안에 Rectangle의 x,y,width, height지정
		me.pos.x = (d.width-imgWidth)/2;
		me.pos.y = d.height-imgHeight-5;
		me.pos.width = imgWidth;
		me.pos.height = imgHeight;
		
	}
		
	public static void main(String[] args) {
		new Frame_Ex1();

	}

}
