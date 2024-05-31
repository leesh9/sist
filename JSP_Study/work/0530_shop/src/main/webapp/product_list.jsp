<%@page import="mybatis.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div id="wrap">
        <header>
            <jsp:include page="menu.jsp"/> 
        </header>
        <article>
            <jsp:useBean id="sb" class="shop.bean.ShopBean" scope="session"/>
            <jsp:setProperty property="*" name="sb"/>
            <%
                sb.searchProduct();

                ProductVO[] ar =sb.getP_list();
            %>
            <table class="table">
                <caption> 제품목록 테이블</caption>
                <colgroup>
                	<col width="90px"/>
                	<col width="110px"/>
                	<col width="*"/>
                	<col width="100px"/>
                	<col width="100px"/>
                </colgroup>
                <thead>
                    <tr bgcolor="#dedede">
                        <th>제품번호</th>
                        <th>이미지</th>
                        <th>제품명</th>
                        <th>제품가격</th>
                        <th>비고</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    if(ar !=null){ 
                        for(ProductVO vo: ar){  
                %> 
                    <tr align="center">
                        <td><%=vo.getP_num()%></td>
                        <td><img src="images/<%=vo.getP_image_s()%>" width="100" height="100"></td>
                        <td>
                            <a href="product_content.jsp?p_num=<%=vo.getP_num()%>"><%=vo.getP_name()%></a>
                        </td>
                        <td>할인가:<%=vo.getP_saleprice()%>원<pre class="red_txt">(<%=vo.getPercent() %>%)</pre></td>
                        <td>정가:<%=vo.getP_price()%>원</td>
                    </tr>
                        <%
                        }
                    }
                %>

                </tbody>




            </table>
        </article>
    </div>
</body>
</html>