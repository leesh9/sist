<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//세션의 getAttribute메서드는 세션에 저장시 어떤 객체를
	//저장했는지 몰라서 최상위 객체인 Object를 반환한다. 그래서
	//	저장시 자료형으로 형변환하면 원하는 작업을 할 수 있다.
	//	개발자는 저장할 때 어떤 자료형으로 저장했는지? 알고 있다.
	Object obj = session.getAttribute("u_name");

	//obj가 null이 아닐 때만 형변환 하자!
	if(obj!=null){
		String name = (String)obj;
%>
		<h2><%= name %>님 환영합니다.</h2><br/>
		<button type="button" onclick="logout('<%=name%>')">로그아웃</button>
<%
	}
%>
<script type="text/javascript">
	function logout(n) {
		//자바스크립트에서 페이지 이동...
		location.href="ex1_session2.jsp?name="+n;
	}
</script>
</body>
</html>