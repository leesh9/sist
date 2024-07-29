<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
</head>
<body>
    <h1>게시판 목록</h1>
    <table border="1">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="vo" items="${list}">
                <tr>
                    <td>${vo.b_idx}</td>
                    <td><a href="bbs/view?b_idx=${vo.b_idx}">${vo.subject}</a></td>
                    <td>${vo.writer}</td>
                    <td>${vo.write_date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>