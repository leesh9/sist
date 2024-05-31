package am;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class FileInOut_Ex2 {

	public static void main(String[] args) throws Exception {
		// 웹상의 경로를 준비하자
		String path = "http://www.shutterstock.com/ko/blog/wp-content/uploads/sites/17/2020/02/arch-photo-banner.jpg";
		
		//자바에서 웹상의 경로(URL) 를 객체화 시킨다.
		URL url = new URL(path);
		
		// 웹에있는 이미지를 읽어들여서 로컬PC에 저장하려 한다.
		// 읽고/쓰기를 위한 각스트림들 준비
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("c:/my_study/img.jpg"));
		
		byte[] buf = new byte[2048];
		int size =-1;
		
		while((size=bis.read(buf))!=-1) {
			bos.write(buf,0,size);
			bos.flush();
		}
		
		System.out.println("다운로드 완료!");
		
		
	}

}
