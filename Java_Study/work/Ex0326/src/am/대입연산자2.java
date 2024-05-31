package am;

public class 대입연산자2 {

	public static void main(String[] args) {
		// 대입연산자 =:우측의 값을 좌측 변수에 저장한다
		//         +=:우측의 값을 좌측 변수에 더하면서 저장
		//         -=:우측의 값을 좌측 변수에 빼면서 저장
		//         *=:우측의 값을 좌측 변수에 곱하면서 저장
		//         /=:우측의 값을 좌측 변수에 나누면서 저장
		//         %=:우측의 값을 좌측 변수에 대한 나머지값을 저장
		int a = 10;
		int b = 7;
		
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		
		a += b;// a = a+b
		
		System.out.println("a+=b:"+a);
		
		a %=b;
		// a = a%b; 이는 17을 7로 나눴을 때 나타나는 나머지 값이 3을
		// a에 저장한다.
		System.out.println("a%=b:"+a);//3
		
	}

}
