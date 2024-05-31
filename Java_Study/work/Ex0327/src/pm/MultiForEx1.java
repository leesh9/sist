package pm;

public class MultiForEx1 {

	public static void main(String[] args) {
		// 프로그램 시작
		/*
		  [결과]
		  *
		  **
		  ***
		  ****
		  *****
		 */
		
		for(int i=0;i<11;i++) {
			
			for(int j=0;j<11-i;j++) {
				System.out.printf(" ");
			}
			
			for(int j=0;j<=i;j++) {
				System.out.printf("%-2s","*");
			}
			System.out.println();
		}
		
		for(int i=10;i>0;i--) {
			for(int j=0;j<=11-i;j++) {
				System.out.printf(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.printf("%-2s","*");
			}
			System.out.println();
		}
		
		
		

	}

}
