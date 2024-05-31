package am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReaderWriter_Ex5 {

	public static void main(String[] args) {
		String path = "C:/My_Study/Java_Study/work/Ex0411/src/am/ReaderWriter_Ex5.java";
		
		String path2 = "c:/My_Study/io_test.txt";
		
		//필요한 스트림들 준비
		BufferedReader br =null;
		BufferedWriter bw = null;
		
		try {
			//읽기를 위한 스트림 생성
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			
			//쓰기를 위한 스트림 생성
			bw = new BufferedWriter(new PrintWriter(path2));
			String str = null;
			while((str = br.readLine())!=null) {
				//readeLine함수는 더이상 읽을 자원이 없을 때는 null을
				// 반환한다.
				bw.write(str);
				bw.write("\r\n");//줄바꿈
				bw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(br!=null)
					br.close();
				if(bw!=null)
					bw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		System.out.println("복사 끝~!");
	}

}
