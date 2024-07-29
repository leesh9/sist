<%@page import="mybatis.vo.CommVO"%>
<%@page import="mybatis.vo.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#bbs table { 
	    width:580px;
	    margin-left:10px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	
	.odd {background:silver}
	
	.list_bg{
		background: rgb(249,250,255);
		padding: 10px;
	}
	.list_item{
		background: #fff;
		border-radius: 10px;
		padding:  20px;
		margin-bottom: 5px;
		box-shadow: rgb(200,200,200) 0px 2px 4px 0px;
	}
		
</style>

</head>
<body>
	<div id="bbs">

	<form method="post" >
		<table summary="게시판 글쓰기">
			<caption>게시판 글쓰기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td>${vo.subject}</td>
				</tr>


				<tr>
					<th>첨부파일:</th>
					<td><a href="javascript:down('${vo.file_name}')">
						${vo.file_name}
					</a></td>
					
				</tr>

				
				<tr>
					<th>이름:</th>
					<td>${vo.writer }</td>
				</tr>

				<tr>
					<th>내용:</th>
					<td>${vo.content }</td>
				</tr>

				
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="edit()"/>
						<input type="button" value="삭제" onclick="del()"/>
						<input type="button" value="목록" onclick="javascript:location.href='list?bname=${vo.bname}&cPage=${param.cPage }'"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<form method="post" action="comm_write">
		이름:<input type="text" name="writer"/><br/>
		내용:<textarea rows="4" cols="55" name="content"></textarea><br/>
		비밀번호:<input type="password" name="pwd"/><br/>
		<input type="hidden" name="b_idx" value="${param.idx}">
		<input type="hidden" name="cPage" value="${param.cPage}"/>
		<input type="hidden" name="bname" value="${param.bname}"/>
		<input type="submit" value="저장하기" onclick="comm_write()"/> 
	</form>
	
	댓글들<hr/>
	
	<c:forEach var="cvo" items="${ vo.c_list}">
		<div class="list_bg">
			<div class="list_item">
				이름: ${cvo.writer} &nbsp;&nbsp;
				날짜: ${cvo.write_date}<br/>
				내용: ${cvo.content}
			</div>
		</div>
	</c:forEach>
	<form action="edit" method="post" name="frm" id="frm">
		<input type="hidden" name="fname" />
		<input type="hidden" name="bname" value="${param.bname}"/>
		<input type="hidden" name="b_idx" value="${param.idx}"/>
		<input type="hidden" name="cPage" value="${param.cPage}"/>
	</form>
	<form action="">
		
	</form>
	</div>
	<form name="ff" method="post" action="FileDownload">
		<input type="hidden" name="filename"/>
		<input type="hidden" name="dir" value="/resources/upload/"/>
	</form>
	<script type="text/javascript">
		function down(fname) {
		    // Get the form element by its name
		    var form = document.forms['ff'];
	
		    form.filename.value = fname;
		    
		    form.submit();
		}
		
		function comm_write(){
			document.frm.type.action = "comm_write";
			document.frm.submit();
		}
		function edit(){
			console.log("수정")
			var frm = document.forms["frm"]
			if (frm) {
                frm.action = "edit";
                frm.submit();
            } else {
                console.error('Form element not found');
            }
		}
		
		function del(){
			console.log("수정")
			var frm = document.forms["frm"]
			if (frm) {
                frm.action = "del";
                frm.submit();
            } else {
                console.error('Form element not found');
            }
		}
	</script>
</body>
</html>