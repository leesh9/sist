package pm;

public class Ex1 implements InterEx1 {

	@Override
	public int sum(int n) {
		// 구현하겠다고 한 InterEx1의 추상메서드를 재정의한 것
		return value+n;
	}
	
}
