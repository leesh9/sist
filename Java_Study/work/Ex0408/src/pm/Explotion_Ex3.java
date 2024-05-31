package pm;

import java.awt.Point;

public class Explotion_Ex3 {
	int size = 128;
	
	Point pt = new Point();
	
	//현재객체가 하나 생성될 때는 운석이 주인공이랑 충돌할 때다.
	// 이때 운석이 폭발 하면서 사라져야 한다.
	
	//폭발 이미지는 27개이며 이들은 Frame 창에 배열로 미리 준비해 두자!
	// 배열을 접근하는 index값을 준비하자!
	int index;
	int gap=5;
	int interval = gap;
	
	public boolean move_index() {
		if(interval == gap)
			index++;
		
		interval--;
		if(interval == 0)
			interval = gap;
		
		//인덱스 값은 27이 되면 현재 함수는
		// 폭발이미지 27개를 모두 표현한경우이므로 현재 객체의
		// 폭발역활이 끝나야 한다.
		return index>=27;//index가 27이 될 때 true가 반환됨!
	}
}
