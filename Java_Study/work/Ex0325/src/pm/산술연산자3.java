package pm;

public class 산술연산자3 {//파일명과 클래스 명이 동일해야함. 연산자3>산술연산자3 리네임할떄.
	

	public static void main(String[] args) {
		//산술 연산자(+:더하기,-:빼기,*:곱하기,/:나누기,%:나머지 구하기)
		
		//정수형 변수 a를 선언하면서 10을 저장하자!
		int a=10;
		
        //정수형 변수b를 선언하면서 7을 저장하자!
		int b=7;
		
		//정수형 변수c를 선언하면서 변수 a와 변수b를 더한값을 저장하자!
		int c=a+b;
		
		//정수형 변수 d를 선언하면서 변수 a와 변수 b를 곱한값을 저장하자!
		int d=a*b;
		
		//정수형 변수 e를 선언하면서 변수 a와 변수 b를 나눈값을 저장하자!
        int e=a/b;
        
        //정수형 변수 f를 선언하면서 변수 a와 변수 b를 나눈 나머지값을 저장하자!
		int f=a%b; //배열할떄 상당히 유용하게 쓰임.
		
		
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		
		
		
	}

}
