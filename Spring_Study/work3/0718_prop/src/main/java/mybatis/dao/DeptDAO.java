package mybatis.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.DeptVO;

@Component
public class DeptDAO {
	
	@Autowired
	SqlSessionTemplate ss;
	
	public DeptVO[] total() {
		DeptVO[] ar = null;
		
		List<DeptVO> list = ss.selectList("dept.total");
		if (list != null && list.size()>0) {
			ar = new DeptVO[list.size()];
			//리스트에 있는 내용을 그대로 같은 크기의 배열에 복사하기
			list.toArray(ar);
		}
		
		return ar;
	}
	
	public DeptVO[] search(Map<String, String> map) {
		DeptVO[] ar = null;
		List<DeptVO> list = ss.selectList("dept.search",map);
		if (list != null && list.size()>0) {
			ar = new DeptVO[list.size()];
			
			//리스트에 있는 내용을 그대로 같은 크기의 배열에 복사하기
			list.toArray(ar);
		}
		return ar;
	}
}
