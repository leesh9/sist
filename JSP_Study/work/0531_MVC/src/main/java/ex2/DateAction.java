package ex2;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateAction implements Action{
	
	public String exe(HttpServletRequest request, HttpServletResponse response) {
		LocalDate date = LocalDate.now();
		request.setAttribute("date", date.toString());
		
		//forward할 JSP경로를 반환하자!
		return "/exe2/page2.jsp";
	}
}
