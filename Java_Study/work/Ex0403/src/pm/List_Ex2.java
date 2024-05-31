package pm;

import java.util.ArrayList;

public class List_Ex2 {

	public static void main(String[] args) {
		// 문자열을 저장하는 List생성
		ArrayList<String> list = new ArrayList<>();
		
		list.add("TEST");
		list.add("테스트");
		list.add("12345");
		
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		list.remove("테스트");
		
	}
	

}
