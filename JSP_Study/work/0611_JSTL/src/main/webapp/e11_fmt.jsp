<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:set var="now" value="<%=new Date()%>" />
    <h2>${now}</h2>
    <h2>오늘 날짜 : <fmt:formatDate value="${now}" type="date" /></h2>
    <h2>오늘 날짜 : <fmt:formatDate value="${now}" pattern="yyy-MM-dd" /></h2>
    <h2>오늘 시간 : <fmt:formatDate value="${now}" pattern="(a)hh:mm:ss" /></h2>
    <h2>오늘 시간 : <fmt:formatDate value="${now}" pattern="HH:mm:ss" /></h2>
    <h2>-----------------------숫자표현--------------------------</h2>
    <c:set var="num" value="12000000000.023929" />
    <h2><fmt:formatNumber value="${num}" /></h2>
    <h2><fmt:formatNumber value="${num}" groupingUsed="false" /></h2>
    <h2><fmt:formatNumber value="${num}" pattern="#,##0.00" /></h2>
    <h2><fmt:formatNumber value="0.195" pattern="0.00%" type="percent" /></h2>
    <h2><fmt:formatNumber value="${num}" type="currency" currencySymbol="$" /></h2>
</body>
</html>