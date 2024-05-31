<%@page import="mybatis.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@page import="mybatis.service.FactoryService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// FactoryService를 통해 Sql Session을얻어낸다
	
	//SqlSession을 통해 원하는 select를 호출하여
	//결과를 List<EmpVO>로 받는다.
	
	//반복문을 이용하여 tbody에 출력할 행
	
	request.setCharacterEncoding("utf-8");
	
	SqlSession ss = FactoryService.getFactory().openSession();
	List<EmpVO> list  = ss.selectList("emp.all");
	
	for(int i=0;i<list.size();i++){
		EmpVO vo = list.get(i);
%>
		<tr>
			<td><%= i %></td>
			<td><%= vo.getEmpno() %></td>
			<td><%= vo.getEname() %></td>
			<td><%= vo.getJob() %></td>
			<td><%= vo.getHiredate() %></td>
			<td><%= vo.getDeptno() %></td>
		</tr>
<%
	}
	ss.close();
%>