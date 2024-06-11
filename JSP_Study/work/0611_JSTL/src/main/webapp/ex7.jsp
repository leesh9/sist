<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vo.TestVO"%>
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
	TestVO t1 = new TestVO("홍길동","010-1111-1111","hong@test.com");
	TestVO t2 = new TestVO("이순신","010-2222-2222","lee@test.com");
	TestVO t3  = new TestVO("유관순","010-3333-3333","yoo@test.com");
	
	List<TestVO> list = new ArrayList<>();
	list.add(t1);
	list.add(t2);
	list.add(t3);
	
    //리스트 구조 안에 앞서 만든 3개의 객체가 저장된 상태다. 이런 리스트를
    //세션에 저장
	request.setAttribute("list", list);
%>
    <button onclick="location.href='ex7_for.jsp'">보내기</button>
</body>
</html>

