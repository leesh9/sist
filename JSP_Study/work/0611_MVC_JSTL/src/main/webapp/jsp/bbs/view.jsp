<%@page import="mybatis.vo.CommVO"%>
<%@page import="mybatis.vo.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<%
	Object obj =  request.getAttribute("bvo");
	if(obj !=null){
		BbsVO bvo = (BbsVO)obj;
%>
<body>
	<div id="bbs">

	<form method="post" >
		<table summary="게시판 글쓰기">
			<caption>게시판 글쓰기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td><%=bvo.getSubject() %></td>
				</tr>


				<tr>
					<th>첨부파일:</th>
					<td><a href="javascript:down('<%=bvo.getFile_name()%>')">
						<%=bvo.getFile_name()%>
					</a></td>
					
				</tr>

				
				<tr>
					<th>이름:</th>
					<td><%=bvo.getWriter() %></td>
				</tr>

				<tr>
					<th>내용:</th>
					<td><%=bvo.getContent() %></td>
				</tr>

				
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="javascript:location.href='Controller?type=edit&bname=<%=bvo.getBname()%>&b_idx=<%=bvo.getB_idx() %>&cPage=${param.cPage }'"/>
						<input type="button" value="삭제" onclick="javascript:location.href='Controller?type=delete&bname=<%=bvo.getBname()%>&b_idx=<%=bvo.getB_idx() %>&cPage=${param.cPage }'"/>
						<input type="button" value="목록" onclick="javascript:location.href='Controller?type=list&bname=<%=bvo.getBname()%>&cPage=${param.cPage }} }'"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<form method="post" action="Controller">
		<input type="hidden" name="type" value="comm_write"/>
		이름:<input type="text" name="writer"/><br/>
		내용:<textarea rows="4" cols="55" name="content"></textarea><br/>
		비밀번호:<input type="password" name="pwd"/><br/>
		
		
		<input type="hidden" name="b_idx" value="${param.idx}">
		<input type="hidden" name="index" value=""/>
		<input type="hidden" name="cPage" value="${param.cPage}"/>
		<input type="hidden" name="bname" value="${param.bname}"/>
		<input type="submit" value="저장하기" onclick="comm_write()"/> 
	</form>
	
	댓글들<hr/>
	<%
		for(CommVO cvo : bvo.getC_list()){
	%>
		<div class="list_bg">
			<div class="list_item">
				이름:<%=cvo.getWriter() %> &nbsp;&nbsp;
				날짜:<%=cvo.getWrite_date()%><br/>
				내용:<%=cvo.getContent() %> 
			</div>
		</div>
	<%
		}
	%>
	<form action="Controller" method="post" name="frm">
		<input type="hidden" name="type" value="del"/>
		<input type="hidden" name="fname" />
		<input type="hidden" name="bname" value="${param.bname}"/>
		<input type="hidden" name="b_idx" value="${param.b_idx}"/>
		<input type="hidden" name="cPage" value="${param.cPage}"/>
	</form>
	</div>
	
	<script type="text/javascript">
		function down(fname) {
			//인자로 사용자가 클릭한 파일명을 받는다.
			//이것을 현재 문서 안에 있는 frm이라는 폼 객체에 이름이
			// fname이라는 hidden요소의 값(Value)으로 지정해 둔다.
			console.log(document.frm.fname.value);
			document.frm.fname.value = fname;
			
			document.frm.type.value = "download";
			document.frm.submit();
			
		}
		function comm_write(){
			document.frm.type.value = "comm_write";
			document.frm.submit();
		}
	</script>
</body>
</html>
<%
	}else
		response.sendRedirect("Controller");
%>