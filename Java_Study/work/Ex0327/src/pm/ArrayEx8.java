package pm;

public class ArrayEx8 {

	public static void main(String[] args) {
		// 문자 10개를 저장할 수 있는 배열을 선언하고 생성하자!
		char[] ar = new char[10];
		
		char ch = 'A';
		for(int i=0; i<ar.length;i++) {
			ar[i] = ch++;
			System.out.printf("%-2c",ar[i]);
		}
		
		System.out.println(ar);

	}

}
