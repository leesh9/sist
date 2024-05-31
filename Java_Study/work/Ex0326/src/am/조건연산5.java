package am;

import java.util.Scanner;

public class 조건연산5 {

	public static void main(String[] args) {
		// 화면에 정수를 입력하라는 안내문 출력
		
		//정수를 키보드로부터 하나 입력받기 위해 스캐너 준비
		Scanner scan = new Scanner(System.in);
		
		//준비된 키보드와 연결된 스캐너를 통해 숫자 하나를 입력 받는다.
		int su = scan.nextInt();
		
		int res= su>100 ? su%100:su;
		
		System.out.println("입력받은숫자:"+res);
		
	}

}
 