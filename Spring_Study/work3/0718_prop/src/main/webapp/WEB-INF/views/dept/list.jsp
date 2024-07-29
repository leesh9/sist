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
	<h1>부서목록</h1>
	<hr/>
	<div>
		<form action="dept/serch" method="post">
			<select name="searchType" id="searchType">
				<option value="0">부서코드</option>
				<option value="1">부서명</option>
				<option value="2">도시코드</option>
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
			<th>부서코드</th>
			<th>부서명</th>
			<th>도시코드</th>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.deptno }</td>
					<td>${vo.dname }</td>
					<td>${vo.loc_code }</td>
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
					 url: 'search',
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
                        tbody += "<tr>";
                        tbody += "<td>" + item.deptno + "</td>";
                        tbody += "<td>" + item.dname + "</td>";
                        tbody += "<td>" + item.loc_code + "</td>";
                        tbody += "</tr>";
                    });
                    $("#t1 tbody").html(tbody);
				});
			});
		});
	</script>
</body>
</html>