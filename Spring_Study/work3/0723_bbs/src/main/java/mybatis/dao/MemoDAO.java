package mybatis.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.BbsVO;
import mybatis.vo.MemoVO;

@Component
public class MemoDAO {
	@Autowired
	SqlSessionTemplate ss;
	
	public MemoVO[] total() {
		MemoVO[] ar =null;
		List<MemoVO>list = ss.selectList("memo.total");
		if (list!=null&&list.size()>0) {
			ar=new MemoVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
}
