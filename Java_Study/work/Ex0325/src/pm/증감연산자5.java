package pm;

public class 증감연산자5 {

	public static void main(String[] args) {
		// 증감연산자(++:1증가 ,--:1감소)
		int a=10;
		System.out.println(++a);//a의 값을 1증가시켜라.11
		System.out.println(--a);//a의 값을 1감소시켜라.10
		//얘는 a라는 변수의 값 자체가 변화함.
		
		System.out.println(a++);//10 연산자가 변수 앞에 있느냐 변수 뒤에 있느냐 차이.변수 앞에있으면 우선순위가 높아 제일 먼저 수행
		//증감연산자가 변수뒤에 존재하면, 연산 우선순위가 가장 낮다.
		//제어가 다음행으로 이동할 때 a의 값을 1증가시킨다.
		System.out.println(a);//11 뒤에있으면 우선순위가 낮아 =보다 늦게 수행
		
		int b=10;
		
	System.out.println(a++>++b);//a++보다 >비교연산자가 먼저 수행돼서 false 가 됩니다.변수뒤에 있으면 그행에서 제일 나중에 수행됨.
	System.out.println(a);
	System.out.println(b);

	}

}
