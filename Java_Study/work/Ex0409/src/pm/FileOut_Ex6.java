package pm;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileOut_Ex6 {

	public static void main(String[] args) {
		// 저장하고자 하는 파일의 경로를 준비
		String path = "c:/my_study/out_test.txt";
		
		File f = new File(path);
		if(!f.exists()) {//존재하지 않는다면
			
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(f);
				// 이렇게 FileOutputStream을 생성하면
				// 해당 위치에 파일이 생성되어 덮어쓰기가된다.
				
				//쓰기할 데이터를 준비하자
				String msg = "파일에 쓰기가 잘되나요?";
				byte[] buf = msg.getBytes();
				
				//준비된 byte형배열을 쓰게한다
				fos.write(buf,0,buf.length);
				fos.flush();
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				try {
					if(fos != null)
						fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		}else {
			JOptionPane.showMessageDialog(new JFrame(), "파일이 존재합니다.");
		}
		

	}

}
