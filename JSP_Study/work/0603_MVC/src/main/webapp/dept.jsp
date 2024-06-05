<%@page import="mybatis.vo.DeptVO"%>
<%@page import="mybatis.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id ="wrap">
		<header>
			<h1>사원목록</h1>	
		</header>
		<article>
			<table id="table">
				<caption>사원목록 테이블</caption>
				<thead>
					<tr>
						<th>부서코드</th>
						<th>부서명</th>
						<th>도시코드</th>
					</tr>
				</thead>
				<tbody>
<%
	Object obj = request.getAttribute("dept");
	if(obj != null){
		DeptVO[] ar = (DeptVO[])obj;
		for(DeptVO evo : ar){
%>
					<tr>
							<td><%=evo.getDeptno() %></td>
							<td><%=evo.getDname() %></td>
							<td><%=evo.getLoc_code() %></td>
					</tr>
<%
		}
	}
%>
				</tbody>
			</table>
		</article>
	</div>



</body>
</html>