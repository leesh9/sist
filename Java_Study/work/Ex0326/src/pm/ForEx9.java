package pm;

public class ForEx9 {

	public static void main(String[] args) {
		//2~9
		//다음 보기와 같은 구구단을 출력하자
		/*
		 3*1 = 3
		 ...
		 3*9 = 27
		 */
		int ran =(int)(Math.random()*8+2);
		System.out.printf("%d단\n", ran);
		System.out.println("--------");
		for(int i=1;i<=9;i++) {
			System.out.printf("%d*%d=%d\n",ran,i,ran*i);
		}

	}

}
