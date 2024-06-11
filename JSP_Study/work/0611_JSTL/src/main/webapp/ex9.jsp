<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ex9_function.jsp" method="post">
		<label>값:</label>
		<input type="text" name="str">
		<br/>
		취미:
		<input type="checkbox" name="hobby" value="music">음악 &nbsp; &nbsp;
		<input type="checkbox" name="hobby" value="sport">운동 &nbsp; &nbsp;
		<input type="checkbox" name="hobby" value="travel">여행 &nbsp; &nbsp;
		<button>입력</button>
	</form>
</body>
</html>