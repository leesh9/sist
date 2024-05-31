package am;

public class ExceptionEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = new int [3];
		try {
			for(int i = 0; i<=ar.length; i++) {
				ar[i] = (i+1)*100;
				System.out.println(ar[i]);
			}
			System.out.println("반복문 끝~~!");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("배열길이초과");
		}
		
		System.out.println("프로그램 종료!");
	}
	
}
