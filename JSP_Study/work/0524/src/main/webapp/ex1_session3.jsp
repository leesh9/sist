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
	Object obj = session.getAttribute("u_name");

	if(obj == null){
%>
		<h3>저장된 값이 없습니다.</h3>
<%
	}else{
		String name = (String)obj;
%>
		<h3><%=name %>님 반갑습니다.</h3>
<%
	}
%>
</body>
</html>