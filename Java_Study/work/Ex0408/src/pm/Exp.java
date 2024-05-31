package pm;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Exp extends Thread {
	int size = 128;
	Frame_Ex1 frame;
	Point pt;
	ArrayList<Image>list = new ArrayList<Image>();
	Image img; 
	
	public Exp(Point p,Frame_Ex1 frame) {
		this.pt=p;
		for (int i =1;i<=27;i++) {
			StringBuffer sb = new StringBuffer("src/images2/exp_");
			sb.append(i);
			sb.append(".png");
			Image img = new ImageIcon(sb.toString()).getImage();
			list.add(img);
		}
	}
	
	@Override
	public void run() {
		for (int i =0;i<list.size();i++) {
				img=list.get(i);
			try {
				sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
