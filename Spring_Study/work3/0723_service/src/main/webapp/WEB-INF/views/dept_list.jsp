<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#t1{
		border-collapse: collapse;
		width: 400px;
	}
	#t1 caption{
		text-indent: -9999px;
		height: 0;
	}
	#t1 th, #t1 td{
		border: 1px solid black;
		padding: 4px;
	}
	#t1 thead tr{
		background-color: #cdcdcd;
	}
	
	.modal_bg {
		
		display: none;
		width: 100%;
		height: 100%;
		position: fixed; 
		top: 0;
		left: 0;
		right: 0;
		background: rgba(0, 0, 0, 0.6);
		z-index: 999; 

	}
	
	.modal_wrap {
		
		display: none;
		position: absolute; 
		top: 50%;
		left: 50%;
		transform:translate(-50%,-50%);
		width: 400px;
		height: 400px;
		background: #fff;
		z-index: 1000; 

	}
	.modal_btn{text-align: center;}
	
	.table{
		border-collapse: collapse;
		width: 380px;
		margin: auto;
	}
	.table th, .table td{
		border: 1px solid black;
		padding: 4px;
	}
	.table thead tr{
		background-color: #cdcdcd;
	}
</style>
</head>
<body>
	<h1>부서목록</h1>
	<hr/>
	<div>
		<form action="dept/search" method="post">
			<select name="searchType" id="type">
				<option value="0">부서코드</option>
				<option value="1">부서명</option>
				<option value="2">도시코드</option>
			</select>
			<input type="text" name="searchValue" id="value"/>
			<button type="button" onclick="sendData(this.form)">
				검색
			</button>
		</form>
	</div>
	<table id="t1">
		<caption>부서목록테이블</caption>
		<thead>
			<tr>
				<th>부서코드</th>
				<th>부서명</th>
				<th>도시코드</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${ar }">
			<tr>
				<td>${vo.deptno }</td>
				<td>${vo.dname }</td>
				<td>${vo.loc_code }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	
	<!-- 모달팝업 -->
	<div class="modal_bg" onClick="javascript:popClose();"></div>
	<div class="modal_wrap">
		<header>
			<h2>모달창</h2>
		</header>
		<table class="table">
			<thead>
				<tr>
					<th>사번</th>
					<th>이름</th>
					<th>직종</th>
					<th>입사일</th>
					<th>부서코드</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
		<div class="modal_btn">
			<button class="modal_close" 
				onClick="popClose();">닫기</button>		
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script>
		$(function(){
			$("#t1 tbody tr").click(function(){
				viewData();
			});
		});
	
		function sendData(ff){
			
			//유효성 검사
			let t = $("#type").val();
			let v = $("#value").val();
			
			//비동기식 통신
			$.ajax({
				url:"dept/search",
				type: "post",
				data:{"searchType":t , "searchValue":v},
				dataType:"json",
			}).done(function(res){
				//console.log(res.len);
				
				//let tbody = $("#t1 tbody");
				
				let str = "";
				for(let i=0; i<res.len; i++){
					str += "<tr><td>";
					str += res.ar[i].deptno;
					str += "</td>";
					str += "<td>";
					str += res.ar[i].dname;
					str += "</td>";
					str += "<td>";
					str += res.ar[i].loc_code;
					str += "</td></tr>";
				}
				//tbody.html(str);
				$("#t1 tbody").html(str);
			});
		}
		
		function popOpen() {

		    var modalPop = $('.modal_wrap');
		    var modalBg = $('.modal_bg'); 

		    $(modalPop).show();
		    $(modalBg).show();

		}

		 function popClose() {
		   var modalPop = $('.modal_wrap');
		   var modalBg = $('.modal_bg');

		   $(modalPop).hide();
		   $(modalBg).hide();

		}
		 
		function viewData(){
			popOpen();
		}
	</script>
</body>
</html>








