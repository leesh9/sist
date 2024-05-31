package am;

import java.util.Scanner;

public class IfTest9 {

	public static void main(String[] args) {
		// 화면에 정수입력 문자열 출력
		System.out.println("점수:");
		
		// 키보드와 연결된 스케너 준비
		Scanner scan = new Scanner(System.in);
		
		//준비된 스케너로부터 정수 하나 입력받기
		int score = scan.nextInt();
		
		// 받은 score 값이 100최과는 "잘못된값" 출력!
		// 그렇지 않고 100~60사이면 "합격"출력!
		// 그것도 아니면 "다음기회에"출력!
		if(score>100) {
			System.out.println("잘 못된 값");
		}else if(score>=60){
			//제어가 이ㅉㅗㄱ에 왔을 때는 score에 최대값은 100이다
			//그러므로 자연스럽게 범위가 지정된다. 100~60
			System.out.println("합격");
		}else {
			//score가 60미만일 때
			System.out.println("다음기회에");
		}

	}

}
