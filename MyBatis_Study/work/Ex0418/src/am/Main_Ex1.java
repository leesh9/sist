package am;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main_Ex1 {
	SqlSessionFactory factory;
	
	public Main_Ex1() {
		// 다른 일들...
		makeFactory(); //DB를 활용할 수 있는 factory
	}
	
	private void makeFactory() {
		try {
			// 1) 환경설정 파일과 연결되는 스트림 준비
			Reader r = Resources.getResourceAsReader("am/config.xml");
			
			// 2) FactoryBuilder를 생성하면서 바로 Factory생성
			factory = new SqlSessionFactoryBuilder().build(r);
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void add(String empno, String ename,String sal,String job, String hiredate, String deptno) {
		//mybatis 환경에 인자로 전달할 객체 생성
		EmpVO vo = new EmpVO(empno, ename, job, sal, hiredate, deptno);
		
		//위의 vo객체를 인자로 보내면서 저장한다.
		SqlSession ss = factory.openSession();
		int cnt = ss.insert("emp.add",vo);
		//cnt에는 저장을 수행한 레코드 수가 저장된다.
		
		if(cnt>0) {
			System.out.println("저장완료");
			ss.commit();
		}else {
			System.out.println("저장실패!");
			ss.rollback();
		}
		
		if(ss != null)
			ss.close();
			
	}
	
	public void login(String id, String pw) {
		//로그인 SQL문장을 호출하기 위해 SqlSession을 얻어낸다.
		SqlSession ss = factory.openSession();
		
		//로그인을 하기위해 필요한 객체 준비
		MemberVO mvo = new MemberVO();
		mvo.setM_id(id);
		mvo.setM_pw(pw);
		MemberVO vo = ss.selectOne("member.login",mvo);
		
		if(vo!=null)
			System.out.println("로그인성공");
		else
			System.out.println("로그인실패");
	}
	
	public void login2(String id, String pw) {
		SqlSession ss = factory.openSession();
		
		// member.login2를 호출하기 위해 필요한 객체 준비
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		
		MemberVO vo = ss.selectOne("member.login2",map);
		
		if(ss!=null)
			ss.close();
		if(vo!=null)
			System.out.println("로그인성공");
		else
			System.out.println("로그인실패");
	}
	
	public static void main(String[] args) throws Exception{
		Main_Ex1 ex1 =new Main_Ex1();
		
		//저장을 하기 위해서 Main_Ex1안에 있는 add를 호출한다.
		//ex1.add("1300", "조운",  "900","DEVELOP", "2024-04-18", "10");
		ex1.login("test1", "1212");
		ex1.login2("test1", "1212");
		
	}

}
