<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<td>사번:</td>
				<td>${vo.empno }</td>
			</tr>
			<tr>
				<td>이름:</td>
				<td>${vo.ename }</td>
			</tr>
			<tr>
				<td>직종</td>
				<td>${vo.job }</td>
			</tr>
			<tr>
				<td>메니저</td>
				<td>${vo.mgr }</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td>${vo.hiredate }</td>
			</tr>
			<tr>
				<td>급여</td>
				<td>${vo.sal}</td>
			</tr>
			<tr>
				<td>보너스</td>
				<td>${vo.comm }</td>
			</tr>
			<tr>
				<td>부서코드</td>
				<td>${vo.deptno }</td>
			</tr>
		</tbody>
	</table>
</body>
</html>