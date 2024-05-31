package pm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Buffered_Ex7 {

	public static void main(String[] args) {
		// 현재 파일의 경로를 준비하자!
		String path = "c:/my_study/Java_study/work/Ex0409/src/pm/Buffered_Ex7.java";
		
		String w_path="c:/my_study/io_test.txt";
		
		//위의 파일의 내용을 읽어서 "c:/my_study/io_test.txt"파일에
		// 쓰기하시오
		String str =null;
		File f = new File(path);
		if(f.exists()) {
			BufferedInputStream bis=null;
			try {
				bis = new BufferedInputStream(new FileInputStream(f));
				byte[] buf =new byte[2048];
				int size=-1;
				while((size=bis.read(buf))!=-1) {
					str=new String(buf,0,size);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				if(bis!=null)
					try {
						bis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
		BufferedOutputStream bos=null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(w_path));
			byte[] buf = str.getBytes();
			
			bos.write(buf);
			bos.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(bos!=null) {
					bos.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
