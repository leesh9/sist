package am;

import java.util.Scanner;

public class 조건연산자4 {

	public static void main(String[] args) {
		System.out.print("정수입력:");
		
		// 키보드로 부터 정수 하나를 입력 받는다.
		Scanner scan = new Scanner(System.in);
		
		// 준비된 키보드와 연결된 스캐너를 통해 숫자 하나를 받는다.
		int sul = scan.nextInt();
		
		//입력된 sul의 값이 100보다 크다면 "잘못된 값"을 출력하고,
		//그렇지 않다면 "적절한 값"을 출력하자!
		//조건연산자를 활용해 보자!
		String str = sul>100 ? "잘못된 값" : "적절한 값";
		
		System.out.println(str);
	}

}
