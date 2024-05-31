package am;

public class 비트연산자1 {

	public static void main(String[] args) {
		// 프로그램 시작!
		
		//숫자 13을 기억하는 변수 a를 만들자
		int a = 13;
		
		//숫자 7을 기억하는 변수 b를 만들자
		int b = 7;
		
		// 비트연산자(논리곱: &)를 이용하여 새로운 값을 가공하자!
		int c = a&b;
		/*
		 a  1101 = 13
		 b  0111 = 7
		   &-----
		 c  0101 = 5
		 */
		System.out.println("a&b="+c);
		
		int a1 = 15;
		int b1 = 8;
		
		int c1 = a1|b1;
		/*
		 a1  1111 = 15
		 b1  1000 = 8
		    |---------- 
		 c1  1111 = 15
		 */
		
		System.out.println("a1|b1="+c1);
	}

}
