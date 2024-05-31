package pm;

public class ArrayEx7 {

	public static void main(String[] args) {
		// 문자형 배열을 선언하고 생성하자!
		//char[] ar1; // 1)선언
		//ar1 = new char[3]; // 2)생성
		
		char[] ar1 = new char[3];
		ar1[0] = 'A';
		ar1[1] = 'B';
		ar1[2] = 'C';
		
		for(int i=0; i<ar1.length;i++) {
			System.out.println(ar1[i]);
		}
		
	}

}
