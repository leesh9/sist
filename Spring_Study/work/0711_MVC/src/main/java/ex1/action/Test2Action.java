package ex1.action;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Test2Action implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Request에 저장할 현재 날짜를 구하자!
//		Date now = new Date(System.currentTimeMillis());
		LocalDate now = LocalDate.now();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("now",now.toString());
		
		//뷰 페이지 지정
		mv.setViewName("ex2");// WEB-INF/jsp/ex2.jsp
		return mv;
	}
}
