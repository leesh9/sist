package ex1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class Test1Action extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// jsp에서 표현할 정보를 request에 저장
		request.setAttribute("msg", "환영합니다.");
		// 반환객체 생성
		ModelAndView mv = new ModelAndView();
		
		//mv에 필요한 정보를 저장! -- jsp에서 활용할 수 있다
		mv.addObject("str","spring MVC연습");
		//위는 requset에 저장되었다.
		
		//forward할 jsp를 ModelAndView에 지정한다.
		mv.setViewName("ex1");// WEB-INF/jsp/ex1.jsp를 의미함
		
		return mv;
	}

}
