package am;

public class ForEx1 {

	public static void main(String[] args) {
		// 총 6번을 반복하면서 1~45까지의 수들 중 난수를 발생시켜보자!
		for(int i=0;i<6;i++) {
			//1) 1~45까지의 수들 중 난수 발생
			int r = (int)(Math.random()*45+1);
			System.out.printf("%d ",r);
		}

	}

}
