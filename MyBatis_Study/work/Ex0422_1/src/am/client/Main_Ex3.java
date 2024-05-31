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

public class Main_Ex3 {

	public static void main(String[] args) throws Exception {
		Reader r = Resources.getResourceAsReader("am/config/config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		r.close();
		
		SqlSession ss = factory.openSession();
		
		List<DeptVO> d_list = ss.selectList("dept.total");
		
		for(int i=0; i<d_list.size();i++) {
			
			DeptVO dvo = d_list.get(i);
			
			LocVO lvo = dvo.getLvo();
			
			System.out.println(dvo.getDeptno()+"/"+dvo.getDname()+"/"+lvo.getLoc_code()+"/"+lvo.getCity());
		}
		if(ss!=null)
			ss.close();
	}

}
