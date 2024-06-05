<%@page import="mybatis.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request에 ar 이라는 이름으로 저장된 정보를 가져온다.
	Object obj = request.getAttribute("ar");

	EmpVO[] ar =null;
	if(obj!=null){
		ar = (EmpVO[])obj;
		for(EmpVO evo : ar){
%>
		<tr>
			<td><%=evo.getEmpno() %></td>
			<td><%=evo.getEname() %></td>
			<td><%=evo.getJob() %></td>
			<td><%=evo.getDeptno() %></td>
		</tr>
<%
		}
	}
%>