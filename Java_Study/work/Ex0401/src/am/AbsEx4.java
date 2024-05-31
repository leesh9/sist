package am;

// 추상매서드를 한개라도 가지면 해당 클래스는
// 반드시 추상클래스 즉 abstract로 명시 해야한다.
public abstract class AbsEx4 {
	String msg;
	
	public void setMsg(String n) {
		msg = n;
	}
	
	//추상메서드
	abstract public void test(); 
}
