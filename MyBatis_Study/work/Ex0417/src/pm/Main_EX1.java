package pm;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main_EX1 {

	public static void main(String[] args) throws Exception {
		//환경설정 파일(config.xml)과 연결되는 스트림 준비
		Reader r = Resources.getResourceAsReader("pm/config.xml");
		
		// 우리가 필요한 객체는 SqlSession이다. 이것을 얻어내기 위해
		// SqlSession을 만드는 공장을 세워야 하고 그러기 위해서는
		// 앞서 공장을 세우는 일꾼을 만들어야 한다.
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		//만들어진 일꾼을 가지고 공장을 세우자
		SqlSessionFactory factory = builder.build(r);
		r.close();
		//----- 한번만 수행하는 것이 유리하다고 생각됨 ----
		
		
		// 위에서 만든 공장(factory)
		SqlSession ss = factory.openSession();
		
		//위의 SqlSession이 있어야 그것을 통해 SOL 문장을 호출한다.
		List<DeptVO> list = ss.selectList("dept.all");
		
		System.out.println(list.size()+"개 부서");
		
		System.out.println("------ 부서명 검색 ---------");
		Scanner scan = new Scanner(System.in);
		System.out.println("부서명: ");
		String dname = scan.nextLine();
		
		List<DeptVO> list2 = ss.selectList("dept.search_name",dname);
		
		for(int i=0;i<list2.size();i++) {
			DeptVO vo = list2.get(i);//부서객체 하나 얻어내기
			System.out.println(vo.getDeptno()+"/"+vo.getDname()+"/"+vo.getLoc_code());
		}
		
		ss.close();
		
		
	}

}
