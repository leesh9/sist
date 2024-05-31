package am;

import java.util.Scanner;

public class DowhileEx6 {

	public static void main(String[] args) {
		// 키보드로부터 단을 입력받습니다.
		// do-while문으로 해당되는 구구단
		Scanner scan = new Scanner(System.in);
		System.out.print("단 입력:");
		int su = scan.nextInt();
		int i=1;
		System.out.println(su+"단");
		System.out.println("---------");
		do {
			System.out.println(su+"*"+i+"="+su*i);
			i++;
		}while(i<=9);

	}

}
