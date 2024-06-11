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
	<h1>JSTL의 for문 연습</h1>
	<c:set var="cnt" value="10" scope="page"/>
	<c:set var="str" value="<strong>쌍용교육센터</strong>" scope="page"/>
	
	<ul>
		<c:forEach begin="0" end="${cnt-1}" varStatus="st">
			<li>
				${st.index}/
				<c:out value="${st.index+1}"/>/
				<c:out value="${str }" escapeXml="false"/>
			</li>
		</c:forEach>
	</ul>
</body>
</html>