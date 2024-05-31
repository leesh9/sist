package ex3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// SqlSession 또는 DAO를 이용하여 DB정보 가져올 수 있다.
		
		request.setAttribute("msg", "GreetAction 활용");
		
		return "/ex3/page1.jsp";
	}

}
