<%@page import="ex1.vo.Test2VO"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
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
	BeanFactory bf = new ClassPathXmlApplicationContext("config.xml");
	
	Test2VO vo = (Test2VO)bf.getBean("t2");
%>
<h1><%= vo.getStr() %></h1>
<h1><%= vo.getValue() %> </h1>
</body>
</html>