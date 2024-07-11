package ex1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Test3Action implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String v1 = req.getParameter("v1");
		ModelAndView mv = new ModelAndView();
		if(v1.equals("admin")) {
			mv.addObject("result", "관리자");	
		}else{
			mv.addObject("result", "사용자");
		}
		mv.setViewName("ex3");
		
		return mv;
	}
}
