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
			<button type="button" id="btn">비동기식 통신</button>
			<table id="t1">
				<caption>번호테이블</caption>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>등급</th>
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
			cnt = 10;
			let test = "테스트";
			$("#btn").click(function() {
				$.ajax({
					url: "ex2_ajax.jsp", //호출하고자 하는 url
					type: "get",// 요청 타입
					data: "count="+encodeURIComponent(cnt)+
						  "&test="+encodeURIComponent(test)//인자전달
				}).done(function(data){//서버로부터 전달되어오는 결과를 인자로 받는다.
					$("#t1 tbody").html(data);
				});
			});
		});
	</script>
</body>
</html>