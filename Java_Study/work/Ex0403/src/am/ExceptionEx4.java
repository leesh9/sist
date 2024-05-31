package am;

public class ExceptionEx4 {
	
	public boolean test() {
		boolean chk = false;
		try {
			System.out.println(10/3);
			return chk;
		}catch(Exception e) {
			System.err.println("!!!!!!");
			
		}finally {
			//예외 발생 여부와 상관없이 무조건 수행하는 영역
			System.out.println("finally~~~!");
		}
		return true;
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		ExceptionEx4 ex = new ExceptionEx4();
		boolean chk = ex.test();
		System.out.println(chk);
	}

}
