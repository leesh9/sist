package am;

public class IfTest6 {

	public static void main(String[] args) {
		// 제어문 종류
		/*
		   -비교문(분기문)
		      1)if문: 단순if문, is~else문, 다중 if문
		      2)switch문: 
		   -반복문
		      1)for문
		      2)while문
		      3)do while문
		   -탈출문
		      break문
		      continue문
		*/
		
		int su1 = 5;
		
		/*
			[조건]
			   su1의 값이 10이상이면 화면에 "10점 이상"이라는
			   문자열을 출력하시오!
			   
			위의 조건 내용을 가지고 if문을 구현하면 단순if 문으로 가능하다.
			if(조건식)
				System.out.println("10점이상");
		 */
		
		if(su1>=10) {
			int su2 = 0;
			System.out.println("10점 이상");
			System.out.println("입니다.");			
		}
		
		//su2가 선언되는 33행에서는 if 문의 영역이므로
		//if문의 영역인 34~38행 까지에서만 사용할 수 있는 지역 변수다.
	}

}
