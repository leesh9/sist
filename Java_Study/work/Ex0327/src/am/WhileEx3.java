package am;

public class WhileEx3 {

	public static void main(String[] args) {
		//프로그램 시작
		
		//1~10까지의 합을 구하는 while문을 구현하자!
		int sum = 0;
		int i = 1;
		
		//1~10까지 반복하는 while문
		while(i<=10) {
			sum += i++;
		}
		System.out.printf("1~10까지의 합:%-3d",sum);
	}

}
