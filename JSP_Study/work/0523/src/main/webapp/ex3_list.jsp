<%@page import="pm.vo.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="pm.service.FactoryService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table#table{
	 width: 350px;
	border-collapse: collapse;
}
table#table th,table#table td{
	border: 1px solid #dedede;
	padding: 4px;
	text-align: center;
        }
</style>
</head>
<body>
		<%!
			SqlSession ss = FactoryService.getFactory().openSession();
			List<DeptVO> list = ss.selectList("dept.all");
			
		%>
	<div id="wrap">
		<header><h2>부서목록</h2></header>
		<table id="table">
			<thead>
				<tr>
					<th>부서 코드</th>
					<th>부서 이름</th>
					<th>도시 코드</th>
				</tr>
			</thead>
			<tbody>
			<%
				for(DeptVO dvo:list){
			%>
				<tr>
					<td>
						<%=dvo.getDeptno()%>
					</td>
					<td>
						<%=dvo.getDname()%>
					</td>
					<td>
						<%=dvo.getLoc_code()%>
					</td>
				</tr>
			<%
				}
			%>
			</tbody>
		</table>

		
	</div>
</body>
</html>