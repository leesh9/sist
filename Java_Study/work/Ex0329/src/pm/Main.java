package pm;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("검색할 사원명");
		
		//객체 생성 및 초기화
		StaffSys ss =new StaffSys();
		Scanner scan =new Scanner(System.in);
		//문자열입력
		String str = scan.nextLine();
		//검색
		System.out.println(ss.search(str));

	}

}
