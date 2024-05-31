package am.client;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.DeptVO;
import am.vo.EmpVO;

public class Main_Ex2 {

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
			
			System.out.println(evo.getEmpno()+"/"+evo.getEname()+"/"+evo.getJob()+"/"+dvo.getDeptno()+"/"+dvo.getDname());
		}
		if(ss!=null)
			ss.close();
	}

}
