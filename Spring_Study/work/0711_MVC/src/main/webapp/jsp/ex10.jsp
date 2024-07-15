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
    코드:${vo.c_idx}<br>
    이름:${vo.u_name}<br>
    분류:${unit }<br>
    <c:forEach items="${vo.hobby}" var="str">
    	취미:${str}<br>
    </c:forEach>
</body>
</html>