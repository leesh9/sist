package am;

public class Main_Ex3 {

	public static void main(String[] args) {
		Thread_Ex3 t1 = new Thread_Ex3();// 스레드 생성
		t1.start();//스레드 시작 ---> run함수 호출
		
		Thread_Ex4 t2 = new Thread_Ex4();
		t2.start();
		
		System.out.println("스레드 연습");
		
	}

}
