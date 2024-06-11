package bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.BbsDAO;

public class DeleteAction implements Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String b_idx = request.getParameter("b_idx");
        String cPage = request.getParameter("cPage");
        String bname = request.getParameter("bname");

		BbsDAO.delete(b_idx);

		return "Controller?type=list&bname="+bname+"&cpage="+cPage;
	}
	
}
