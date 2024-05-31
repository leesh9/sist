package pm;

public interface InterEx1 {
	
	// 상수 또는 메서드(함수)들만 존재할 수 있다.
	final int value = 100;//컴파일러가 알아서 앞에 final을 붙여준다.
	
	public int sum(int n); // 앞에 abstract가 생략되었다.
	
	
	
	// 인터페이스는 절대로 일반 메서드 (함수)를 가질 수 없다.
	
}
