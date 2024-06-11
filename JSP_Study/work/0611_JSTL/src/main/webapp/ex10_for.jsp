<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:set var="msg" value="사과,배,딸기,샤인머스켓" />
    <c:set var="ar" value="${fn:split(msg,',')}" />
    
    <ul>
    <c:forEach items="${ar}" var="item">
        <li>${item}</li>
    </c:forEach>
    </ul>
<%
	request.setAttribute("fruits", "사과/배/딸기/샤인머스켓");
%>
    <ol>
    <c:forEach items="${msg}" var="item">
        <li>${item}</li>
    </c:forEach>
    </ol>
    
    <ul>
    <c:forEach items="${fruits}" var="item">
        <li>${item}</li>
    </c:forEach>
    </ul>

    <ol>
    <c:forTokens items="${fruits}" delims="/" var="item">
        <li>${item}</li>
    </c:forTokens>
    </ol>
</body>
</html>