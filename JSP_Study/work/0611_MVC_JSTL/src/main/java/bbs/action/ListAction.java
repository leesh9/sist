package bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//페이징 처리를 위한 객체 생성
		Paging page= new Paging(5,3);
		String cpage = request.getParameter("cpage");
		String bname = request.getParameter("bname");
		
		//전체 페이지 수를 구하기
		page.setTotalRecord(BbsDAO.getCount(bname));
		
		
		if(cpage!=null) {
			page.setNowPage(Integer.parseInt(cpage));
			//이때!
			//게시물을 추출할 때 사용 되는 begin과 end가 구해지고
			//시작페이지(startPage)와 끝페이지(endPage)도 구해졌다.
		}else {
			page.setNowPage(1);
		}
		BbsVO[] ar = BbsDAO.getList(bname, page.getBegin(), page.getEnd());
		request.setAttribute("ar", ar);
		request.setAttribute("page", page);
		return "/jsp/"+bname+"/list.jsp"; 
	}

}
