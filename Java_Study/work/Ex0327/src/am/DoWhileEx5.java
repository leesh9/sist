package am;

public class DoWhileEx5 {

	public static void main(String[] args) {
		//do~while의 수성
		/*
		 	do{
		 		
		 	}while(조건식);
		 	
		 	1~10까지 반복 수행하는 do~while문 구현!
		 */
		int i = 11;
		do {
			System.out.println(i);
			i++;
		}while(i<=10);
		// do~while은 선처리, 후 비교 이므로
		// 조건에 맞지 않아도 1번은 수행한다.
		
		System.out.println("--- 1~100까지의 합을 구하는 반복문 ---");
		
		int sum=0;
		
		i=1;
		do {
			sum+=i++;
		}while(i<=100);
		System.out.println(sum);
	}

}
