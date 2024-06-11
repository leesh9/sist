package bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.CommDao;
import mybatis.vo.CommVO;

public class CommWriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String b_idx = request.getParameter("b_idx");
		String cPage = request.getParameter("cPage");
		String ip = request.getRemoteAddr();
		String bname = request.getParameter("bname");

		CommVO cvo = new CommVO();
		cvo.setWriter(writer);
		cvo.setContent(content);
		cvo.setPwd(pwd);
		cvo.setB_idx(b_idx);
		cvo.setIp(ip);

		CommDao.add(cvo);
		
		return "Controller?type=view&bname="+bname+"&idx="+b_idx+"&cPage="+cPage;
	}

}
