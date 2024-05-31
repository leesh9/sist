package pm;

public class 문자연습2 {

	public static void main(String[] args) {//문자형은 내부적으로 정수형화돼서 저장된다 즉, 유니코드.
		// 대문자 A를 저장하는 문자형 변수 a를 정의하자
		char a = 'A';
		
		//정수형 변수 b를 선언하자 
		int b=a+1 ; //a의 값을 저장 .사실은 내부적으로 'A'의 유니코드값이 저장됨! :65
		//그래서 a+1은 66이 됨. 66이 아닌 대문자B를 출력하고싶다> 형변환해야함
		
		char c =(char)b;//정수형 변수 b를 문자형인 char로 형변환을 강제로 수행.
		//문자는 코드값을 기억하고ㅗ 있따.
		
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		


	}

}
