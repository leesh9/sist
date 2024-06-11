<%@page import="bbs.util.Paging"%>
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
	
	#bbs table th,#bbs table td {
	    text-align:center;
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
	
	/* paging */
	
	table tfoot ol.paging {
	    list-style:none;
	}
	
	table tfoot ol.paging li {
	    float:left;
	    margin-right:8px;
	}
	
	table tfoot ol.paging li a {
	    display:block;
	    padding:3px 7px;
	    border:1px solid #00B3DC;
	    color:#2f313e;
	    font-weight:bold;
	}
	
	table tfoot ol.paging li a:hover {
	    background:#00B3DC;
	    color:white;
	    font-weight:bold;
	}
	
	.disable {
	    padding:3px 7px;
	    border:1px solid silver;
	    color:silver;
	}
	
	.now {
	   padding:3px 7px;
	    border:1px solid #ff4aa5;
	    background:#ff4aa5;
	    color:white;
	    font-weight:bold;
	}
		
</style>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div id="wrap">
	<jsp:include page="/jsp/menu.jsp"></jsp:include>
	<div id="bbs">
		<table summary="게시판 목록">
			<caption>게시판 목록</caption>
			<thead>
				<tr class="title">
					<th class="no">번호</th>
					<th class="subject">제목</th>
					<th class="writer">글쓴이</th>
					<th class="reg">날짜</th>
					<th class="hit">조회수</th>
				</tr>
			</thead>
						<tfoot>
                      <tr>
                          <td colspan="4">
                              <ol class="paging">
<%
	//페이징을 위해 request에 page라는 이름으로 저장한 객체를 얻어낸다.
	Object object = request.getAttribute("page");
	Paging pvo = null;
	if(object!=null){
		pvo=(Paging)object;
		if(pvo.getStartPage()<pvo.getPagePerBlock()){
%>
	<li class="disable">&lt;</li>	
<%	
		}else{	
%>
	<li><a href="javascript:location.href='Controller?type=list&bname=bbs&cpage=<%=pvo.getStartPage()-1%>'">&lt;</a></li>
<%
		}
		for(int i=pvo.getStartPage(); i<= pvo.getEndPage();i++){
			if(i==pvo.getNowPage()){
%>
	<li class="now"><%=i%></li>
<%
			}else{
%>        
	<li><a href="javascript:location.href='Controller?type=list&bname=bbs&cpage=<%=i%>'"><%=i%></a></li>
<%
			}
		}//for의 끝
		if(pvo.getEndPage()==pvo.getTotalPage()){
%>
		<li class="disable">&gt;</li>
<%
		}else{
%>
	<li><a href="javascript:location.href='Controller?type=list&bname=bbs&cpage=<%=pvo.getEndPage()+1%>'">&gt;</a></li>	
<%
		}
	}
%>
                              </ol>
                          </td>
						  <td>
							<input type="button" value="글쓰기"
			onclick="javascript:location.href='Controller?type=write&bname=bbs'"/>
						  </td>
                      </tr>
                  </tfoot>
			<tbody>
<%
	Object obj = request.getAttribute("ar");
	BbsVO[] b_list= null;
	if(obj!=null){
		b_list = (BbsVO[])obj;
	
		for(BbsVO bvo:b_list){
%>	
		<tr>
			<td><%=bvo.getB_idx() %></td>
			<td><a href="Controller?type=view&bname=bbs&idx=<%=bvo.getB_idx() %>&cPage=<%=pvo.getNowPage()%>"><%=bvo.getSubject()%></a></td>
			<td><%=bvo.getWriter() %></td>
			<td><%=bvo.getWrite_date() %></td>

			<td><%=bvo.getHit() %></td>
		</tr>
<%
		}
	}else{
%>
		<tr>
			<td colspan="5">등록된 게시물이 없습니다.</td>
		</tr>
<%
	}
%>
		
			</tbody>
		</table>
		
	</div>
</div>
</body>
</html>