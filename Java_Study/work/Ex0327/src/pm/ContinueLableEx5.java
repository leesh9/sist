package pm;

public class ContinueLableEx5 {

	public static void main(String[] args) {
		
		// 레이블은 반복문 앞에서만 선언이 가능하다.
		num1:for(int k=1;k<=3;k++) {
			for(int i=1; i<=5; i++) {
				//i값을 출력하기 전에 i가 3의 배수면
				//i값을 출력하지않고 다음회차로 넘어감
				if(i%3 ==0)
					continue num1;
				
				System.out.printf("%-2d", i);
			}//열을 반복하는 for문의 끝
			System.out.println();
		}//행을 반복하는 for문의 끝

	}

}
