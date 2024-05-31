package am;

public class ExceptionEx5 {
	
	public void ex1() {
		System.out.println("ex1함수");
		
		try {
			ex2();
		} catch (Exception e) {      
			e.printStackTrace();
		}//다른 함수 호출
				
		System.out.println("ex2함수 수행 끝");
	}
	
	public void ex2() throws Exception{
		System.out.println("수행1");
		System.out.println("수행2"+(10/0));
		System.out.println("수행3");
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		ExceptionEx5 ex5 = new ExceptionEx5();
		ex5.ex1();
		System.out.println("프로그램끝");

	}

}
