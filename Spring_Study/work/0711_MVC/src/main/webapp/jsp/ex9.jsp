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
    코드:${c_idx}<br>
    이름:${u_name}<br>
    분류:${unit }
    <c:forEach items="${hobby}" var="str">
    	취미:${str}<br>
    </c:forEach>
</body>
</html>