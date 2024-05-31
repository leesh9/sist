<%@page import="mybatis.service.FactoryService"%> 
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="java.sql.Date"%>
<%@page import="mybatis.vo.MemoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	String ip = request.getRemoteAddr();
	  
	MemoVO vo = new MemoVO();
	vo.setWriter(writer);
	vo.setContent(content);
	vo.setIp(ip);
	  
	SqlSession ss = FactoryService.getFactory().openSession();
	int cnt = ss.insert("memo.add",vo);
	if(cnt>0){
		ss.commit();	
	}else{
		ss.rollback();
	}
	if(ss!=null)
		ss.close();
	response.sendRedirect("memoList.jsp");
	
%>
