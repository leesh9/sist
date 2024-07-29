<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>로그인</h1>
	</header>
	<%-- 세션에 mvo라는 값이 없을 때 로그인 화면이 나타나야 한다. --%>
	<c:if test="${SessionScope.mvo eq null}">
	<form action="" method="post">
		ID:<input type="text" name="mid"/><br/>
		PW:<input type="password" name="mpw"/><br/>
		<input type="button" value="LOGIN"/>
	</form>
	<br/>
	
	<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=adab169f407acde428c3ca3913d7af32&redirect_uri=http://localhost:8080/app/login/kakao">
		<img alt="카카오 로그인" src="resources/images/kakao_login.png">
	</a>
	</c:if>
</body>
</html>