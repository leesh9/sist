package pm;

import java.util.Scanner;

public class Switch3 {

	public static void main(String[] args) {
		// 화면에 정수입력 문장 출력
		System.out.println("입력(1~3):");
		
		//키보드와 연결된 스캐너 준비
		Scanner scan = new Scanner(System.in);
		
		//정수 하나 받기
		int su = scan.nextInt();
		
		if(su == 1) {
			System.out.println("1번");
		}else if(su==2) {
			System.out.println("2번");
		}else if(su==3) {
			System.out.println("3번");
		}
		
		System.out.println("----switch-----");
		/*
		  switch문의 구성
		  
		  		switch(조건값)
		 */
		
		switch(su) {
			case 1:
				System.out.println("1번");
				break;
			case 2:
				System.out.println("2번");
				break;
			case 3:
				System.out.println("3번");
				break;
			default :
				System.out.println("1~3중에 입력해 주세요");
		}
	}

}
