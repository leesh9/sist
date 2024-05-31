package am.client;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.DataVO;

public class Main_Ex1 {

	public static void main(String[] args) throws Exception {
		// 1) 환경 설정 파일과 연동되는 스트림 Reader준비
		Reader r = Resources.getResourceAsReader("am/config/config.xml");
		
		// 2) factory 생성
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		r.close();
		
		SqlSession ss = factory.openSession();
		
		List<DataVO> list = ss.selectList("emp_dept.all");
		
		System.out.println("[결과]");
		for(int i=0;i<list.size();i++) {
			DataVO vo = list.get(i);
			System.out.println();
		}//for의 끝
		if(ss!=null)
			ss.close();
	}

}
