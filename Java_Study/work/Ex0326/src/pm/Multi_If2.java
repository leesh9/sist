package pm;

import java.util.Scanner;

public class Multi_If2 {

	public static void main(String[] args) {
		/*
		 [문제]
		 	키보드로 부터 점수를 하나 받는다.(0~100)
		 	그 점수가 80~100 사이이면 "우수"출력!
		 	그렇지 않고 60~79 사이면 "보통" 출력,
		 	그것도 아니고 40~59 사이면 "재시험" 출
		 	그 이하는 "하지마~!"출력
		 */
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		

		if(score<0||score>100) {
			System.out.println("0~100까지의 수들 중 하나를 입력하세요");
		}else if(score>=80) {
			System.out.println("우수");
		}else if(score>=60){
			System.out.println("보통");
		}else if(score>=40) {
			System.out.println("재시험");
		}else{
			System.out.println("하지마");
		}
		

	}

}
