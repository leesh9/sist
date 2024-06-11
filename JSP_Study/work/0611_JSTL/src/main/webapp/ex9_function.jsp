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
<%--
    현재 페이지는 str 이라는 파라미터를 받는다
    받은 파라미터의 길이를 구해보자!
--%>
    <h2>str파라미터 값: ${param.str}</h2>
    <h2>str파라미터 값의 길이: ${param.str.length()}</h2>
    <h2>str.subString(0,3):${param.str.substring(0,3)}</h2>
    <h2>str.indexOf('a'):${param.str.indexOf('a')}</h2>
    <h2>str.replace('a','b'):${param.str.replace('a','b')}</h2>

    <%-- JSTL변수 선언한 후 파라미터 값을 저장하자! --%>
    <c:set var="s1" value="${param.str}" />
    <h2>fn:length(s1):${fn:length(s1)}</h2>
    <h2>fn:substring(s1,0,3):${fn:substring(s1,0,3)}</h2>
    <h2>fn:indexOf(s1,'a'):${fn:indexOf(s1,'a')}</h2>
    <h2>fn:replace(s1,'a','b'):${fn:replace(s1,'a','b')}</h2>
	<h2>fn:toUpperCase(s1):${fn:toUpperCase(s1)}</h2>
	<h2>fn:startsWith(s1,'a'):${fn:startsWith(s1,'a')}</h2>
    <h2>fn:join(paramValues.hobby,'/'):${fn:join(paramValues.hobby,'/')}</h2>
</body>
</html>