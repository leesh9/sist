package pm;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class List_Ex1 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 정수만 저장하는 List구조 생성
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		// 위는 배열과 같은 구조를 가졌으며, 틀림점은
		// 생성시 크기를 지정하지 않고, 추가 될 때(add) 마다 크기가 늘어난다.
		// 그리고 삭제시(remove)에는 크기가 줄어든다.
		
		System.out.println("list.size():"+list1.size());
		
		list1.add(0);
		
		for(int i = 1;i<10;i++) 
			list1.add(i);
		
		
		System.out.println("list.size():"+list1.size());
		
		//반복문을 이용하여 출력하자
		for(int i = 0;i<list1.size();i++) {
			//list구조에서 요소를 하나씩 얻어낸다.
			int n = list1.get(i);
			System.out.println(n);
		}
		
		
		list1.remove(5);
		System.out.println();
		for(int i = 0;i<list1.size();i++) {
			//list구조에서 요소를 하나씩 얻어낸다.
			int n = list1.get(i);
			System.out.println(n);
		}
		
		//	인덱스가 6인 위치에 100을 저장하자
		
		list1.add(6, 100);
		
		System.out.println();
		for(int i = 0;i<list1.size();i++) {
			//list구조에서 요소를 하나씩 얻어낸다.
			int n = list1.get(i);
			System.out.println(n);
		}
		
		//숫자 7이 있는 인덱스 값을 알아내자
		int index = list1.indexOf(7);
		
		System.out.println("list1.indexOf(7):"+index);
		
		//현재 list구조가 비었는지? 판단!
		if(list1.isEmpty()) {
			System.out.println("list1이 비었습니다.");
		}else {
			System.out.println("list1이 비어 있지 않습니다.");
		}
		
		//모두 삭제
		list1.clear();
		
		if(list1.isEmpty()) {
			System.out.println("list1이 비었습니다.");
		}else {
			System.out.println("list1이 비어 있지 않습니다.");
		}
		
		System.out.println("list.size():"+list1.size());
		
	}

}
