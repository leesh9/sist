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
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");
	request.setAttribute("age", "30");
	request.setAttribute("s1", "만세");
	//String v1 = request.getParameter("v1");
%> 
<%-- EL(Expression Language:표현언어) --%>
	<h1>${param.v1}</h1>
	<h1>${param.u_name}</h1>
	<h1>${requestScope.age }</h1>
	<h1>세션 s1: ${s1}</h1>
</body>
</html>