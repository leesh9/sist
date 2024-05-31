package am;

public class MultiForEx9 {

	public static void main(String[] args) {
		// A B C D E
		// F G H I J
		// K L M N O
		
		int alpabet = 'A';
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("%2c",alpabet++);
			}
			System.out.println();
		}
		System.out.println("-----------------------");
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("%-2s","*");
			}
			System.out.println();
		}


	}

}
