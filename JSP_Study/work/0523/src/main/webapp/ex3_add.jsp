<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table caption {
	text-indent: -9999px;
}
</style>
</head>
<body>
	<div id="wrap">
		<header>
			<h1>부서추가</h1>
		</header>
		<article>
			<form action="ex3_add_ok.jsp" method="post">
				<table>
					<caption>부서추가 테이블</caption>
					<colgroup>
						<col width="80px"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<td><label for="deptno">부서코드</label></td>
							<td>
								<input type="text" id="deptno" name="deptno"/>
							</td>
						</tr>
						<tr>
							<td><label for="deptno">부서명</label></td>
							<td>
								<input type="text" id="dname" name="dname"/>
							</td>
						</tr>
						<tr>
							<td><label for="deptno">도시코드</label></td>
							<td>
								<input type="text" id="loc" name="loc"/>
								<input type="hidden" id="ip" name="ip" value="<%= request.getRemoteAddr() %>"/>
								
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button type="button" onclick="exe()">보내기</button>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</article>
	</div>
	<script type="text/javascript">
		function exe() {
			document.forms[0].submit();
		}
	</script>
</body>
</html>