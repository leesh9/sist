package am;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx1 {

	public static void main(String[] args) {
		// 예외(Exception)는 예상하지 못한 가벼운 오류를 의미하며
		// 프로그래머에 의해 수정이 가능한 것
		// 예외처리는 try~catch블럭으로 해결한다.
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("수1:");
			int su1 = scan.nextInt();
			
			System.out.println("수2:");
			int su2 = scan.nextInt();
			
			System.out.println("su1/su2:"+(su1/su2));
		}catch(InputMismatchException e) {
			System.err.println("숫자를 입력하세요");
		}catch(ArithmeticException e) {
			System.err.println("분모에 0을 넣지마세요");
		}
		
		System.out.println("프로그램 끝!");
		
		
	}

}
