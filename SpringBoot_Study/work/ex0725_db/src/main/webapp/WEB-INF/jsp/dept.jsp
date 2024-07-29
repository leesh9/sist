<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <header>
        <h2>목록</h2>
    </header>
    <article>
        <ul>
            <c:forEach var="vo" items="${list}">
                <li>${vo.deptno}, ${vo.dname}, ${vo.loc}</li>
            </c:forEach>
        </ul>
    </article>
</body>
</html>