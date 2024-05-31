package pm;

import java.util.Scanner;

public class Switch5 {

	public static void main(String[] args) {
		// 
		System.out.println("월입력(1~12):");
		
		Scanner scan = new Scanner(System.in);
		int month = scan.nextInt();
		
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("입력하신 "+month+"월은 31일까지");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("입력하신 "+month+"월은 30일까지");
				break;
			case 2:
				System.out.println("입력하신 "+month+"월은 29일까지");
				break;
			default:
				System.out.println("잘 못 입력하셨습니다.");
		}

	}

}
