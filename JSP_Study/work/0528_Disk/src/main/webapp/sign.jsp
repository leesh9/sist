<%@page import="java.io.File"%>
<%@page import="mybatis.service.FactoryService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="mybatis.vo.MemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	SqlSession ss = FactoryService.getFactory().openSession();

	String m_id = request.getParameter("m_id");
	String m_pw = request.getParameter("m_pw");
	String m_name = request.getParameter("m_name");
	String m_email = request.getParameter("m_email");
	String m_phone = request.getParameter("m_pehone");
	
	MemVO vo = ss.selectOne("member.check_id",m_id);
	String msg="";
	if(vo!=null){
%>
	<span>이미존재하는 아이디 입니다.</span>
<% 
	}else{
		MemVO mvo = new MemVO();
		mvo.setM_id(m_id);
		mvo.setM_pw(m_pw);
		mvo.setM_email(m_email);
		mvo.setM_name(m_name);
		mvo.setM_phone(m_phone);
		
		
		int cnt = ss.insert("member.add",mvo);
		if(cnt>0){
			ss.commit();
			//회원가입에 성공한 회원의 아이디로 된 폴더를
			//members 라는 폴더에 만들어야한다.
			String path = application.getRealPath("/members/"+mvo.getM_id());
			//System.out.println("path="+path);
			
			//앞서 절대 경로를 가지고 File객체를 생성한다.
			File f = new File(path);
			
			//가상으로 만든 File객체가 실제 존재하지 않을 때만
			//물리적으로 폴더 생성하자
			if(!f.exists()){
				f.mkdir();
			}
%>
		<span>저장완료!</span>
<%
		}else{
			ss.rollback();
%>
		<span>저장실패!</span>
<%
		}
		if(ss!=null)
			ss.close();
	}
%>