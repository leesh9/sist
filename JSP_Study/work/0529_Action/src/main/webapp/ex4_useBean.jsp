<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="vo" class="pm.vo.DataVO" scope="page"/>

<jsp:setProperty property="*" name="vo"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><%=vo.getMid() %></h2>
	<h2><%=vo.getMpw() %></h2>
	<h2><%=vo.getMname() %></h2>
</body>
</html>