package mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.EmpVO;

public class EmpDao {
	
	public static EmpVO[] getList() {
		EmpVO[] ar = null;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		List<EmpVO> list = ss.selectList("emp.all");
		
		if(list != null && list.size()>0) {
			ar = new EmpVO[list.size()];
			
			list.toArray(ar);
		}
		ss.close();
		
		return ar;
	}
}
