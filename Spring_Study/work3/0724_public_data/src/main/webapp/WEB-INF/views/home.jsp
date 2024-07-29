<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	<c:forEach items="${data_list }" var="vo">
		미세먼지농도 : ${vo.pm10Value } / 미세먼지등급 : ${vo.pm10Grade }  / 일산화탄소농도 : ${vo.coValue } / 일산화탄소등급 : ${vo.coGrade } / 통합대기환경등급 : ${vo.khaiGrade }
		<br/>
	</c:forEach>
</h1>

</body>
</html>
