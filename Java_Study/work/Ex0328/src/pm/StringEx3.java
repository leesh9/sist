package pm;

public class StringEx3 {

	public static void main(String[] args) {
		// 문자열 객체 생성
		String s1 = "Test Java Example";
		
		// 문자 또는 문자열 수정
		String s2 = s1.replaceAll("a", "*");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println("------substring연습--------------");
		
//		String s3 = s1.substring(5);//Java Example
		// s1에서 대문자 J를 찾아서 인덱스 값을 알아낸다.
		int idx = s1.indexOf("J");
		String s3 = s1.substring(idx);
		System.out.println("s1.substring(5): "+s3);
		
		s3 = s1.substring(5,8);
		System.out.println("s1.substring(5,8): "+s3);
		
		

	}

}
