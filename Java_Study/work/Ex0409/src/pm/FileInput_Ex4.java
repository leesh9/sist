package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInput_Ex4 {

	public static void main(String[] args) {
		//연결할 파일의 경로 준비
		String path = "c:/my_study/io_test.txt";
		
		File f = new File(path);
		if(f.exists()) {
			//파일이 존재할경우
			FileInputStream fis =null;
			try {
				fis = new FileInputStream(f);
				
				byte[] buf = new byte[2048];//바구니와 같은 역활
				int size = -1;//read함수가 읽기한 수를 저장하는 곳
				int count = 0;
				
				while((size=fis.read(buf))!=-1) {
					//실제 읽은 자원들으 buf라는 byte[]에 저장된 상태다.
					System.out.write(buf,0,size);
					//buf의 0번지부터 size가 기억하는 길이만큼 가져와서
					//문자기반의 출력을 한다.(한글이 깨지지 않는다.)
					count++;
				}
				System.out.println();
				System.out.println(count+"회 반복");
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				try {
					if(fis!=null)
						fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
