package am;

import java.io.File;

public class File_Ex2 {

	public static void main(String[] args) {
		// 폴더를 가지고 File객체를 생성한다면
		// 하위 폴더 및 파일들의 목록을 얻어낼 수 있다.
		
		// 파일들은 모두가 경로(위치)를 가지고 있다.
		String path = "C:/my_study/Java_Study/eclipse";
		
		//준비된 경로를 가지고 File 객체 생성
		File f = new File(path);
		
		//f가 폴더(디렉토리)일 경우에만 수행하도록 비교한다.
		if(f.exists() && f.isDirectory()) {
			//실제 존재 하면서 디렉토리인 경우에만 수행하는 곳 
			
			// 디렉토리는 내부에 서브폴더 및 파일들이 존재하므로
			// 이 모두를 얻어낼 수 있다.
			String[] sub = f.list();
			
			//하위 목록을 반복문을 이용하여 출력해보자
			for(int i=0;i<sub.length;i++) {
				System.out.println(sub[i]);
			}
			System.out.println("---------- 폴더구별 ----------------");
			
			// File[]배열로 받는 이유는 하위의 요소가
			// 파일인지? 디렉토리인지? 를 판단할 수 있기 때문이다.
			File[] sub2 = f.listFiles();
			
			for(int i=0;i<sub2.length;i++) {
				if(sub2[i].isDirectory()) {
					System.out.println(sub2[i].getName()+"("+sub2[i].length()+")");
					//디렉토리인 경우는 용량을 구하지 못한다.
				}else {
					// 파일인 경우
					System.out.println(sub2[i].getName()+"("+sub2[i].length()+")");
				}
			}
			
			
		}

	}

}
