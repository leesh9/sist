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
		System.out.println("MemDAO생성");
	}
	
	public MemVO login(String id,String pw) {
		Map<String, String> mm = new HashMap<String, String>();
		mm.put("mid", id);
		mm.put("mpw", id);
		
		//스프링에서는 세션을 자동으로 반납하기 때문에 안닫는것이 더좋다.
		return sqlSession.selectOne("mem.login",mm);
	}
}
