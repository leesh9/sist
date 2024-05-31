package pm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main_Ex1 {

	public static void main(String[] args) {
		// 저장할 객체를 생성하자
		DataVO vo = new DataVO();
		vo.setName("마루치");
		vo.setValue(100);
		
		//저장할 파일객체
		File f = new File("c:/my_study/io_test.txt");
		
		// 객체를 저장하기 위해 객체스트림을 준비하자
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(vo);//vo라는 객체를 쓰기한다.
			oos.flush();
			System.out.println("객체쓰기 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos!=null)
					oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
