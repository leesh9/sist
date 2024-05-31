package pm;

public class ForEx7 {

	public static void main(String[] args) {
		int sum=0;
		for (int i=1;i<=10;i++) {
			sum+=i;
		}
		
		System.out.println("1~10까지의 합:"+sum);
		
		
		System.out.println("----1~10까지 반복하면서 3의 배수만 출력-----");
		for (int i=1;i<=10;i++) {
			if(i%3==0) 
				System.out.println(i);
		}
		
		System.out.println("----random활용--------");
		// 랜덤함수의 구성
		// 	Math.random()*범위+시작수
		int r = (int)(Math.random()*10+1);
		System.out.println(r);
	}

}
