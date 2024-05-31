package am;

public class MultiForEx8 {

	public static void main(String[] args) {
		// 1  2  3  4
		// 5  6  7  8
		// 9 10 11 12
		
		int count=0;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<4;j++) {
				count++;
				System.out.printf("%3d",count);
			}
			System.out.println();
		}
		
		System.out.println("-------------");
		
		for(int i=0;i<3;i++) {
			for(int j=1;j<=4;j++) {
				System.out.printf("%3d",i*4+j);
			}
			System.out.println();
		}
	}

}
