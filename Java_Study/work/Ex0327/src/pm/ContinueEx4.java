package pm;

public class ContinueEx4 {

	public static void main(String[] args) {
		// 1 2 3 4 5
		// 1 2 3 4 5
		// 1 2 3 4 5
		
		for(int k=1;k<=3;k++) {
			for(int i=1; i<=5; i++) {
				
				//i값을 출력하기 전에 i가 3의 배수면
				//i값을 출력하지않고 다음회차로 넘어감
				if(i%3 ==0)
					continue;
				
				System.out.printf("%-2d", i);
			}//열을 반복하는 for문의 끝
			System.out.println();
		}//행을 반복하는 for문의 끝

	}

}
