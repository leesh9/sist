package am;

public class Main_Ex2 {
	
	public static void main(String[] args) {
		// 프로그램 시작
		// 원하는 객체(Gen_Ex2)생성
		Gen_Ex2<Integer> data = new Gen_Ex2<Integer>();
		data.setValue(100);
		
		System.out.println(data.getValue()+1);
		
	}

}
