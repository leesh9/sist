package pm;

public class StringEx2 {

	public static void main(String[] args) {
		String s1 = "Test";
		String s2 = "123";
		
		String s3 = s1.concat(s2);// s1에 s2를 덧붙힌다.
		

		
		System.out.println("s3:"+s3);
		
		String s4 = new String("Test");
		
		if(s1 == s4)
			System.out.println("s1과 s4의 주소가 서로 같다.");
		else
			System.out.println("s1과 s4의 주소가 서로 다르다");
		
		if(s1.equals(s4))
			System.out.println("s1과 s4의 내용이 같다.");
		else
			System.out.println("s1과 s4의 내용이 다르다");		
		
		
	}

}
