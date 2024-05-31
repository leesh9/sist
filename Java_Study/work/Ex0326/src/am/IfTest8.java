package am;

import java.util.Scanner;

public class IfTest8 {

	public static void main(String[] args) {
		// 키보드로 부터 정수를 하나 받는다.
		// 그 값이 60이상이면 "합격"을 출력하고 그렇지 않다면
		//"다음기회에"를 출력하세요
		
		Scanner scan = new Scanner(System.in);
		int su =scan.nextInt();
		
		
		if(su>=60&&su<=100)
			System.out.println("합격");
		else
			System.out.println("다음기회에");

	}

}