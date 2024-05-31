package pm;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main_Ex1 {
	SqlSessionFactory factory;
	
	Main_Ex1(){
		makeFactory();
	}
	
	// factory를 생성하는 동작 - 생성자에서 단 한번만 호출 되도록 한다.
	public void makeFactory() {
		
		try {
			Reader r = Resources.getResourceAsReader("pm/config.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
			r.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printList(List<MemVO> list) {
		for(int i=0;i<list.size();i++) {
			MemVO mvo = list.get(i);
			System.out.println(mvo.getM_idx()+"/"+mvo.getM_id()+"/"+mvo.getMname()+"/"+mvo.getEmail()+"/"+mvo.getPhone());
		}
	}
	
	public void search_name(String mname) {
		SqlSession ss = factory.openSession();
		List<MemVO> list = ss.selectList("mem.search_name",mname);
		printList(list);
		
	}
	
	public void search(String email,String phone) {
		SqlSession ss = factory.openSession();
		Map<String, String> map =new HashMap<String, String>();
		if(email != null)
			map.put("key1", email);
		if(phone != null)
			map.put("key2", phone);
		// 모두 비었을때 제어권 반환
		if(email == null && phone == null)
			return;
		
		
		List<MemVO> list = ss.selectList("mem.search",map);
		printList(list);
	}
	
	public static void main(String[] args) {
		Main_Ex1 ma = new Main_Ex1();
		ma.search_name("김");
		ma.search("korea", null);
	}
}
