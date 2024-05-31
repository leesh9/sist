package am;

public class StringEx3 {

	public static void main(String[] args) {
		
		String s1 = "SIST";//암시적 객체 생성
		String s2 = "SIST!";
		String s3 = "SIST";
		
		String s4 = new String("SIST");//명시적 객체 생성
		
		// 피연산자들이 객체일 때 ==로 비교하면 주소값 비교!
		if(s1==s4) {
			System.out.println("s1과 s4는 서로 같다");
		}else {
			System.out.println("s1과 s4는 서로 다르다");			
		}
		
		if(s1==s3) {
			System.out.println("s1과 s3는 서로 같다");
		}else {
			System.out.println("s1과 s3는 서로 다르다");			
		}

	}

}
