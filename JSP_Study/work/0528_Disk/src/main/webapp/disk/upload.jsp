<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	첨부된 파일을 받기 위해선 servlets.com에 있는 cos라이브러리가 필요하다.
	사이트 왼쪽 메뉴에 [COS File upload Library]라는 메뉴를 선택한 후
	화면 아래로 내려[Download]항목에 있는 표에 cos-22.05.zip을 다운받아
	압축해제 후 그 안에 있는 lib/cos.jar파일을 현재 프로젝트의
	webapp/WEB-INF/lib에 복사해 넣는다.
--%>
<%
	String dir = (String)session.getAttribute("dir");
	//첨부파일을 받아서 서버에 올리기 위해 필요한 객체를 생성한다.
	MultipartRequest mr = new MultipartRequest(
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>