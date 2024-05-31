package pm;

public class StringEx1 {

	public static void main(String[] args) {
		// 프로그램 시작 부분
		
		String s1 = "Java Programming";
		
		int len = s1.length();
		
		System.out.println("s1.length():"+len);//16
		
		char ch0 = s1.charAt(0);// s1이 기억하는 곳에 있는
		// 문자열에서 첫 문자를 얻어내어 ch0에 저장한다.
		System.out.println("S1.charAt(0):"+ch0);//J
		
		//String의 기능인 length() 와 chatAt() 을 가지고
		// 특정 문자열에 숫자가 있는지? 없는지? 판단할 수 있다.
		int count = 0;//숫자가 있을 때마다 count를 증가시킨다.
		
		
		for(int i=0;i<len;i++) {
			// s1으로부터 문자 1개를 얻어낸다.
			char ch = s1.charAt(i);
			
			//ch가 저장한 값이 숫자인지? 아닌지? 판단하자
			if(ch>='0'&&ch<='9') {
				count++;
			}
		}
		
		System.out.println("숫자의 수는:"+count);
		
	}

}
