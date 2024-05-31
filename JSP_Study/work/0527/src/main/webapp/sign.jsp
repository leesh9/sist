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
	이미존재하는 아이디 입니다.
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
		response.sendRedirect("ex3_index.jsp");
	}
%>