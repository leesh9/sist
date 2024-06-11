<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%session.setAttribute("s1", "대한민국"); %>
	<form action="/ex1_2.jsp" method="post">
		<input type="hidden" name="v1" value="1000000">
        <input type="text" name="uname">
        <button type="button" onclick="exe(this.form)">보내기</button>
	</form>
	<script type="text/javascript">
		function exe(frm) {
			console.log("a")
			frm.submit;
		}
	</script>
</body>
</html>

