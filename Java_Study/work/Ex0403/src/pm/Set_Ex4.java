package pm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set_Ex4 {

	public static void main(String[] args) {
		// 정수를 저장하는 Set구조 생성
		HashSet<Integer> set1 = new HashSet<Integer>();
		System.out.println("set1.size():"+set1.size());
		
		if(set1.isEmpty())
			System.out.println("set1이 비었습니다.");
		else
			System.out.println("set1이 비어있지 않습ㄴ디ㅏ.");
		
		set1.add(100);
		set1.add(200);
		set1.add(300);
		set1.add(100);//중복자원이므로 저장안됨!
		
		if(set1.add(200))//중복된 자원 추가하기
			System.out.println("추가완료");
		else
			System.out.println("추가실패");
		
		System.out.println("set1.size():"+set1.size());
		
		//200이라는 값을 삭제
		set1.remove(200);
		
		// set구조는 index값이 없기 때문에 반복자인 Iterator로 얻어내어
		// 반복처리 해야 한다.
		
		Iterator<Integer>it = set1.iterator();
		//많은 양을 다룰때  Iterator를 사용하는것이 좋다.
		
		
		while(it.hasNext()) {
			//hasNext함수는 커서가 있는 위치에서 바로 담음칸에
			//자원이 있으면 true를 반환하고, 없으면 false를 반환한다.
			int n=it.next(); // 다음 칸으로 이동하여 그곳에 있는
							// 자원을 반환하여 n에 저장!
			System.out.printf("%-4d",n);
			
			
		}
		
	}

}
