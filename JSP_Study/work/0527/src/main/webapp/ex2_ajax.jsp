<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	//count인자 받기
	String cnt = request.getParameter("count");
	String test = request.getParameter("test");
	int count = 0;
	if(cnt !=null)
		count = Integer.parseInt(cnt);
	
	for(int i=0; i<count;i++){
%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=test %></td>
		<td>&nbsp;</td>
	</tr>
<%
	}
%>