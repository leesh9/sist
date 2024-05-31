package am;

public class MainEx3 {
	
	public static void test(ParentEx3 p) {
		p.setMsg("테스트");
	}
	
	public static void main(String[] args) {
		// 자식클래스로 생성
		ChildEx3 c = new ChildEx3();
		
		test(c);
		System.out.println(c.msg);
		
	}

}
