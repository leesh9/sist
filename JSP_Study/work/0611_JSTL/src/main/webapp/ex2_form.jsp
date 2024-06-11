<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>JSTL 연습</h1>
    <form action="ex2_ok.jsp" method="post">
        <input type="text" name="u_name" placeholder="이름 입력"/>
        <br/>
        <input type="hidden" name="cPage" value="2"/>
        <select name="u_phone">
            <option value="010">010</option>
            <option value="011">011</option>
            <option value="012">017</option>
        </select>
        <input type="text" name="u_phone"/>
        <input type="text" name="u_phone"/>
        <button type="submit">보내기</button>
    </form>
</body>
</html>

