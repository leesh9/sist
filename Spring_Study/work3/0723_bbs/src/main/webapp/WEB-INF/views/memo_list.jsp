<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>메모장 목록</h1>
    <a href="bbs">게시판</a>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="memo" items="${ar}">
                <tr>
                    <td>${memo.m_idx}</td>
                    <td>${memo.content}</td>
                    <td>${memo.writer}</td>
                    <td>${memo.write_date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>