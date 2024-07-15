<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>단순JSP페이지</h2>
	<hr/>
	<form action="ex7.inc" method="post">
		id : <input type="text" name="id"/><br/>
		pw : <input type="password" name="pw"/><br/>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>