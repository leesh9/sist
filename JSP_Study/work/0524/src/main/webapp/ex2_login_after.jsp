<%@page import="mybatis.vo.MemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.name{
		font-weight: bold;
		color: $00bfff;
	}
</style>
</head>
<body>
<%
	//세션에서 mvo 라는 키로 저장된 값을 얻어낸다.
	Object obj = session.getAttribute("mvo");
	if(obj != null){
		MemVO vo = (MemVO)obj;
		String name = vo.getM_name();
%>
		<h2><span class="name"><%=name %>님 환영합니다.</span></h2>
		<button type="button" onclick="javasctipt:location.href='ex2_logout.jsp'">로그아웃</button>
<%
	}else{
%>
		<h2>잘 못 된 정보입니다</h2>
		<button type="button" onclick="javasctipt:location.href='ex2_login.jsp'">로그인</button>
<%
	}
%>


</body>
</html>