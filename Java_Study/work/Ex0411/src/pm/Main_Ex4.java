package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main_Ex4 {
	
	public static void main(String[] args) {
		// 읽기할 파일의 경로
				String path ="c:/my_study/io_test.txt";
				File f= new File(path);
				
				ObjectInputStream ois = null;
				try {
					ois = new ObjectInputStream(new FileInputStream(f));
					
					//객체 읽어오기
					Object obj = ois.readObject();
					
					if(obj instanceof ArrayList) {
						//obj가 가리키는 주소지에 DataVO라는 객체가 있다면
						// 변수를 하나 만들어서 DataVO로 형변환 하자!
						ArrayList<DataVO> list = (ArrayList<DataVO>)obj;
						for(int i =0;i<list.size();i++) {
							DataVO vo = list.get(i);
							String n = vo.getName();
							int v = vo.getValue();
							System.out.printf("name:%s, value:%d",n,v);
							System.out.println();
						}
						System.out.println("~~~~~~~~~~~~~~~~읽기 끝!");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(ois != null)
							ois.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}

	}

}
