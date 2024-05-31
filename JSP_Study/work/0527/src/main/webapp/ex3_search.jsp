<%@page import="java.util.List"%>
<%@page import="mybatis.service.FactoryService"%>
<%@page import="mybatis.vo.EmpVO"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	//전달되어 오는 파라미터(s_type, s_value)들 받기
	String s_type = request.getParameter("s_type");
	String s_value = request.getParameter("s_value");
	
	//유효성 검사...(생략)
	Map<String,String> map = new HashMap<>();
	map.put("searchType", s_type);
	map.put("searchValue", s_value);
	
	SqlSession ss = FactoryService.getFactory().openSession();
	List<EmpVO> list = ss.selectList("emp.search",map);
	
	
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