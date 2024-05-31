package ex3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("msg", "테스트 엑션입니다.");
		
		return "ex3/page1.jsp";
	}

}
