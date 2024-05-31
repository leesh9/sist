package am;

public class ExceptionEX3 {

	public static void main(String[] args) {
		
		try {
			// 예외가 발생 가능한 문장들
			System.out.println(10/0);
			System.out.println("두번째 출력");
		}catch(ArithmeticException e){
			System.err.println("예외발생 문장1");
		}catch(Exception e) {
			System.err.println("예외발생 문장2");
		}
		System.out.println("프로그램 종료");
	}

}
