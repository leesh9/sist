<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#t1{
		border-collapse: collapse;
		width: 400px;
	}
	#t1 caption {
	text-align: -9999px;
	height: 0;
	}
	#t1 th, #t1 td{
		border: 1px solid black;
		padding: 4px
	}
	#t1 thead tr{
		background-color: #cdcdcd;
	}
</style>
</head>
<body>
	<h1>사원	목록</h1>
	<hr/>
	<div>
		<form action="dept/serch" method="post">
			<select name="searchType" id="searchType">
				<option value="0">사원코드</option>
				<option value="1">이름</option>
				<option value="2">직종</option>
			</select>
			<input type="text" name="searchValue" id="searchValue">
			<button id="search_btn" type="button">
				검색
			</button>
		</form>
	</div>
	<table id="t1">
		<caption>부서목록테이블</caption>
		<thead>
			<th>사원코드</th>
			<th>이름</th>
			<th>직종</th>
			<th>메니저</th>
			<th>고용일</th>
			<th>연봉</th>
			<th>보너스</th>
			<th>부서코드</th>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list }">
				<tr class="emp_tuple">
					<td class="empno">${vo.empno }</td>
					<td class="ename">${vo.ename }</td>
					<td class="job">${vo.job }</td>
					<td class="mgr">${vo.mgr }</td>
					<td class="hiredate">${vo.hiredate }</td>
					<td class="sal">${vo.sal }</td>
					<td class="comm">${vo.comm }</td>
					<td class="deptno">${vo.deptno }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(function(){
			$('#search_btn').on('click', function() {
				let tbody = [];	
				$.ajax({
					 url: 'emp_search',
	                 method: 'POST',
	                 dataType: 'json',
					data:{
						searchType:$("#searchType").val(),
						searchValue:$("#searchValue").val(),
					}
				}).done(function(data){
					let tbody = "";
                    console.log(data); // 응답 데이터 확인용
                    data.forEach(function(item) {
                        tbody += '<tr>';
                        tbody += "<td class='empno'>" + item.empno + "</td>";
                        tbody += "<td class='ename'>" + item.ename + "</td>";
                        tbody += "<td class='job'>" + item.job + "</td>";
                        tbody += "<td class='mgr'>" + item.mgr + "</td>";
                        tbody += "<td class='hiredate'>" + item.hiredate + "</td>";
                        tbody += "<td class='sal'>" + item.sal  + "</td>";
                        tbody += "<td class='comm'>" + item.comm + "</td>";
                        tbody += "<td class='deptno'>" + item.deptno + "</td>";
                        tbody += "</tr>";
                    });
                    $("#t1 tbody").html(tbody);
				});
			});
			
			$("#t1 tbody tr").on('click',function(){
				console.log("1")
				let url="http://localhost:8080/prop/emp_detail?"
				// 부모 요소 내의 자식 요소들을 순회
				$(this).children().each(function(index) {
				    url+=$(this).attr('class');
				    url+="=";
				    url+=$(this).text();
				    if (index !== $('#parent-element').children().length - 1) {
				        url+="&"
				    }
				});
				http://localhost:8080/prop/emp_detail?
				window.open(url, "new", "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=200, height=250, left=500, top=150");

			})
		});
	</script>
</body>
</html>