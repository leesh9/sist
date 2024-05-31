package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInput_Ex3 {

	public static void main(String[] args) {
		// 파일의 경로
		String path = "c:/my_study/io_test.txt";
		
		//준비된 경로를 가지고 File객체를 생성한다.
		File f = new File(path);
		
		int count=0;
		
		if(f.exists()) {
			//파일객체를 먼저 생성하여 그 파일객체로
			// 존재 여부를 확인한 후 스트림을 생성하자
			FileInputStream fis=null;
			try {
				fis = new FileInputStream(f);
				int data = -1;
				
				//파일로부터 더 이상 읽을 것이 없을 때 까지 반복처리한다.
				while((data =  fis.read()) != -1) {
					System.out.print((char)data);
					count ++;
				}//while의 끝
				System.out.println();//줄바꾸;
				System.out.println(count+"회반복");
				fis.close();//스트림 닫기
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

}
