package mybatis.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import mybatis.vo.EmpVO;

@Repository
public class EmpDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<EmpVO> all() {
		return sqlSession.selectList("emp.all");
	}
}
