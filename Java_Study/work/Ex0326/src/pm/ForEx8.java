package pm;

public class ForEx8 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		//1~50까지 수들 중 난수 발생
		int res =(int)(Math.random()*50+1);
		System.out.println(res);
		
		for(int i=0;i<res;i++) {
			//System.out.println(i+1);
			System.out.printf("%3d", i+1);
		}

	}

}
