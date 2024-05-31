package am;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("검색할 도서명:");
		Library lib = new Library();//도서관 객체 생성
		lib.init();// 도서관 초기화
		Scanner scan= new Scanner(System.in);
		String str = scan.nextLine();
		String msg=lib.search(str);
		
		System.out.println(msg);
	}

}
