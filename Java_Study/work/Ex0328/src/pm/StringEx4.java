package pm;

public class StringEx4 {

	public static void main(String[] args) {
		// 문자열 객체 생성
		String s1 = "TESt";
		String s2 = "test";
		
		if(s1.equals(s2))
			System.out.println("s1과 s2의 내용이 같다.");
		else
			System.out.println("s1과 s2의 내용이 다르다.");
		
		if(s1.equalsIgnoreCase(s2))
			System.out.println("s1과 s2의 내용이 같다.");
		else
			System.out.println("s1과 s2의 내용이 다르다.");

	}

}
