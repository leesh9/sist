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
	<c:set var="i" value="${param.count }"/>
	
	<h3>
		<c:if test="${i>50}">
			50보다 크다
		</c:if>
		<c:if test="${i<=50}">
			50이하
		</c:if>
		
	</h3>
</body>
</html>