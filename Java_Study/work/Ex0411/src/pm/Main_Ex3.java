package pm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main_Ex3 {

	public static void main(String[] args) {
		// 저장할 객체 생성
		DataVO vo1 = new DataVO();
		vo1.setName("일지매:");
		vo1.setValue(100);

		DataVO vo2 = new DataVO();
		vo2.setName("이지매:");
		vo2.setValue(200);
		
		DataVO vo3 = new DataVO();
		vo3.setName("삼지매:");
		vo3.setValue(300);
		
		//ArrayList준비
		ArrayList<DataVO> list =new ArrayList<DataVO>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		
		// 저장할 파일을 준비
		String path = "c:/my_study/io_test.txt";
		File f = new File(path);
		
		//객체를 저장하기 위해 스트림 준비
		ObjectOutputStream oos= null;
		try {
			oos=new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(list);//객체 저장
			oos.flush();
			System.out.println("저장완료!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos!=null) {
					oos.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
