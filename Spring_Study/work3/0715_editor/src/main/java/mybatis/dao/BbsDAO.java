package mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import mybatis.vo.BbsVO;
@Component
public class BbsDAO {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	public BbsVO[] getList(String bname, int begin,
			int end) {
		BbsVO[] ar = null;
		
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("bname", bname);
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));
		
		List<BbsVO> list = ss.selectList("bbs.list", map);
		if(list != null && list.size() > 0) {
			ar = new BbsVO[list.size()];
			list.toArray(ar);
		}
		return ar;
	}
		
	
}
