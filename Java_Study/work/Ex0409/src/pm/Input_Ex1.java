package pm;

import java.io.IOException;
import java.io.InputStream;

public class Input_Ex1 {

	public static void main(String[] args) {
		// 키보드 ( System.in )와 연결된 스트림 얻기
		InputStream key = System.in;
		
		System.out.println("입력:");
		
		try {
			int code = key.read();
			System.out.print(code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
