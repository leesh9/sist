package am;

public class ChildEx3 extends ParentEx3 {

	@Override
	public void setMsg(String m) {
		//부모의 함수를 재정의 했으므로 현재 자식의 함수가 우선시된다.
		msg = "child:"+m;
	}
	
	
}
