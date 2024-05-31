<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSP주석 
	JSP기본 문법 : 스크립트 요소 3가지
	- 선언문: <%! 맴버들 선언 %>
	- 스크립트릿 : <% 자바 문법(지역변수 선언, 제어문, 연산식 등) %>
	- 출력문 : <%= 변수명 또는 연산식 %> 
--%>
<%!
	// 선언부 (맴버변수, 상수, 매서드 정의)
	int cnt = 10;
	String str = "고래와 나";
	
	//cnt값을 반환하는 기능(메서드)
	public int getCnt(){
		return cnt;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 
	//선언부
	final String msg = "대한민국";//상수
%>
<div>
	<header>
		<h1>JSP연습</h1>
	</header>
	<article>
		<ol>
		<% 
			for(int i=0;i<cnt; i++){
		%>
			<li><%= str %></li>
		<%
			}
		%>
		</ol>
	</article>
</div>
</body>
</html>