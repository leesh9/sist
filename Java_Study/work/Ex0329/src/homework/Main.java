package homework;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 프로그램 시작
		
		//자판기(vending) 객체 생성
		Vending ven = new Vending();
		ven.init();//각 음료들이 배열에 저장된다.
		
		Scanner scan = new Scanner(System.in);
		System.out.println("금액:");
		int m = scan.nextInt();
		
		// 자판기에 금액을 넣어서
		// 선택할 수 있는 음료의 이름들을 받아야 한다.
		String msg = ven.insertCoin(m);
		System.out.println(msg);

	}

}
