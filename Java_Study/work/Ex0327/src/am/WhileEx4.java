package am;

public class WhileEx4 {

	public static void main(String[] args) {
		int i = 0;
		while(i<6) {
			int r = (int)(Math.random()*45+1);
			System.out.printf("%d ", r);
			i++;
		}//while문 끝

	}

}
