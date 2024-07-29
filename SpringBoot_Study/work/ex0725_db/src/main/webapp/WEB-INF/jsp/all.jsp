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
        <form action="search" method="post">
            <select name="type">
                <option value="0">사번</option>
                <option value="1">이름</option>
                <option value="2">직책</option>
                <option value="3">부서번호</option>
            </select>
            <input type="text" name="value" placeholder="검색어를 입력하세요">
            <input type="submit" value="검색">
        </form>
        <table>
            <thead>
                <tr>
                    <th>사번</th>
                    <th>이름</th>
                    <th>직책</th>
                    <th>부서번호</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="vo" items="${list}">
                <tr>
                    <td>${vo.empno}</td>
                    <td>${vo.ename}</td>
                    <td>${vo.job}</td>
                    <td>${vo.deptno}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </article>
</body>
</html>