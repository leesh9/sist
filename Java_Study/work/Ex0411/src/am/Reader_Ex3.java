package am;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader_Ex3 {

	public static void main(String[] args) {
		// 키보드(System.in) 로부터 한줄을 입력 받는다.
		// 한줄을 받기 위해 Reader를 준비하자!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// InputStreamReader는 InputStream을 받아서
		// Reader로 변화하는 스트림이다.
		
		System.out.println("입력:");
		try {
			String str = br.readLine();// 한줄 입력 받기
			
			System.out.println("받은 값:"+str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(br != null)
					br.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
