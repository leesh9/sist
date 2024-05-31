package pm;

import java.util.Scanner;

public class Multi_If1 {

	public static void main(String[] args) {
		// "값입력"이라는 문자열 출력
		System.out.println("값 입력:");
		
		//정수를 입력받기 위해 키보드와 연결된 스캐너 준비
		Scanner scan = new Scanner(System.in);
		
		//정수를 키보드로 부터 연결된 스캐너를 통해 얻어낸다.
		int su = scan.nextInt();
		
		/*
		 [조건]
		 	su의 값이 1,2,3중에 하나라고 하자!
		 	1일때는 "1번"출력
		 	2일때는 "2번"출력
		 	3일때는 "3번"출력
		 	
		 */
		
		if(su == 1)
			System.out.println("1번");
		else if(su == 2)
			System.out.println("2번");
		else if(su == 3)
			System.out.println("3번");
		else 
			System.out.println("1,2,3 중 하나를 입력하세요");
		
	}

}
