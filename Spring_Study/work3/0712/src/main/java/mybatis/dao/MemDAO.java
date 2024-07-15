package mybatis.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import mybatis.vo.MemVO;

@Repository
public class MemDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public MemDAO() {
		System.out.println("MemDAO����");
	}
	
	public MemVO login(String id,String pw) {
		Map<String, String> mm = new HashMap<String, String>();
		mm.put("mid", id);
		mm.put("mpw", id);
		
		//������������ ������ �ڵ����� �ݳ��ϱ� ������ �ȴݴ°��� ������.
		return sqlSession.selectOne("mem.login",mm);
	}
}
