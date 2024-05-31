<%@page import="java.io.File"%>
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

	//파일이 저장될 위치를 반드시 서버의 절대경로로 준비해야한다.
	String realPath = application.getRealPath("/members/"+dir);
	
	//첨부파일을 받아서 서버에 올리기 위해 필요한 객체를 생성한다.
	MultipartRequest mr = new MultipartRequest(request,realPath,1024*1024*5,new DefaultFileRenamePolicy());
	//이때 첨부되는 파일들이 지정된 realPath에 저장된다.
	
	//파일명이 변경될 수도 있으므로 확인하기 위해서
	//먼저 첨부 파일을 File객체로 얻어낸다.
	File f = mr.getFile("upload");//파라미터명
	
	String f_name = f.getName();// 현재 파일명
	
	//변경 전의 파일명
	String o_name = mr.getOriginalFileName("upload");
	
	//페이지 강제이동
	//response.sendRedirect("myDisk.jsp?cPath="+dir);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload ="movePage()">
	<form action="myDisk.jsp" method="post">
		<input type="hidden" name="cPath" value="<%=dir%>">
	</form>
</body>
<script type="text/javascript">
	function movePage() {
		document.forms[0].submit();
	}
</script>
</html>