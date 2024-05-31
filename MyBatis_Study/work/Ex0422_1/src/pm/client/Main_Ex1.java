package pm.client;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pm.vo.DeptVO;
import pm.vo.EmpVO;


public class Main_Ex1 {

	public static void main(String[] args) throws Exception {
		Reader r = Resources.getResourceAsReader("pm/config/config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		r.close();
		
		SqlSession ss = factory.openSession();
		
		List<DeptVO> list = ss.selectList("dept.all");
		for(int i =0;i<list.size();i++) {
			DeptVO dvo = list.get(i); // 부서정보 얻기
			
			//해당 부서정보 안에 있는 사원들 얻기
			List<EmpVO> e_list = dvo.getE_list();
			System.out.println(dvo.getDeptno()+" - "+dvo.getDname()+"/"+dvo.getLvo().getCity()+"("+e_list.size()+"명)");
			for(int j=0; j<e_list.size();j++) {
				EmpVO evo = e_list.get(j);
				System.out.println("\t-"+evo.getEmpno()+"/"+evo.getEname());
			}
		}

	}

}
