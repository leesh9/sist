package am;

import java.awt.Image;
import java.awt.Toolkit;

public class MyImage {
	String src;
	int x,y;
	Image img;
	Toolkit tool;
	
	public MyImage(int x,int y) {
		//사용자가 클릭한 x,y좌표는 인자로 받자!;
		this.x =x-60;
		this.y =y-60;
		int idx = (int)(Math.random()*45+1);
		StringBuffer sb =new StringBuffer("src/images/");
		sb.append(idx);
		sb.append(".gif");
		src = sb.toString();
		tool= tool.getDefaultToolkit();
		img=tool.getImage(src);
	}
	
}
