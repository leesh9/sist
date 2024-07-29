<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#t1 {
    border-collapse: collapse;
    width: 400px;
}

#t1 caption {
    text-indent: -9999px;
    height: 0;
}

#t1 th, #t1 td {
    border: 1px solid black;
    padding: 4px;
}

#t1 thead tr {
    background-color: #cdcdcd;
}
</style>
<link rel="stylesheet"
    href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
</head>
<body>
    <table id="t1">
        <!-- empno, ename, job, mgr, hiredate, sal, comm, deptno -->
        <tr>
            <td colspan="5">
                <form action="emp_search" method="post">
                    <select name="type" id="type">
                        <option value="0">사번</option>
                        <option value="1">이름</option>
                        <option value="2">부서코드</option>
                    </select> <input type="text" name="value" id="value" />
                    <button type="submit">검색</button>
                </form>
            </td>
        </tr>
        <thead>
            <tr>
                <th>empno</th>
                <th>ename</th>
                <th>job</th>
                <th>mgr</th>
                <th>hiredate</th>
                <th>sal</th>
                <th>comm</th>
                <th>deptno</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="emp" items="${ar}">
                <tr onclick="viewData(this)">
                    <td>${emp.empno}</td>
                    <td>${emp.ename}</td>
                    <td>${emp.job}</td>
                    <td>${emp.mgr}</td>
                    <td>${emp.hiredate}</td>
                    <td>${emp.sal}</td>
                    <td>${emp.comm}</td>
                    <td>${emp.deptno}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div id="dialog" title="Employee Info" style="display: none;">
        <p id="dialog-content">
           <table id="t1">
               <thead>
                   <tr>
                       <th>empno</th>
                       <th>ename</th>
                       <th>job</th>
                       <th>mgr</th>
                       <th>hiredate</th>
                       <th>sal</th>
                       <th>comm</th>
                       <th>deptno</th>
                   </tr>
               </thead>
              <tbody>
               </tbody>
           </table>
        </p>
    </div>

    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.13.3/jquery-ui.js"></script>
    <script>
        $(document).ready(function() {
            function sendData(ff) {
                // 유효성 검사 비동기식 통신
                let t = $("#type").val();
                let v = $("#value").val();
                $.ajax({
                    url: "emp_search",
                    type: "post",
                    data: {"searchType": t, "searchValue": v},
                    dataType: "json",
                }).done(function(res) {
                    let tbody = $("#t1 tbody");
                    let str = "";
                    for (let i = 0; i < res.ar.length; i++) {
                        str += "<tr onclick='viewData(this)'><td>";
                        str += res.ar[i].empno;
                        str += "</td>";
                        str += "<td>";
                        str += res.ar[i].ename;
                        str += "</a></td>";
                        str += "<td>";
                        str += res.ar[i].job;
                        str += "</td>";
                        str += "<td>";
                        str += res.ar[i].mgr;
                        str += "</td>";
                        str += "<td>";
                        str += res.ar[i].hiredate;
                        str += "</td>";
                        str += "<td>";
                        str += res.ar[i].sal;
                        str += "</td>";
                        str += "<td>";
                        str += res.ar[i].comm;
                        str += "</td>";
                        str += "<td>";
                        str += res.ar[i].deptno;
                        str += "</td></tr>";
                    }
                    tbody.html(str);
                });
            }

            function viewData(tr) {
                let td_ar = $(tr).children();
                let str = "<tr>";
                for (let i = 0; i < td_ar.length; i++) {
                    str += "<td>";
                    str += td_ar.eq(i).text();
                    console.log(td_ar.eq(i).text)
                    str += "</td>";
                }
                    
                str += "</tr>";
                $("#dialog-content table tbody").html(str); // 다이얼로그의 테이블에 데이터 설정
                $("#dialog").dialog("open"); // 다이얼로그 열기
            }

            $("#dialog").dialog({
                autoOpen: false
            });

            // 전역으로 viewData 함수를 노출
            window.viewData = viewData;
        });
    </script>
</body>
</html>