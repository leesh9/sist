<%@page import="java.util.HashMap"%>
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
 request.setCharacterEncoding("utf-8");
 
 String u_name = request.getParameter("u_name");
 String cPage = request.getParameter("cPage");

 //Map구조
 HashMap<String, String> map = new HashMap<>();
 map.put("cPage", cPage);
 
 request.setAttribute("map", map);
 request.setAttribute("u_name", u_name);

session.setAttribute("msg", "쌍용교육센터");
%>
    <jsp:forward page="ex2_res.jsp"/>
<h1><%=u_name %></h1>
<h1><%=cPage %></h1>
</body>
</html>