package am;

public class TestEx2Main {

	public static void main(String[] args) {
		// 프로그램 시작부분
		
		// 원하는 클래스를 생성한다.
		TestEx2 ex = new TestEx2();
		//TestEx2객체를 새롭게 생성하여 그 주소를  ex에 저장한다.
		System.out.println(ex.name);//null
		
		// ex가 가리키는 객체안에 setName을 호출한다.
		ex.setName("사자");
		
		System.out.println(ex.name);//null
	}

}
