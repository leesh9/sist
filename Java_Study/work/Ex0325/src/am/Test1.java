package am;

public class Test1 {//1번 {}하나의 영역을 말함.
	// main 만드는 이유: 자바에서 main 함수가 시작하는 부분
	// main 함수는 JVM에 의해 자동 호출되는 곳이다.
	// Jvm은 약속된 애만 호출하는데 public , static 등등 이런 규칙들이 지켜져야함.[]등등
	// 함수는 내가 원하는 명령들의 집합.ㅣ
	
	public static void main (String[] args) {// args 는 바꿀수 있음 이유:변수 이름.
		
		System.out.println("자바 시작!");//2번
		System.out.println("자바 시작!");
		ex1 ();// 3번! ex1함수를 호출해줌
		System.out.println("프로그램 종료.");
		
	}//Main 함수의 끝. 함수가 끝나면 호출한 곳으로 돌아간다. 즉 앞쪽 호출한곳 .앞. Jvm으로 돌아감>프로그램 종료.
	//자바는 함수안에 함수를 넣을 수 없음.
	
	public static void ex1 () { //()안의 것은 인자 즉, 매개변수라고 한다.argument. 필요없으면 지워도 됨. 단, main 함수 제외
		System.out.println("ex1함수"); //println뒤에 ()가 있으니 함수라는 뜻이다.
		//호출을 안해서 실행을 해도 콘솔에 나타나지 않음. main 함수안에서 호출을 해줘야 실행됨.
		
		//stack jvm호출시  
		//스택 stack: 가벼운 변수(쌓이는애)저장하는 곳과 빼는애가 한곳에 나중에 들어간 애가 먼저 빠짐 .변수가 만들어짐
		//힙heap: 무거운 객체들이 저장됨 주소를 가지는 애들의 모임.>자바에선 객체 (object) 밖에 없다.  주소만 바뀌면 같은 형태가 두개 생성가능.
		//heap영역 너머에 stactic: 영역이 있는데 정적인 영역이다. 똑같은애가 두개 생길수없다.오로지 한개. 이 영역은 처리속도가 빠르다는 장점이있음.
		//public void ex1 () 만 썻을때 오류가 나는 이유: static영역에 없어서 하려면 static 을 넣어야함. 없으면 어느 영역에 있지도 않은거임. 
		
		
		
		//@자료형
		//1)기본 자료형 (첫글자 소문자)
		//-논리형:(boolean) true 아니면 false 만 기억한다.
		//-문자형:(character) 
		//-정수형:(byte.8bit.127까지<short.16bit.<int.32bit<long.64bit)8비트=1byte
		//-실수형:(float.4byte<double 8byte)
		//2)객체 자료형 (첫글자 대문자)
		//-문자열:String
		//System
	
		
	}
	

}
