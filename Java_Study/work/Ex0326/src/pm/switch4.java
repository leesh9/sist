package pm;

import java.util.Scanner;

public class switch4 {

	public static void main(String[] args) {
		// 
		System.out.println("코드(S,E,L):");
		
		//키보드와 연결된 스캐너 생성
		Scanner scan = new Scanner(System.in);
		
		String code = scan.nextLine();//키ㅣ보드로부터 문자열 받기
		
		switch(code) {
		case "E":
			System.out.println("전자제품");
			break;
		case "S":
			System.out.println("스포츠용품");
			break;
		case"L":
			System.out.println("생활용품");
			break;
		}//switch문의 끝

	}

}
