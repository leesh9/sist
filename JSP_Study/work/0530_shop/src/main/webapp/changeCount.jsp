<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cart" class="shop.bean.Cart" scope="session"/>
<%
	String cnt = request.getParameter("count");
	String pnum = request.getParameter("p_num");
	if(cnt != null && pnum !=null){
		int q = Integer.parseInt(cnt);
		if(q<1)
			cart.delProduct(pnum);
		else
			cart.changeCount(pnum, q);
	}
	response.sendRedirect("cartList.jsp");
%>