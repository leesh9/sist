<%@page import="mybatis.vo.MemVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="mybatis.service.FactoryService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 전달해오는 파라미터들 받기
	String mid = request.getParameter("m_id");
	String mpw = request.getParameter("m_pw");
	SqlSession ss = FactoryService.getFactory().openSession();
	
	Map<String,String> map = new HashMap<>();
	map.put("mid", mid);
	map.put("mpw", mpw);
	MemVO mvo = ss.selectOne("member.login",map);
	
	String path = "ex2_login_after.jsp";
	
	if(mvo!=null){
		//HttpSession에 사용자의 정보를 저장
		session.setAttribute("mvo", mvo);
	}else{
		//로그인 실패한 페이지로 이동하기 위해 준비
		path = "ex2_login_fail.jsp";
	}
	
	//다른 페이지로 강제 이동
	response.sendRedirect(path);
%>

	
</body>
</html>