package pm;

import java.util.Scanner;

public class TestEx6 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		//컴퓨터가 가지는 난수 발생(1~100 중 하나만)
		int com = (int)(Math.random()*100+1);
		
		//화면에 짝수는 1 홀수는 2를 선택하도록 출력하자!
		System.out.println("짝수:1, 홀수:2");
		Scanner scan = new Scanner(System.in);
		int cmd = scan.nextInt();
		
		String select ="N";
		
		do {
			switch(cmd){
			case 1:
				if(com%2==0) {
					System.out.println("짝수 맞습니다.");
					select ="N";
				}else {
					System.out.println("짝수가 아닙니다.");
					System.out.println("계속하시겠습니까?(Y,N)");
					select=scan.next();
				}
				break;
			case 2:{
				if(com%2==1) {
					System.out.println("홀수 맞습니다.");
					select ="N";
				}else {
					System.out.println("홀수가 아닙니다.");
					System.out.println("계속하시겠습니까?(Y,N)");
					select=scan.next();
				}
				break;
			}
			default:{
				System.out.println("1아니면 2 둘 중 하나를 입력하세요");
			}
		}//switch의 끝
		}while(select=="y"&&select=="Y");
		
		
		
		System.out.println(com);
		

	}

}
