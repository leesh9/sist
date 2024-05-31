<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#t1{
		width: 500px;
		border-collapse: collapse;
	}
	#t1 th{
		border: : 1px solid; #999999;
		padding: 4px;
		background-color: #dedede;
	}
	#t1 td{
		border: : 1px solid; #999999;
		padding: 4px;
	}
	#t1 caption {
		text-indent: -9999px;
	}
</style>
</head>
<body>
	<div id="wrap">
		<header><h1>비동기식 통신연습</h1></header>
		<article>
			<button type="button" id="btn">목록</button>
			<div>
				<select id="s_type">
					<option>::선택::</option>
					<option value="1">사번</option>
					<option value="2">이름</option>
					<option value="3">직종</option>
					<option value="4">부서</option>
				</select>
				<input type="text" id="s_value"/>
				<button type="button" id="s_btn">검색</button>
			</div>
			<table id="t1">
				<caption>사원목록테이블</caption>
				<thead>
					<tr>
						<th>번호</th>
						<th>사번</th>
						<th>이름</th>
						<th>직종</th>
						<th>입사일</th>
						<th>부서코드</th>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
		</article>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(function(){
			$("#btn").click(function() {
				$.ajax({
					url: "ex3_ajax.jsp", //호출하고자 하는 url
					type: "get",// 요청 타입
				}).done(function(data){//서버로부터 전달되어오는 결과를 인자로 받는다.
					$("#t1 tbody").html(data);
				});
			});
			
			//검색기능
			$("#s_btn").click(function() {
				//파라미터들 준비
				let s_type = $("#s_type").val();
				let s_value = $("#s_value").val();
				
				//유효성 검사 생략
				
				//전달할 파라미터 값 준비
				let data="s_type="+encodeURIComponent(s_type)+
						 "&s_value="+encodeURIComponent(s_value);
				
				$.ajax({
					url: "ex3_search.jsp", //호출하고자 하는 url
					type: "get",// 요청 타입
					data: data,
				}).done(function(data){//서버로부터 전달되어오는 결과를 인자로 받는다.
					$("#t1 tbody").html(data);
				});
			});
		});
	</script>
</body>
</html>