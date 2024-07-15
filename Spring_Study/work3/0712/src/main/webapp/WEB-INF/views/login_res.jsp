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
<c:if test="${mvo ne null}">
	<h2>${mvo.m_name }님 환영</h2>
</c:if>
<c:if test="${mvo eq null }">
	<h2>아이디 또는 비밀번호가 일치하지 않습니다.</h2>
</c:if>
</body>
</html>