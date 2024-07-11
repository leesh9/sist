<%@page import="ex1.vo.Test4VO"%>
<%@page import="ex1.vo.TestVO"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
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
	//준비된 환경설정 파일(config.xml)을 로드한다. 
	BeanFactory bf = new ClassPathXmlApplicationContext("config.xml");
	// 이때 config.xml에 정의된 모든 bean들이 생성된다.
	TestVO tt = (TestVO)bf.getBean("t1");
	
	//클래스의 유형을 가지고 빈객체를 검사한다.
	
	Test4VO t4= bf.getBean(Test4VO.class);
%>
	<h1><%= tt.getMsg() %></h1>
	<h1><%=t4.getTest().getStr() %></h1>
</body>
</html>