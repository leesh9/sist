package pm;

public class BreakEx2 {

	public static void main(String[] args) {
		/*
		 1 2 3 4 5
		 1 2 3 4 5
		 1 2 3 4 5
		*/
		for(int k=0; k<3; k++) {
			for(int i=0; i<5; i++) {
				System.out.printf("%2d",i+1);
			}
			System.out.println();//줄 바꿈
		}
		System.out.println("--------------------");
		/*
		 1 2 3
		 1 2 3
		 1 2 3
		 */
		for(int k=0; k<3; k++) {
			for(int i=0; i<5; i++) {
//				(i+1)이 3과 같다면 가장 가까운 반복문 탈출
				if((i+1)%3==0)
					break;
				System.out.printf("%2d",i+1);
				
			}
			System.out.println();//줄 바꿈
		}
	}

}
