package pm;

public class 데이터타입1 {
	
	public static void main(String[] args) {
		//기본자료형
		//-논리형:(boolean) true 아니면 false 만 기억한다.
		//-문자형:(character) 
		//-정수형:(byte.8bit.127까지<short.16bit.<int.32bit<long.64bit)8비트=1byte
		//-실수형:(float.4byte<double 8byte)
		
		boolean bl=true; //true, false 는 예약어. 특정한 값이 예약되어 있음. not 문자열
		//자료형  변수명=true;
		
		//문자 1개를 저장할 수 있는 공간을 만들자 그 공간의 이름은 
		//ch1이라고 하고 그 안에 대문자 A를 저장하자
		char ch1 ='A';
		System.out.println("ch1:"+ch1);//변수 ch1의 값을 출력한다. 정수면 +  ch1정수임. not 문자
		//"ch1"때문에 ch1이 문자열로 바껴. +가 문자열 연결 연산자로 바뀜
		//+연산자는 피 연산자들이 정수이거나 실수일 때는 더하는 연산을 수행한다. 하지만 피연산자중에 하나라도 문자열이면 다른 쪽 값을 문자열로 바꿔버린다.
		//그리고 +는 문자열 연결연산자가 되어버린다.
		
		
		//정수형 변수 a를 선언하면서 100을 저장하자!
		byte a =127; //byte 범위 -128~127까지다.
		short b= 32000;
		int c =2100000000;//>정수형의 기본형은 int 다 
		long d= 2000000000000000000L;//int 허용범위인 21억을 초과하는 리터럴은 뒤에 소문자 l이나 L을 써야함
		
		
		//소수점을 가지는 값을 저장하기 위해서는 실수형 (float,double)을 지정하여 저장해야한다.
	    float f = 3.14f; //float 타입은 뒤에 f나 F를 넣어줘야함. 기본적으로 실수는 double 형으로 인지함. double은 기본적인 실수형.
	    double dd = 3.14;
	    System.out.println(f+dd); //>연산하면 자료형은 double형으로 저장됨.
		
	    
	    
	}
}
