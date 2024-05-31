package pm.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pm.vo.DeptVO;
import pm.vo.EmpVO;
import pm.vo.MgrVO;

public class Main_Ex2 {
	public static void main(String[] args) throws Exception {
		Reader r = Resources.getResourceAsReader("pm/config/config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		r.close();
		
		SqlSession ss = factory.openSession();
		
		List<MgrVO> list = ss.selectList("mgr.all");
		for(int i =0;i<list.size();i++) {
			MgrVO mvo = list.get(i);
			List<EmpVO> e_list = mvo.getList();
			if(e_list.size()<1)
				continue;
			System.out.println(mvo.getEmpno()+" - "+mvo.getEname()+" / "+mvo.getJob());
			for(int j=0;j<e_list.size();j++) {
				EmpVO evo = e_list.get(j);
				System.out.println("\t"+evo.getEmpno()+"/"+evo.getEname());
			}
			
			
		}

	}
}
