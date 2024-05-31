package am;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Canvas_Ex2 extends Canvas {
	
	Image img;
	Toolkit tool;
	public Canvas_Ex2() {
		// 1) Toolkit 생성
		tool = Toolkit.getDefaultToolkit();
		
		//2) 준비된 Toolkit을 통해 Image객체 준비
		img = tool.getImage("src/images/1.gif");
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 10, 10, this); //이미지 그리기
	}
	
	
}
