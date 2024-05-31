package pm;

public class 논리연산자6 {

	public static void main(String[] args) {
		// 논리연산자(&&:그리고,||:또는) 
		//@ && @ 둘다 true여야하는데, 앞에서 false가 나오면 뒤에꺼는 수행자체를 안함.
		int a=10;
		int b=10;
		
		System.out.println(++a > b++ && ++a != ++b); //&& 좌측애가 우측으로 넘어올떄 b++수행된다.
		// ||연산자를 중심으로 첫번쨰 조건에서 결과가 true임으로 
		// 두번쨰 조건을 수행하지 않는다.
		System.out.println(a);
		System.out.println(b);
	
		

	}

}
