package pm;

import java.awt.Color;

public class Oval_Ex3 {
	Color c;
	int x,y,wh;
	
	public Oval_Ex3(int x,int y) {
		//크기도 랜덤한 크기(50~200)를 얻어낸다.
		wh = (int)(Math.random()*150+50);
		
		//인자인 x,y는 사용자가 클릭할 때 해당 위치값을 받아야 하는 인자다.
		this.x = x-wh/2;
		this.y = y-wh/2;
		
		//색상을 무작위로 만들기위해 랜덤 수행한다.
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		c= new Color(r,g,b);
		
		
		
		
	}
}
