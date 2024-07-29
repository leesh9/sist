package mybatis.dao;



import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatis.vo.DeptVO;
import mybatis.vo.EmpVO;

@Repository
public class DeptDAO {
	
	@Autowired
	public SqlSessionTemplate ss;
	
	public DeptVO[] total() {
		DeptVO[] ar = null;
		
		List<DeptVO> list = ss.selectList("dept.total");
		if(list !=null && list.size()>0) {
			ar = new DeptVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
}
