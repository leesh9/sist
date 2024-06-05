package bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class ViewAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String bname=request.getParameter("bname");
		String idx=request.getParameter("idx");
		
		BbsVO bvo = BbsDAO.view(Integer.parseInt(idx));
		
		request.setAttribute("bvo", bvo);

		return "/jsp/bbs/view.jsp";
	}

	
}
