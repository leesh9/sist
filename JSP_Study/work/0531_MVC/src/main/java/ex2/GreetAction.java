package ex2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetAction implements Action {
	 
	public String exe(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg", "MVC를 시작합니다.");
		
		//forward할 JSP경로를 반환하자!
		return "/exe2/page1.jsp";
	}
}
