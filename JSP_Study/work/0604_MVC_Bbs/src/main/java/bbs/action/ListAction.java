package bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		String bname = request.getParameter("bname");
		if(page==null) {
			page="1";
		}
		
		int p = Integer.parseInt(page);
		int begin = p*10-9;
		int end = p*10;
		BbsVO[] ar = BbsDAO.getList(bname, begin, end);
		request.setAttribute("ar", ar);
		return "/jsp/"+bname+"/list.jsp"; 
	}

}
