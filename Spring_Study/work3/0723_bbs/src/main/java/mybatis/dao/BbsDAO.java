package mybatis.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.BbsVO;

@Component
public class BbsDAO {
	@Autowired
	SqlSessionTemplate ss;
	
	public BbsVO[] total() {
		BbsVO[] ar =null;
		List<BbsVO>list = ss.selectList("bbs.total");
		if (list!=null&&list.size()>0) {
			ar=new BbsVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
}
