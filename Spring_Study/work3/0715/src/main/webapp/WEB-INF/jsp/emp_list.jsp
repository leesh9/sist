<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#box table{
		width:550px;
		margin-left: 10px;
		border:1px solid black;
		border-collapse: collapse;
		font-size: 13px;
	}
	#box table th, #box table td{
		text-align: center;
		border: 1px solid black;
		padding: 4px;
	}
</style>
</head>
<body>
	<div id="box">
		<header>
			<h1>사원목록</h1>
		</header>
		<table>
			<caption>사원목록</caption>
			<thead>
				<tr>
					<td colspan="5">
						<form action="emp_search" action="post">
							<select name="searchType">
								<option value="1">사번</option>
								<option value="2">이름</option>
								<option value="3">부서코드</option>						
							</select>
							<input type="text" name="searchValue" id="searchValue">
							<button type="button" onclick="exe(this.form)">검색</button>
						</form>
					</td>
				</tr>
				<tr>
					<th>사번</th>
					<th>이름</th>
					<th>직종</th>
					<th>입사일</th>
					<th>부서코드</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="vo" items="${ar }">
				<tr>
					<td>${vo.empno }</td>
					<td>${vo.ename }</td>
					<td>${vo.job }</td>
					<td>${vo.hiredate }</td>
					<td>${vo.deptno }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		function exe(frm) {
			//검색단어(searchValue)를 입력 했는지? 검증!
			let v1 = document.getElementById("searchValue").value;
			if(v1.trim().length<1){
				alert("검색단어를 입력하세요");
			}
			frm.submit();
		}
	</script>
</body>
</html>