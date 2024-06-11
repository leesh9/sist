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
	<%-- 파라미터 값을 JSTL변수에 저장 --%>
	<c:set var="s_id" value="${ param.s_id}"/>
	
	<c:if test="${s_id eq 'admin'}"> <%-- ==는 eq와 같다 --%>
		${s_id } 관리자님 환영합니다.
	</c:if>
	<c:if test="${s_id ne ('admin')}"> <%-- !=는 ne와 같다 --%>
		${s_id } 회원님 환영합니다.
	</c:if>
</body>
</html> 