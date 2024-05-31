package am.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.DeptVO;
import am.vo.EmpVO;
import am.vo.LocVO;

public class Main_Ex4 {
	public static void main(String[] args) throws Exception {
		Reader r = Resources.getResourceAsReader("am/config/config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		r.close();
		
		SqlSession ss = factory.openSession();
		
		List<EmpVO> e_list = ss.selectList("emp.all");
		
		for(int i=0; i<e_list.size();i++) {
			EmpVO evo = e_list.get(i);
			
			//사원 정보안에 있는 부서정보 얻기
			DeptVO dvo = evo.getDvo();
			
			LocVO lvo = dvo.getLvo();
			
			System.out.println(evo.getEmpno()+"/"+evo.getEname()+"/"+evo.getJob()+"/"+dvo.getDeptno()+"/"+dvo.getDname()+"/"+lvo.getLoc_code()+"/"+lvo.getCity());
		}
		
		if(ss!=null)
			ss.close();

	}
}
