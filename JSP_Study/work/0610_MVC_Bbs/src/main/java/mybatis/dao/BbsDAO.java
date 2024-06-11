package mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.BbsVO;

public class BbsDAO {
	
	public static int getCount(String bname) {
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.selectOne("bbs.count",bname);
		ss.close();
		return cnt;
	}
	
	public static BbsVO[] getList(String bname, int begin,
			int end) {
		BbsVO[] ar = null;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		HashMap<String, String> map = new HashMap<>();
		map.put("bname", bname);
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));
		
		List<BbsVO> list = ss.selectList("bbs.list", map);
		if(list != null && list.size() > 0) {
			ar = new BbsVO[list.size()];
			list.toArray(ar);//list가 가지는 모든 요소들을
						//ar이라는 배열에 복사한다.
		}
		ss.close();
		return ar;
	}
	
	public static BbsVO view(int idx) {
		BbsVO bvo = null;
		SqlSession ss = FactoryService.getFactory().openSession();
		bvo = ss.selectOne("bbs.view", idx);
		ss.close();
		return bvo;

	}
	
	//원글을 저장하는 기능

	public static int add(String subject, String writer, 
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
		
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.insert("bbs.add", map);
		if(cnt > 0)
			ss.commit();
		else
			ss.rollback();
		
		ss.close();
		return cnt;
	}

	//보기 기능에서 조회수 증가하는 메서드
	public static int hit(String b_idx) {
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.update("bbs.hit", b_idx);
		if(cnt > 0)
			ss.commit();
		else
			ss.rollback();
		ss.close();
		return cnt;
	}

	//원글 수정 메서드
	public static int edit(String b_idx, String subject, String writer, 
			String content, String fname, String oname, 
			String ip, String bname) { 
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("idx", b_idx);
		map.put("subject", subject);
		map.put("writer", writer);
		map.put("content", content);
		map.put("file_name", fname);
		map.put("ori_name", oname);
		map.put("ip", ip);
		map.put("bname", bname);
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.update("bbs.edit", map);
		System.out.println(cnt);
		System.out.println(map.get("idx"));
		if(cnt > 0)
			ss.commit();
		else
			ss.rollback();
		ss.close();
		return cnt;
	}

	public static int delete(String b_idx) {
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.update("bbs.delete", b_idx);
		if(cnt > 0)
			ss.commit();
		else
			ss.rollback();
		ss.close();
		return cnt;
	}
}
