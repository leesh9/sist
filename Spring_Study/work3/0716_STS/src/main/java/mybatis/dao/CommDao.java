package mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.CommVO;

@Component
public class CommDao {
	@Autowired
	SqlSessionTemplate ss;
    public int add(CommVO cvo){
        int cnt = ss.insert("comm.add", cvo);
        return cnt;
    }
}
