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
    <h1>게시판 목록</h1>
    <a href="memo">메모장</a>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="bbs" items="${ar}">
                <tr>
                    <td>${bbs.b_idx}</td>
                    <td>${bbs.subject}</td>
                    <td>${bbs.writer}</td>
                    <td>${bbs.write_date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>