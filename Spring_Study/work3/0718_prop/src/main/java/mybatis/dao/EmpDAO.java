package mybatis.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.EmpVO;

@Component
public class EmpDAO {
	@Autowired
	SqlSessionTemplate ss;
	
	public EmpVO[] total() {
		EmpVO[] ar=null;
		
		List<EmpVO> list = ss.selectList("emp.total");
		
		if (list!=null&&list.size()>0) {
			ar= new EmpVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
	
	public EmpVO[] search(Map<String, String>map) {
		EmpVO[] ar=null;
		
		List<EmpVO> list = ss.selectList("emp.search",map);
		
		if (list!=null&&list.size()>0) {
			ar= new EmpVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
}
