package mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.BbsVO;
@Component
public class BbsDAO {
	@Autowired
	SqlSessionTemplate ss;
	public  int getCount(String bname) {
		int cnt = ss.selectOne("bbs.count",bname);
		
		return cnt;
	}
	
	public  BbsVO[] getList(String bname, int begin,
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
	
	public  BbsVO view(String idx) {
		BbsVO bvo = null;
		
		bvo = ss.selectOne("bbs.view", idx);
		
		return bvo;

	}
	

	public  int add(String subject, String writer, 
			String content, String fname, String oname, 
			String ip, String bname) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("subject", subject);
		map.put("writer", writer);
		map.put("content", content);
		map.put("file_name", fname);
		map.put("ori_name", oname);
		map.put("ip", ip);
		map.put("bname", bname);
		
		
		int cnt = ss.insert("bbs.add", map);		
		return cnt;
	}


	public  int hit(String b_idx) {
		return ss.update("bbs.hit", b_idx);
	}


	public  int edit(BbsVO vo) { 
		return ss.update("bbs.edit", vo);
	}

	public  int delete(String b_idx) {
		int cnt = ss.update("bbs.delete", b_idx);
		if(cnt > 0)
			ss.commit();
		else
			ss.rollback();
		return cnt;
	}
}
