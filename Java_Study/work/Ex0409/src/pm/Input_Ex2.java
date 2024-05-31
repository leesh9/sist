package pm;

import java.io.InputStream;

public class Input_Ex2 {

	public static void main(String[] args) {
		InputStream key = System.in;
		System.out.println("입력:");
		
		int i =0;
		while(i<4) {
			try {
				int data = key.read();
				System.out.println(data);
			} catch (Exception e) {
				
			}
			i++;
		}//while문의 끝
		System.out.println("프로그램 끝");
	}

}
