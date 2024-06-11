package bbs.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class ViewAction implements Action{

	List<BbsVO> r_list;

	public boolean checkBbs(BbsVO bvo) {
		//인자로 받은 vo가 r_list에 저장되었다면 이전에 한번 읽기한 게시물이다.
		boolean value = true;
		for(BbsVO vo : r_list) {
			if(vo.getB_idx() == bvo.getB_idx()) {
				//이미 읽기한 게시물이다.
				value = false;
				break;//반복문 탈출
			}
		}
		return value;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String bname=request.getParameter("bname");
		String idx=request.getParameter("idx");

		//세션을 얻어내자!
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("read_list");
		if(obj == null) {
			r_list = new ArrayList<BbsVO>();
			//생성된 List를 세션에 "read_list"라는 이름으로 저장한다.
			session.setAttribute("read_list", r_list);
		}else {
			r_list = (List<BbsVO>)obj;
		}

		
		BbsVO bvo = BbsDAO.view(Integer.parseInt(idx));
		if(checkBbs(bvo)) {
			BbsDAO.hit(idx);//조회수 증가
			r_list.add(bvo);//읽기한 게시물 저장
		}
		
		request.setAttribute("bvo", bvo);

		return "/jsp/"+bname+"/view.jsp";
	}

	
}
