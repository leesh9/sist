package mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.DeptVO;

public class DeptDao {
	public static DeptVO[] getDeptList() {
		DeptVO[] ar = null;
		SqlSession ss= FactoryService.getFactory().openSession();
		List<DeptVO> list = ss.selectList("dept.all");
		
		if(list != null && list.size()>0) {	
			ar = new DeptVO[list.size()];
			
			list.toArray(ar);
		}
		ss.close();
		
		return ar;
	}
}
