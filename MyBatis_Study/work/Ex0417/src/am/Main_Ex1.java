package am;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main_Ex1 {

	public static void main(String[] args) throws Exception {
		// 환경설정 파일 읽기에 쓰일 스트림준비
		Reader r = Resources.getResourceAsReader("am/config.xml");
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		SqlSessionFactory factory = builder.build(r);
		r.close();
		
		SqlSession ss = factory.openSession();
		
		List<EmpVO> list = ss.selectList("emp.all");
		
		for(int i=0; i<list.size();i++) {
			EmpVO vo = list.get(i);
			
			System.out.println(vo.getEmpno()+"/"+vo.getEname()+"/"+vo.getJob());
		}
		
		System.out.println("---------------------------------");
		System.out.println(list.size()+"명");
		ss.close();
		
	}

}
