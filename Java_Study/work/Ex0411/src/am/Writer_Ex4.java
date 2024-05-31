package am;

import java.io.BufferedWriter;
import java.io.PrintWriter;

import javax.swing.Spring;

public class Writer_Ex4 {

	public static void main(String[] args) {
		// 파일에 쓰기할 자원 준비
		String msg = "오늘은 월요일 같은 목요일이다.";
		
		// 특정 파일에 쓰기 하자
		String path = "c:/my_study/io_test.txt";
		BufferedWriter bw = null;
		
		try {
			bw =  new BufferedWriter(new PrintWriter(path));
			// PrintWriter도 생성만 했을 때 파일을 생성한다.
			
			// 스트림을 통해 쓰기한다.
			bw.write(msg);
			bw.flush();
		} catch (Exception e) {

		}
		
		System.out.println("쓰기 완료!");
	}

}
